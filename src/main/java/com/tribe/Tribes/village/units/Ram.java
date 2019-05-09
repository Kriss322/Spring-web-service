
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Ram extends SoldierUnit{

    public Ram(){

        this.name = "Ram";
        this.resourceTrainingCost = new Resources(300,200,200);
        this.numberOfSoldiers = 0;
        this.population = 5;
        this.archerDefenseStrength = 20;
        this.generalDefenseStrength = 20;
        this.offensiveStrength = 2;
        this.speed = 30;
        this.haulCapacity = 0;
    }
}
