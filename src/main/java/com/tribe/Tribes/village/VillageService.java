package com.tribe.Tribes.village;

import java.util.ArrayList;
import java.util.List;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.player.PlayerRepository;
import com.tribe.Tribes.player.PlayerService;
import com.tribe.Tribes.village.buildings.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class VillageService {

    private final PlayerRepository playerRepository;

    private final VillageRepository villageRepository;

    private final BuildingRepository buildingRepository;
    
    @Autowired
    public VillageService(VillageRepository villageRepository,PlayerRepository playerRepository, BuildingRepository buildingRepository) {
        this.villageRepository = villageRepository;
        this.playerRepository = playerRepository;
        this.buildingRepository = buildingRepository;
    }
    
    public Village getVillageById(Integer id) {
        return villageRepository.getOne(id);
    }
    
    public List<Village> getAllVillages() {
        return villageRepository.findAll();
    }
    

    public Village addNewVillage(Player player) {
        Village newVillage = (this.createVillage(player));
        return villageRepository.save(newVillage);
    }

    public Village createVillage(Player newPlayer){
        WorldPosition position = new WorldPosition();

        //Set random coordinates
        position.setXPosition((int) (Math.random()*99+1));
        position.setYPosition((int) (Math.random()*99+1));
        position.setZPosition((int) (Math.random()*99+1));

        Resources resources = new Resources(500,500,500);
        ResourceProduction resourceProduction = new ResourceProduction(100,100,100);

        List<Building> starterBuildings = new ArrayList<>();

        Village villageToCreate = new Village();

        //CREATE BUILDING REPOSITORY

        villageToCreate.setName("Village_1");
        villageToCreate.setOwnerPlayer(newPlayer);
        villageToCreate.setResourceProducementPerHour(resourceProduction);
        villageToCreate.setPosition(position);
        villageToCreate.setResourcesInWarehouse(new Resources(1000,1000,1000));
        villageToCreate.setVillagePoints(60);

        this.initializeBuildings(villageToCreate);

        List<Village> villageList = new ArrayList<>();
        villageList.add(villageToCreate);

        newPlayer.setVillages(villageList);
        playerRepository.save(newPlayer);
        villageRepository.save(villageToCreate);

        villageToCreate.getBuildings().stream().forEach(building -> buildingRepository.save(building));
        villageToCreate.getBuildings().stream().forEach(building -> building.setStarterSettings());
        villageToCreate.getBuildings().stream().forEach(building -> buildingRepository.save(building));

        //Player playerToUpdate = playerRepository.findById(newPlayer.getId()).get();
        playerRepository.save(newPlayer);

        return villageRepository.save(villageToCreate);
    }

    public void initializeBuildings(Village village){



        List<Building> starterBuildingList = new ArrayList<Building>(){{

            add(new VillageHeadquarters(village));
            add(new Stables(village));
            add(new Academy(village));
            add(new Barracks(village));
            add(new ClayPit(village));
            add(new Farm(village));
            add(new IronMine(village));
            add(new Market(village));
            add(new RallyPoint(village));
            add(new Smithy(village));
            add(new TimberCamp(village));
            add(new Wall(village));
            add(new Warehouse(village));
            add(new Workshop(village));

        }};

        village.setBuildings(starterBuildingList);

    }

    public List<Village> getVillageByPlayerId(Integer id) {
        Player player = playerRepository.getOne(id);
        return villageRepository.getVillageByPlayerId(player);
    }
}
