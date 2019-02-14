package com.tribe.Tribes.village;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VillageController {

    @Autowired
    private VillageRepository villageRepository;
}
