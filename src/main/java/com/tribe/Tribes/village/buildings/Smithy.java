package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
@Entity
@DiscriminatorValue("Smithy")
public class Smithy extends Building {

    @ElementCollection(targetClass = Double.class)
    @CollectionTable(name = "TIME_FACTOR_SMITY")
    @MapKeyColumn(name="LEVEL")
    @Column(name="TIME_FACTOR")
    private Map<Integer, Double> timeFactor = new HashMap<>();

    public Smithy(){}

    public Smithy(Village village){
        super(village);
        this.setName("Smithy");
    }

    @Override
    public void setStarterSettings() {
        this.level = 0;

        this.maxLevel = 20;

        this.requirements.put("VillageHeadquarters", 5);
        this.requirements.put("Barracks", 1);


        Double timeFactor = 0.91;
        Integer populationNeededForUpgrade = 1;
        Integer totalOfPopulation = 1;
        Integer clay = 220;
        Integer wood = 180;
        Integer iron = 240;
        for(int i = 1; i <= this.maxLevel; i++){

            this.timeFactor.put(i, timeFactor);
            this.populationNeededForUpgrade.put(i, populationNeededForUpgrade);
            this.totalOfPopulation.put(i, totalOfPopulation);
            this.resourceRequirementsForUpgrade.put(i, new Resources(clay, wood, iron));

            clay += (int) (clay * 0.2);
            wood += (int) (wood * 0.2);
            iron += (int) (iron * 0.2);
            totalOfPopulation += populationNeededForUpgrade;
            populationNeededForUpgrade += 2;
            timeFactor -= 0.04;

        }
    }
}
