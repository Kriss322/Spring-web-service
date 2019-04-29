package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository){
        this.buildingRepository = buildingRepository;
    }

    public Building getBuildingById(Integer id){
        return buildingRepository.getOne(id);
    }

    public List<Building> getAllBuildings(){
        return buildingRepository.findAll();
    }



}
