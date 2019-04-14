package com.tribe.Tribes.village;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.village.buildings.Academy;
import com.tribe.Tribes.village.buildings.Building;
import com.tribe.Tribes.village.units.SoldierUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VillageService {
    
    private final VillageRepository villageRepository;
    
    @Autowired
    public VillageService(VillageRepository villageRepository) {
        this.villageRepository = villageRepository;
    }
    
    public Village getVillageById(Integer id) {
        return villageRepository.getOne(id);
    }
    
    public List<Village> getAllVillages() {
        return villageRepository.findAll();
    }
    

    public Village addNewVillage(Village newVillage) {
        //TODO set villages
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
        starterBuildings.add(new Academy());

        Village villageToCreate = new Village(null, "Village1", 125, newPlayer, position, 50, resources, resourceProduction, null,,1);


        villageToCreate.
        return villageRepository.save(villageToCreate);
    }
}
