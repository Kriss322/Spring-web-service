
package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.units.SoldierUnit;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("Barracks")
public class Barracks extends Building{
    
    private static String NAME = "Barracks";

    @ElementCollection(targetClass = Double.class)
    @CollectionTable(name = "TIME_FACTOR")
    @MapKeyColumn(name="LEVEL")
    @Column(name="TIME_FACTOR")
    private Map<Integer, Double> timeFactor;

    @ElementCollection
    @CollectionTable(
            name="UNITS_RECRUITMENT",
            joinColumns=@JoinColumn(name="VILLAGE_ID")
    )
    private List<SoldierUnit> unitsUnderRecruitment;

    public Barracks(){
        setStarterSettings();
    }

    @Override
    public void setStarterSettings() {

        this.level = 0;

        this.maxLevel = 25;

        this.requirements = new HashMap<String, Integer>(){{
            requirements.put("VillageHeadquarters", 3);
        }};

        Double timeFactor = 0.63;
        Integer populationNeededForUpgrade = 1;
        Integer totalOfPopulation = 1;
        Integer clay = 200;
        Integer wood = 170;
        Integer iron = 90;
        for(int i = 1; i < this.maxLevel; i++){

            this.timeFactor.put(i, timeFactor);
            this.populationNeededForUpgrade.put(i, populationNeededForUpgrade);
            this.totalOfPopulation.put(i, totalOfPopulation);
            this.resourceRequirementsForUpgrade.put(i, new Resources(clay, wood, iron));

            clay += (int) (clay * 0.2);
            wood += (int) (wood * 0.2);
            iron += (int) (iron * 0.2);
            totalOfPopulation += populationNeededForUpgrade;
            populationNeededForUpgrade += 2;
            timeFactor -= 2;

        }
    }
}
