package com.tribe.Tribes.village;


import com.tribe.Tribes.village.buildings.Building;
import com.tribe.Tribes.village.buildings.BuildingController;
import com.tribe.Tribes.village.buildings.BuildingDTO;
import com.tribe.Tribes.village.units.SoldierUnitDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/villages")
public class VillageController {

    private static ModelMapper modelMapper = new ModelMapper();
    private VillageService villageService;

    @Autowired
    public VillageController(VillageService villageService) {
        this.villageService = villageService;
    }

    @GetMapping
    public List<VillageDTO> getAllVillages(){
        List<Village> villages = villageService.getAllVillages();
        return villages.stream()
                .map(VillageController::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{playerId}/number-of-villages")
    public int getNumberOfVillagesForPlayer(@PathVariable Integer playerId){
        return villageService.getNumberOfVillagesForPlayer(playerId);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public VillageDTO getVillage(@PathVariable("id") Integer id){

        return convertToDto(villageService.getVillageById(id));

        /*
        List<Village> villages = villageService.getAllVillages();

        return villages.stream()
                .filter(village -> village.getId() == id)
                .map(village -> convertToDto(village))
                .collect(Collectors.toList()).get(0);*/
    }

    @DeleteMapping("{villageId}")
    public VillageDTO deleteVillage(@PathVariable("villageId") Integer villageId){

        Village villageEntity = villageService.deleteVillage(villageId);
        return convertToDto(villageEntity);
    }

    @PutMapping("/{villageId}")
    @ResponseBody
    public VillageDTO addVillageToPlayer(@PathVariable Integer villageId, Integer playerId){
        Village village = villageService.addVillageToPlayer(villageId, playerId);
        return convertToDto(village);
    }

    @PutMapping
    @ResponseBody
    public VillageDTO updateVillage(@RequestBody VillageDTO villageDTO){

        Village villageEntity = convertToEntity(villageDTO);

        return convertToDto(villageService.updateVillage(villageEntity));
    }

    @GetMapping("/{villageId}/buildings")
    @ResponseBody
    public List<BuildingDTO> getBuildingsOfVillage(@PathVariable("villageId") Integer villageId){

        Village villageEntity = villageService.getVillageById(villageId);

        List<Building> buildings = villageEntity.getBuildings();

        return buildings
                .stream().distinct()
                .map(BuildingController::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{villageId}/buildings/{buildingId")
    @ResponseBody
    public BuildingDTO getOneBuildingOfVillage(@PathVariable Integer villageId, @PathVariable Integer buildingId){
        Village villageEntity = villageService.getVillageById(villageId);

        Building building = villageEntity.getBuildingById(buildingId);

        return BuildingController.convertToDto(building);
    }

    @PatchMapping("/{villageId}")
    public VillageDTO partialUpdateNumberOfSoldiers(@PathVariable Integer villageId, @RequestBody SoldierUnitDTO partialUpdate){

        Village updatedVillage = villageService.partialUpdateNumberOfSoldiers(villageId, partialUpdate);

        return convertToDto(updatedVillage);
    }

    public static Village convertToEntity(VillageDTO villageDto) {
        Village village = modelMapper.map(villageDto, Village.class);
        return village;
    }
    
    public static VillageDTO convertToDto(Village village) {

        VillageDTO villageDto = modelMapper.map(village, VillageDTO.class);

        /*List<Building> s = village.getBuildings();


        villageDto.setBuildingsId(village.getBuildings()
                .stream().distinct()
                .map(Building::getId)
                .collect(Collectors.toList()));
*/
        List<BuildingDTO> buildings = new ArrayList<>();

        for (Building building: village.getBuildings()) {
            buildings.add(BuildingController.convertToDto(building));

        }



        villageDto.setBuildings(buildings.subList(0,13));

        //villageDto.setOwnerPlayerId( (village.getOwnerPlayer() == null) ? null : village.getOwnerPlayer().getId());
/*
        villageDto.setBuildingsLevel(village.getBuildings()
                .stream()
                .map(Building::getLevel)
                .collect(Collectors.toList()).subList(0,13));
*/
        return villageDto;
    }
    
}
