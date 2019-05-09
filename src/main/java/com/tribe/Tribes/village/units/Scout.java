
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;

import javax.persistence.Embeddable;

@Embeddable
public class Scout extends SoldierUnit{

    public Scout(){

        this.name = "Scout";
        this.resourceTrainingCost = new Resources(50,50,20);
        this.numberOfSoldiers = 0;
        this.population = 2;
        this.archerDefenseStrength = 2;
        this.generalDefenseStrength = 2;
        this.offensiveStrength = 0;
        this.speed = 9;
        this.haulCapacity = 0;
    }
}
