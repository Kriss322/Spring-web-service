
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

//implements archer interface?
@Embeddable
public class MountedArcher extends SoldierUnit{

    public MountedArcher(){

        this.name = "MountedArcher";
        this.resourceTrainingCost = new Resources(250,100,150);
        this.numberOfSoldiers = 0;
        this.population = 5;
        this.offensiveStrength = 120;
        this.generalDefenseStrength = 40;
        this.archerDefenseStrength = 50;
        this.speed = 10;
        this.haulCapacity = 50;
    }
}
