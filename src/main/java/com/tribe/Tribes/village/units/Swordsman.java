
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Swordsman extends SoldierUnit{

    public Swordsman(){

        this.name = "Swordsman";
        this.resourceTrainingCost = new Resources(30,30,70);
        this.numberOfSoldiers = 0;
        this.population = 1;
        this.archerDefenseStrength = 20;
        this.generalDefenseStrength = 15;
        this.offensiveStrength = 25;
        this.speed = 22;
        this.haulCapacity = 15;
    }

    public Swordsman(int population){
        this();
        this.numberOfSoldiers = population;

    }
}
