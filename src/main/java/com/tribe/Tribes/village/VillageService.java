package com.tribe.Tribes.village;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.player.PlayerRepository;
import com.tribe.Tribes.village.buildings.*;
import com.tribe.Tribes.village.units.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class VillageService {

    private final PlayerRepository playerRepository;

    private final VillageRepository villageRepository;

    private final BuildingRepository buildingRepository;

    @Autowired
    public VillageService(VillageRepository villageRepository, PlayerRepository playerRepository, BuildingRepository buildingRepository) {
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

    public Village createVillage(Player newPlayer) {
        WorldPosition position = new WorldPosition();

        //Set random coordinates
        position.setXPosition((int) (Math.random() * 99 + 1));
        position.setYPosition((int) (Math.random() * 99 + 1));
        position.setZPosition((int) (Math.random() * 99 + 1));

        Resources resources = new Resources(500, 500, 500);
        ResourceProduction resourceProduction = new ResourceProduction(30, 30, 30);

        Village villageToCreate = new Village();

        villageToCreate.setName(newPlayer.getName() + " faluja ");
        villageToCreate.setOwnerPlayer(newPlayer);
        villageToCreate.setResourceProducementPerHour(resourceProduction);
        villageToCreate.setPosition(position);
        villageToCreate.setResourcesInWarehouse(resources);
        villageToCreate.setVillagePoints(60);

        /*
        villageToCreate.addToArmy(new Axeman(10));
        villageToCreate.addToArmy(new SpearFighter(20));
        */

        this.initializeArmy(villageToCreate);
        this.initializeBuildings(villageToCreate);


        List<Village> villageList = new ArrayList<>();
        villageList.add(villageToCreate);

        newPlayer.setVillages(villageList);
        newPlayer.setPlayerPoints(60);
        playerRepository.save(newPlayer);
        villageRepository.save(villageToCreate);

        villageToCreate.getBuildings().stream().forEach(building -> buildingRepository.save(building));
        villageToCreate.getBuildings().stream().forEach(building -> building.setStarterSettings());
        villageToCreate.getBuildings().stream().forEach(building -> buildingRepository.save(building));
        villageToCreate.setMaxPopulation(3);

        //Player playerToUpdate = playerRepository.findById(newPlayer.getId()).get();
        playerRepository.save(newPlayer);

        return villageRepository.save(villageToCreate);
    }

    public void initializeArmy(Village village) {

        List<SoldierUnit> starterArmy = new ArrayList<SoldierUnit>() {{
            add(new Axeman(10));
            add(new SpearFighter(20));
            add(new Archer());
            add(new Catapult());
            add(new HeavyCavalry());
            add(new LightCavarly());
            add(new MountedArcher());
            add(new Nobleman());
            add(new Ram());
            add(new Scout());
            add(new Swordsman());
        }};

        starterArmy.forEach(village::addToArmy);
    }

    public void initializeBuildings(Village village) {

        List<Building> starterBuildingList = new ArrayList<Building>() {{

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

    public Village getOneVillageOfPlayer(Integer playerId, Integer villageId) {
        Player player = playerRepository.getOne(playerId);
        return villageRepository.getOneVillageOfPlayer(player, villageId);
    }

    public List<Village> setAbandonedVillages(Integer playerId) {
        Player player = playerRepository.getOne(playerId);
        List<Village> villagesToAbandon = villageRepository.getVillageByPlayerId(player);

        for (Village village : villagesToAbandon) {

            village.setOwnerPlayer(null);
            village.setName("Abandoned village");
        }

        return villageRepository.saveAll(villagesToAbandon);
    }

    public Village deleteVillage(Integer villageId) {

        Village villageToDelete = getVillageById(villageId);

        villageRepository.delete(villageToDelete);

        return villageToDelete;
    }

    @Async
    public void updateResources(List<Village> villages) {

        //TODO beautify this
        for (Village village : villages) {

            Resources currentResourcesInWarehouse = village.getResourcesInWarehouse();

            ResourceProduction currentResourceProduction = village.getResourceProducementPerHour();

            Warehouse wareHouse = (Warehouse) village.getBuildings()
                    .stream()
                    .filter(building -> building instanceof Warehouse)
                    .collect(Collectors.toList()).get(0);

            Integer maxResource = wareHouse.getCapacity().get(wareHouse.getLevel());
            if (maxResource > (village.getResourcesInWarehouse().getClay() + currentResourceProduction.getClayProdPerHour())) {

                village.setResourcesInWarehouse(
                        new Resources(
                                currentResourcesInWarehouse.getClay() + currentResourceProduction.getClayProdPerHour(),
                                currentResourcesInWarehouse.getWood(),
                                currentResourcesInWarehouse.getIron()
                        ));
                currentResourcesInWarehouse = village.getResourcesInWarehouse();
            }
            if (maxResource > (village.getResourcesInWarehouse().getWood() + currentResourceProduction.getWoodProdPerHour())) {

                village.setResourcesInWarehouse(
                        new Resources(
                                currentResourcesInWarehouse.getClay(),
                                currentResourcesInWarehouse.getWood() + currentResourceProduction.getWoodProdPerHour(),
                                currentResourcesInWarehouse.getIron()
                        ));
                currentResourcesInWarehouse = village.getResourcesInWarehouse();
            }
            if (maxResource > (village.getResourcesInWarehouse().getIron() + currentResourceProduction.getIronProdPerHour())) {

                village.setResourcesInWarehouse(
                        new Resources(
                                currentResourcesInWarehouse.getClay(),
                                currentResourcesInWarehouse.getWood(),
                                currentResourcesInWarehouse.getIron() + currentResourceProduction.getIronProdPerHour()
                        ));
                currentResourcesInWarehouse = village.getResourcesInWarehouse();
            }
        }


        villageRepository.saveAll(villages);
    }

    public Village updateVillage(Village villageEntity) {
        Village villageUpdate = villageRepository.getOne(villageEntity.getId());

        villageUpdate.setVillagePoints(villageEntity.getVillagePoints());
        villageUpdate.setMaxPopulation(villageEntity.getMaxPopulation());
        villageUpdate.setResourcesInWarehouse(villageEntity.getResourcesInWarehouse());

        villageRepository.save(villageUpdate);
        return villageUpdate;


    }

    public Village partialUpdateNumberOfSoldiers(Integer villageId, SoldierUnitDTO partialUpdate) {

        Village villageUpdate = villageRepository.getOne(villageId);

        if (checkPopulationBeforeRecruitment(villageUpdate, partialUpdate)
                && checkResourcesBeforeRecruitment(villageUpdate, partialUpdate)) {

            villageUpdate.recruitUnits(partialUpdate.getName(), partialUpdate.getNumberOfSoldiers());

        }

        villageRepository.save(villageUpdate);
        return villageUpdate;
    }

    private boolean checkResourcesBeforeRecruitment(Village village, SoldierUnitDTO partialUpdate) {
        SoldierUnit unit = village.getUnitsAtHome().stream().filter(soldierUnit -> soldierUnit.getName().equals(partialUpdate.getName())).collect(Collectors.toList()).get(0);

        Resources resourcesInVillage = village.getResourcesInWarehouse();

        Resources realCost = unit.getResourceTrainingCost().multiplyResource(partialUpdate.getNumberOfSoldiers());

        if (resourcesInVillage.compareTo(realCost) == 0) {
            village.getResourcesInWarehouse().subtract(realCost);
            village.addToCurrentPopulation(partialUpdate.getNumberOfSoldiers() * unit.getPopulation());
            //villageRepository.save(village);
            return true;
        } else return false;
    }

    public boolean checkPopulationBeforeRecruitment(Village village, SoldierUnitDTO partialUpdate) {
        SoldierUnit unit = village.getUnitsAtHome().stream().filter(soldierUnit -> soldierUnit.getName().equals(partialUpdate.getName())).collect(Collectors.toList()).get(0);

        return (village.getCurrentPopulation() + unit.getPopulation() * partialUpdate.getNumberOfSoldiers() < village.getMaxPopulation());
    }

    public Village addVillageToPlayer(Integer villageId, Integer playerId) {

        Village villageEntity = villageRepository.getOne(villageId);

        Player playerEntity = playerRepository.getOne(playerId);

        playerEntity.addVillage(villageEntity);

        villageEntity.setOwnerPlayer(playerEntity);

        villageRepository.save(villageEntity);
        playerRepository.save(playerEntity);

        return villageEntity;

    }

    public int getNumberOfVillagesForPlayer(int playerId) {
        List<Village> villages = this.getVillageByPlayerId(playerId);

        return villages.size();

    }
}
