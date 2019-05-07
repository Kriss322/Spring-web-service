
package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@DiscriminatorValue("Academy")
public class Academy extends Building{

    @ElementCollection(targetClass = Double.class)
    @CollectionTable(name = "TIME_FACTOR_ACADEMY")
    @MapKeyColumn(name="LEVEL")
    @Column(name="TIME_FACTOR")
    private Map<Integer, Double> timeFactor = new HashMap<>();

    public Academy(Village village){
        super(village);
        this.setName("Academy");
    }

    public Academy() {
    }

    @Override
    public void setStarterSettings() {

        this.level = 0;

        this.maxLevel = 1;

        this.requirements.put("VillageHeadquarters", 20);
        this.requirements.put("Smithy", 20);
        this.requirements.put("Market", 10);

        this.timeFactor.put(1, 0.63);

        this.populationNeededForUpgrade.put(1, 80);


        this.totalOfPopulation.put(1,80);

        this.resourceRequirementsForUpgrade.put(1, new Resources(15000,25000,10000));
    }
}
