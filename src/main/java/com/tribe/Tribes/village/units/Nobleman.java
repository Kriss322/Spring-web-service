
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Nobleman extends SoldierUnit{

    public Nobleman(){

        this.name = "Nobleman";
        this.resourceTrainingCost = new Resources(40000,50000,50000);
        this.numberOfSoldiers = 0;
        this.population = 100;
        this.archerDefenseStrength = 100;
        this.generalDefenseStrength = 100;
        this.offensiveStrength = 30;
        this.speed = 35;
        this.haulCapacity = 0;
    }
}
