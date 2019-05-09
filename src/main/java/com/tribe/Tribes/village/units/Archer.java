
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;

import javax.persistence.Embeddable;

@Embeddable
public class Archer extends SoldierUnit{

    public Archer(){

        this.name = "Archer";
        this.resourceTrainingCost = new Resources(100,30,60);
        this.numberOfSoldiers = 0;
        this.population = 1;
        this.archerDefenseStrength = 5;
        this.generalDefenseStrength = 10;
        this.offensiveStrength = 15;
        this.speed = 18;
        this.haulCapacity = 10;
    }

    public Archer(int population){
        this();
        this.numberOfSoldiers = population;

    }
}
