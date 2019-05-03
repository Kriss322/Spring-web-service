package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Village;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    private static ModelMapper modelMapper = new ModelMapper();

    private BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService){
        this.buildingService = buildingService;
    }

    @GetMapping
    public List<BuildingDTO> getAllBuildings(){
        List<Building> buildings = buildingService.getAllBuildings();
        return buildings.stream()
                .map(building -> convertToDto(building))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public BuildingDTO getBuilding(@PathVariable Integer id){
        return convertToDto(buildingService.getBuildingById(id));
    }

    @PutMapping("level-up/{id}")
    @ResponseBody
    public BuildingDTO levelUpBuilding(@PathVariable Integer id){
        return convertToDto(buildingService.levelUpBuilding(id));
    }


    public static Building convertToEntity(BuildingDTO buildingDto){
        Building building = modelMapper.map(buildingDto, Building.class);
        return  building;
    }

    public static BuildingDTO convertToDto(Building building){
        BuildingDTO buildingDto = modelMapper.map(building, BuildingDTO.class);

        buildingDto.setOwnerVillageId(building
                .getOwnerVillage()
                .getId());

        buildingDto.setName(building.getName());
        return  buildingDto;
    }
}
