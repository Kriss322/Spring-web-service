package com.tribe.Tribes.village;

import com.tribe.Tribes.village.buildings.Building;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
                .map(village -> convertToDto(village))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public VillageDTO getVillage(@PathVariable("id") Integer id){
        return convertToDto(villageService.getVillageById(id));
    }

    @DeleteMapping("/{villageId}")
    public VillageDTO deleteVillage(@PathVariable Integer villageId){

        Village villageEntity = villageService.deleteVillage(villageId);
        return convertToDto(villageEntity);
    }



    public static Village convertToEntity(VillageDTO villageDto) {
        Village village = modelMapper.map(villageDto, Village.class);
        return village;
    }
    
    public static VillageDTO convertToDto(Village village) {

        VillageDTO villageDto = modelMapper.map(village, VillageDTO.class);

        villageDto.setBuildingsId(village.getBuildings()
                .stream()
                .map(Building::getId)
                .collect(Collectors.toList()));

        villageDto.setOwnerPlayerId( (village.getOwnerPlayer() == null) ? null : village.getOwnerPlayer().getId());

        villageDto.setBuildingsLevel(village.getBuildings()
                .stream()
                .map(Building::getLevel)
                .collect(Collectors.toList()));

        return villageDto;
    }
    
}
