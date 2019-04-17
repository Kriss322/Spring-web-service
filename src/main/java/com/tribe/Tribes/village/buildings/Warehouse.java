
package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

@Entity
@DiscriminatorValue("Warehouse")
public class Warehouse extends Building{

    private static String NAME = "Warehouse";

    private Map<Integer, Integer> capacity;

    public Warehouse() {
        setStarterSettings();
    }

    @Override
    public void setStarterSettings() {

        this. level = 1;

        this.maxLevel = 30;

        Integer cap = 1000;
        Integer populationNeededForUpgrade = 1;
        Integer totalOfPopulation = 1;
        Integer clay = 60;
        Integer wood = 50;
        Integer iron = 40;
        for(int i = 1; i < this.maxLevel; i++){

            this.capacity.put(i, cap);
            this.populationNeededForUpgrade.put(i, populationNeededForUpgrade);
            this.totalOfPopulation.put(i, totalOfPopulation);
            this.resourceRequirementsForUpgrade.put(i, new Resources(clay, wood, iron));

            clay += (int) (clay * 0.2);
            wood += (int) (wood * 0.2);
            iron += (int) (iron * 0.2);
            totalOfPopulation += populationNeededForUpgrade;
            populationNeededForUpgrade += 2;
            cap += (int) (cap * 0.19);

        }
    }
}
