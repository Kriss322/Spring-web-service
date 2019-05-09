
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class HeavyCavalry extends SoldierUnit{

    public HeavyCavalry(){

        this.name = "HeavyCavalry";
        this.resourceTrainingCost = new Resources(200,150,600);
        this.numberOfSoldiers = 0;
        this.population = 6;
        this.offensiveStrength = 150;
        this.generalDefenseStrength = 200;
        this.archerDefenseStrength = 180;
        this.speed = 11;
        this.haulCapacity = 50;
    }
}
