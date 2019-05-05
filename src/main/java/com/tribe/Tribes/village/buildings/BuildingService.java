package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.ResourceProduction;
import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;
import com.tribe.Tribes.village.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    private final VillageRepository villageRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository, VillageRepository villageRepository){
        this.buildingRepository = buildingRepository;
        this.villageRepository = villageRepository;
    }

    public Building getBuildingById(Integer id){
        return buildingRepository.getOne(id);
    }

    public List<Building> getAllBuildings(){
        return buildingRepository.findAll();
    }


    public Building levelUpBuilding(Integer id) {
        Building buildingToLevelUp = buildingRepository.getOne(id);

        Village ownerVillage = buildingToLevelUp.getOwnerVillage();

        Resources subtraction = buildingToLevelUp
                .getResourceRequirementsForUpgrade()
                .get(buildingToLevelUp.getLevel() + 1);

        if(ownerVillage.getResourcesInWarehouse().
                compareTo(subtraction) == 0){

            if(buildingToLevelUp.getMaxLevel() > buildingToLevelUp.getLevel() ){

                if(buildingToLevelUp.getName().equals("ClayPit")){

                    //((ClayPit) buildingToLevelUp).setProductionPerHour(((ClayPit) buildingToLevelUp).getProductionPerHour() + 30);

                    ResourceProduction prod = ownerVillage.getResourceProducementPerHour();
                    prod.addClay(30);
                    buildingToLevelUp.setProductionPerHour(buildingToLevelUp.getProductionPerHour() + 30);
                    ownerVillage.setResourceProducementPerHour(prod);
                }

                else if(buildingToLevelUp.getName().equals("IronMine")){

                    ResourceProduction prod = ownerVillage.getResourceProducementPerHour();
                    prod.addIron(30);
                    buildingToLevelUp.setProductionPerHour(buildingToLevelUp.getProductionPerHour() + 30);
                    ownerVillage.setResourceProducementPerHour(prod);
                }

                else if(buildingToLevelUp.getName().equals("TimberCamp")){

                    ResourceProduction prod = ownerVillage.getResourceProducementPerHour();
                    prod.addWood(30);
                    buildingToLevelUp.setProductionPerHour(buildingToLevelUp.getProductionPerHour() + 30);
                    ownerVillage.setResourceProducementPerHour(prod);
                }

                buildingToLevelUp.setLevel(buildingToLevelUp.getLevel() + 1);


                //TODO BUG HERE
                ownerVillage.getResourcesInWarehouse().subtract(subtraction);

                ownerVillage.setVillagePoints(buildingToLevelUp.getPointsPerLevel() + ownerVillage.getVillagePoints());
            }
        }

        villageRepository.save(ownerVillage);
        return buildingRepository.save(buildingToLevelUp);
    }
}
