
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Catapult extends SoldierUnit{

    public Catapult(){

        this.name = "Catapult";
        this.resourceTrainingCost = new Resources(320,400,100);
        this.numberOfSoldiers = 0;
        this.population = 8;
        this.archerDefenseStrength = 100;
        this.generalDefenseStrength = 100;
        this.offensiveStrength = 100;
        this.speed = 30;
        this.haulCapacity = 0;
    }
}
