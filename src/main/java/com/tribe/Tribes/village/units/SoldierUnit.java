
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class SoldierUnit {
    
    // private String name;
    private Resources resourceTrainingCost;
    
    private int population;
    private int archerDefenseStrength;
    private int generalDefeneseStrength;
    private int offensiveStrength;
    private int speed;
    private Resources haulCapacity;
}
