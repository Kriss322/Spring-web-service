package com.tribe.Tribes.village;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/villages")
public class VillageController {

    private ModelMapper modelMapper = new ModelMapper();
    private VillageService villageService;

    @Autowired
    public VillageController(VillageService villageService) {
        this.villageService = villageService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public VillageDTO getVillage(@PathVariable("id") Integer id){
        return convertToDto(villageService.getVillageById(id));
    }

    private Village convertToEntity(VillageDTO villageDto) {
        Village village = modelMapper.map(villageDto, Village.class);
        return village;
    }
    
    private VillageDTO convertToDto(Village village) {
        VillageDTO villageDto = modelMapper.map(village, VillageDTO.class);
        return villageDto;
    }
    
}
