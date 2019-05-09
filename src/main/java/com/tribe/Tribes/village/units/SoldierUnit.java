
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

    protected String name;

    protected Resources resourceTrainingCost;

    protected Village ownerVillage;

    protected int numberOfSoldiers;

    protected int population;

    protected int archerDefenseStrength;

    protected int generalDefenseStrength;

    protected int offensiveStrength;

    //minutes per field
    protected int speed;

    protected int haulCapacity;

    //protected Map<String, Integer> requirements;

    public void addToNumberOfSoldiers(int value){
        this.numberOfSoldiers += value;
    }
}
