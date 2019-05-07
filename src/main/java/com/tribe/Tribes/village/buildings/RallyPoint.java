package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.HashMap;

//TODO implement this
@Entity
@DiscriminatorValue("RallyPoint")
public class RallyPoint extends Building{

    public RallyPoint(){}

    public RallyPoint(Village village) {
        super(village);
        this.setName("RallyPoint");
    }

    @Override
    public void setStarterSettings() {

        this.level = 0;

        this.maxLevel = 1;

        this.resourceRequirementsForUpgrade.put(1, new Resources(10,40,30));
    }
}
