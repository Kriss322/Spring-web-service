package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

@Embeddable
public class Market extends Building{

    private static String NAME = "Market";

    private Map<Integer, Integer> numberOfMerchants;

    public Market(){
        setStarterSettings();
    }

    @Override
    public void setStarterSettings() {

        this.level = 0;

        this.maxLevel = 25;

        this.requirements = new HashMap<String, Integer>(){{
            requirements.put("VillageHeadquarters", 3);
            requirements.put("Warehouse", 2);
        }};

        Integer numberOfMerchants = 1;
        Integer populationNeededForUpgrade = 1;
        Integer totalOfPopulation = 1;
        Integer clay = 100;
        Integer wood = 100;
        Integer iron = 100;
        for(int i = 1; i < this.maxLevel; i++){

            this.populationNeededForUpgrade.put(i, populationNeededForUpgrade);
            this.totalOfPopulation.put(i, totalOfPopulation);
            this.resourceRequirementsForUpgrade.put(i, new Resources(clay, wood, iron));
            this.numberOfMerchants.put(i, numberOfMerchants);

            clay += (int) (clay * 0.2);
            wood += (int) (wood * 0.22);
            iron += (int) (iron * 0.2);
            totalOfPopulation += populationNeededForUpgrade;
            populationNeededForUpgrade += 4;
            numberOfMerchants += 10;


        }
    }
}
