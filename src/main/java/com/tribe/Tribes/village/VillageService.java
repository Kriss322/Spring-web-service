package com.tribe.Tribes.village;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
