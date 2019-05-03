
package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO implement building process
@Entity
@DiscriminatorValue("VillageHeadquarters")
public class VillageHeadquarters extends Building{

    @ElementCollection(targetClass = Double.class)
    @CollectionTable(name = "TIME_FACTOR_HQ")
    @MapKeyColumn(name="LEVEL")
    @Column(name="TIME_FACTOR")
    private Map<Integer, Double> timeFactor = new HashMap<>();


    @ElementCollection(targetClass = Integer.class)
    @CollectionTable(name = "BUILDINGS_UNDER_CONSTRUCT")
    @MapKeyColumn(name="NAME")
    @Column(name="LEVEL")
    private Map<String, Integer> buildingsUnderConstruct = new HashMap<>();

    @ElementCollection(targetClass = Integer.class)
    @CollectionTable(name = "BUILDINGS_UNDER_CONSTRUCT_TIME")
    @MapKeyColumn(name="NAME")
    @Column(name="TIME")
    private Map<String, Integer> buildingsUnderConstructTime = new HashMap<>();

    public VillageHeadquarters(){

    }

    public VillageHeadquarters(Village village) {
        super(village);
        this.setName("VillageHeadquarters");
    }

    @Override
    public void setStarterSettings() {

        this.level = 1;

        this.maxLevel = 30;

        Double timeFactor = 0.95;
        Integer populationNeededForUpgrade = 1;
        Integer totalOfPopulation = 1;
        Integer clay = 90;
        Integer wood = 80;
        Integer iron = 70;
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
            timeFactor -= 0.03;

        }
    }
}
