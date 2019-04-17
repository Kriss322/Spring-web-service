package com.tribe.Tribes.village;

import java.util.ArrayList;
import java.util.List;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.player.PlayerRepository;
import com.tribe.Tribes.player.PlayerService;
import com.tribe.Tribes.village.buildings.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VillageService {


    private final PlayerRepository playerRepository;

    private final VillageRepository villageRepository;
    
    @Autowired
    public VillageService(VillageRepository villageRepository,PlayerRepository playerRepository) {
        this.villageRepository = villageRepository;
        this.playerRepository = playerRepository;
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
        this.initializeBuildings(villageToCreate);
        villageToCreate.setName("Village_1");
        villageToCreate.setOwnerPlayer(newPlayer);
        villageToCreate.setResourceProducementPerHour(resourceProduction);
        villageToCreate.setPosition(position);

        List<Village> villageList = new ArrayList<>();
        villageList.add(villageToCreate);

        Player playerToUpdate = playerRepository.getOne(newPlayer.getId());
        playerToUpdate.setVillages(villageList);
        playerRepository.save(playerToUpdate);

        return villageRepository.save(villageToCreate);
    }

    public List<Building> initializeBuildings(Village village){
        List<Building> starterBuildingList = new ArrayList<Building>(){{

            add(new Academy());/*
            add(new Barracks());
            add(new ClayPit());
            add(new Farm());
            add(new IronMine());
            add(new Market());
            add(new RallyPoint());
            add(new Smithy());
            add(new Stables());
            add(new TimberCamp());
            add(new VillageHeadquarters());
            add(new Wall());
            add(new Warehouse());
            add(new Workshop());*/

        }};

        village.setBuildings(starterBuildingList);

        return starterBuildingList;
    }
}
