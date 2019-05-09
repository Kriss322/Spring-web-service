
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Axeman extends SoldierUnit{

    public Axeman(){

        this.name = "Axeman";
        this.resourceTrainingCost = new Resources(60,30,40);
        this.numberOfSoldiers = 0;
        this.population = 1;
        this.archerDefenseStrength = 10;
        this.generalDefenseStrength = 10;
        this.offensiveStrength = 40;
        this.speed = 18;
        this.haulCapacity = 10;
    }

    public Axeman(int population){
        this();
        this.numberOfSoldiers = population;

    }
}
