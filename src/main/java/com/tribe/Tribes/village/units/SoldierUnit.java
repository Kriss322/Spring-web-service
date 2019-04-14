
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@MappedSuperclass
@Data
@NoArgsConstructor
public class SoldierUnit implements Serializable {

    // private String name;
    private Resources resourceTrainingCost;

    private Village ownerVillage;

    private int numberOfSoldiers;
    private int population;
    private int archerDefenseStrength;
    private int generalDefeneseStrength;
    private int offensiveStrength;
    private int speed;
    private int haulCapacity;
}
