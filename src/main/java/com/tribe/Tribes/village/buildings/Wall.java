
package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@DiscriminatorValue("Wall")
public class Wall extends Building{

    @ElementCollection(targetClass = Double.class)
    @CollectionTable(name = "DEFENDING_FACTOR")
    @MapKeyColumn(name="LEVEL")
    @Column(name="DEFENDING_FACTOR")
    private Map<Integer, Double> defendingFactor = new HashMap<>();

    public Wall(){}

    public Wall(Village village){
        super(village);
        this.setName("Wall");
    }

    @Override
    public void setStarterSettings() {

        this.level = 0;

        this.maxLevel = 20;

        this.requirements = new HashMap<String, Integer>(){{
            requirements.put("Barracks", 1);
        }};

        Double defFactor = 0.04;
        Integer populationNeededForUpgrade = 1;
        Integer totalOfPopulation = 1;
        Integer clay = 50;
        Integer wood = 100;
        Integer iron = 20;
        for(int i = 1; i <= this.maxLevel; i++){

            this.defendingFactor.put(i, defFactor);
            this.populationNeededForUpgrade.put(i, populationNeededForUpgrade);
            this.totalOfPopulation.put(i, totalOfPopulation);
            this.resourceRequirementsForUpgrade.put(i, new Resources(clay, wood, iron));

            clay += (int) (clay * 0.2);
            wood += (int) (wood * 0.2);
            iron += (int) (iron * 0.2);
            totalOfPopulation += populationNeededForUpgrade;
            populationNeededForUpgrade++;
            defFactor += 0.04;

        }
    }
}
