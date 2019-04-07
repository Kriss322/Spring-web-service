package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Building {
   
    //private static String NAME;
    private int level;
    private int timeFactor;
    
    private int populationNeededForUpgrade;
    private int totalOfPopulation;
    
    private Resources resourceRequirementsForUpgrade;
    private List<Building> Requirements;
    
}
