
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class LightCavarly extends SoldierUnit{

    public LightCavarly(){

        this.name = "LightCavalry";
        this.resourceTrainingCost = new Resources(125,100,250);
        this.numberOfSoldiers = 0;
        this.population = 4;
        this.offensiveStrength = 130;
        this.generalDefenseStrength = 30;
        this.archerDefenseStrength = 30;
        this.speed = 10;
        this.haulCapacity = 80;
    }
}
