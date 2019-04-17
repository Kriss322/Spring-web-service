
package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;

import javax.persistence.*;
import java.util.Map;

@Entity
@DiscriminatorValue("Farm")
public class Farm extends Building{

    private static String NAME = "Farm";

    @ElementCollection(targetClass = Integer.class)
    @CollectionTable(name = "MAX_POPULATION")
    @MapKeyColumn(name="MAX_POPULATION")
    @Column(name="MAX_POPULATION")
    private Map<Integer, Integer> maximumPopulation;

    public Farm(){
        setStarterSettings();
    }

    @Override
    public void setStarterSettings() {

        this.level = 1;

        this.maxLevel = 30;

        Integer maxPopulation = 240;
        Integer clay = 45;
        Integer wood = 40;
        Integer iron = 30;
        for(int i = 1; i < this.maxLevel; i++){

            this.maximumPopulation.put(i, maxPopulation);
            this.populationNeededForUpgrade.put(i, 0);
            this.totalOfPopulation.put(i, 0);
            this.resourceRequirementsForUpgrade.put(i, new Resources(clay, wood, iron));

            clay += (int) (clay * 0.25);
            wood += (int) (wood * 0.25);
            iron += (int) (iron * 0.25);

            maxPopulation += (int) (maxPopulation * 0.15);

        }
    }
}
