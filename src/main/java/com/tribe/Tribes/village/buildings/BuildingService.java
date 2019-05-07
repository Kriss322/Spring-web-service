package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.ResourceProduction;
import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;
import com.tribe.Tribes.village.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public boolean checkPopulationRequirements(Building buildingToLevelUp){

        Village ownerVillage = buildingToLevelUp.getOwnerVillage();

        return (ownerVillage.getCurrentPopulation() < ownerVillage.getMaxPopulation() || buildingToLevelUp.getName().equals("Farm"));

        //if(ownerVillage.getBuildings().stream().filter(building -> building.getName().equals("Farm")).collect(Collectors.toList()).get(0). <= buildingToLevelUp.getPopulationNeededForUpgrade().get(buildingToLevelUp.getLevel()+1) + ownerVillage.getPopulation())
    }

    public boolean checkBuildingRequirements(Building building){

        Map<String, Integer> requirements = building.getRequirements();

        boolean isRequirementsOK = true;
        for(Map.Entry<String,Integer> entry : requirements.entrySet()){

            if(!checkBuildingLevelInOwnerVillage(entry.getKey(),entry.getValue(),building.getOwnerVillage())){
                isRequirementsOK = false;
                break;
            }

        }
        return isRequirementsOK;
    }

    public boolean checkBuildingLevelInOwnerVillage(String s, Integer level, Village village){
        Building buildingInVillage = village.getBuildings()
                .stream()
                .filter(building -> building.getName().equals(s))
                .collect(Collectors.toList()).get(0);

        return (buildingInVillage.getLevel() >= level);
    }

    public Building levelUpBuilding(Integer id) {

        //TODO beautify this
        Building buildingToLevelUp = buildingRepository.findById(id).orElse(null);

        Village ownerVillage = buildingToLevelUp.getOwnerVillage();

        Resources subtraction = buildingToLevelUp
                .getResourceRequirementsForUpgrade()
                .get(buildingToLevelUp.getLevel() + 1);



        if(ownerVillage.getResourcesInWarehouse().compareTo(subtraction) == 0
                && checkBuildingRequirements(buildingToLevelUp)
                && checkPopulationRequirements(buildingToLevelUp)
                && buildingToLevelUp.getMaxLevel() > buildingToLevelUp.getLevel() ){

                if(buildingToLevelUp.getName().equals("Farm")){
                    ownerVillage.setMaxPopulation(buildingToLevelUp.getMaximumPopulation().get(buildingToLevelUp.getLevel() + 1));
                }

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

                ownerVillage.getResourcesInWarehouse().subtract(subtraction);

                ownerVillage.setVillagePoints(buildingToLevelUp.getPointsPerLevel() + ownerVillage.getVillagePoints());

                ownerVillage.getOwnerPlayer().addPoints(buildingToLevelUp.getPointsPerLevel());

                int populationToAdd = buildingToLevelUp.getTotalOfPopulation().get(buildingToLevelUp.getLevel() + 1);
                ownerVillage.addToCurrentPopulation(populationToAdd);

        }

        villageRepository.save(ownerVillage);
        return buildingRepository.save(buildingToLevelUp);
    }
}
