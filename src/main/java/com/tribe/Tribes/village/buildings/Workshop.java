
package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;
import com.tribe.Tribes.village.units.SoldierUnit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("Workshop")
public class Workshop extends Building{

    private static String NAME = "Workshop";

    @ElementCollection(targetClass = Double.class)
    @CollectionTable(name = "TIME_FACTOR_WORKSHOP")
    @MapKeyColumn(name="LEVEL")
    @Column(name="TIME_FACTOR")
    private Map<Integer, Double> timeFactor = new HashMap<>();


    @ElementCollection
    @CollectionTable(
            name="UNITS_RECRUITMENT",
            joinColumns=@JoinColumn(name="BUILDING_ID")
    )
    private List<SoldierUnit> unitsUnderRecruitment = new ArrayList<>();

    public Workshop(){}

    public Workshop(Village village){
        super(village);
    }

    @Override
    public void setStarterSettings() {

        this.level = 0;

        this.maxLevel = 15;

        this.requirements = new HashMap<String, Integer>(){{
            requirements.put("VillageHeadquarters", 10);
            requirements.put("Smithy", 10);
        }};

        Double timeFactor = 0.63;
        Integer populationNeededForUpgrade = 1;
        Integer totalOfPopulation = 1;
        Integer clay = 300;
        Integer wood = 240;
        Integer iron = 260;
        for(int i = 1; i <= this.maxLevel; i++){

            this.timeFactor.put(i, timeFactor);
            this.populationNeededForUpgrade.put(i, populationNeededForUpgrade);
            this.totalOfPopulation.put(i, totalOfPopulation);
            this.resourceRequirementsForUpgrade.put(i, new Resources(clay, wood, iron));

            clay += (int) (clay * 0.2);
            wood += (int) (wood * 0.2);
            iron += (int) (iron * 0.2);
            totalOfPopulation += populationNeededForUpgrade;
            populationNeededForUpgrade++;
            timeFactor -= 0.02;

        }
    }
}
