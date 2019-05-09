
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class SpearFighter extends SoldierUnit{

    public SpearFighter(){

        this.name = "SpearFighter";
        this.resourceTrainingCost = new Resources(60,30,40);
        this.numberOfSoldiers = 0;
        this.population = 1;
        this.archerDefenseStrength = 20;
        this.generalDefenseStrength = 15;
        this.offensiveStrength = 10;
        this.speed = 18;
        this.haulCapacity = 25;
    }

    public SpearFighter(int population){
        this();
        this.numberOfSoldiers = population;

    }
}
