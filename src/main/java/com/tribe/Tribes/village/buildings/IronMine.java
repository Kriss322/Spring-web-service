
package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IronMine")
@Data
public class IronMine extends Building{

    public IronMine(){}

    public IronMine(Village village){
        super(village);
        this.setName("IronMine");
    }

    @Override
    public void setStarterSettings() {

        this.level = 0;

        this.maxLevel = 30;

        this.productionPerHour = 30;

        Integer populationNeededForUpgrade = 2;
        Integer totalOfPopulation = 2;
        Integer clay = 75;
        Integer wood = 65;
        Integer iron = 70;
        for(int i = 1; i <= this.maxLevel; i++){

            this.populationNeededForUpgrade.put(i, populationNeededForUpgrade);
            this.totalOfPopulation.put(i, totalOfPopulation);
            this.resourceRequirementsForUpgrade.put(i, new Resources(clay, wood, iron));

            clay += (int) (clay * 0.2);
            wood += (int) (wood * 0.2);
            iron += (int) (iron * 0.2);

            totalOfPopulation += populationNeededForUpgrade;
            populationNeededForUpgrade += 4;

        }
    }
}
