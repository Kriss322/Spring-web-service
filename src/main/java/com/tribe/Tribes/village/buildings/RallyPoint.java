package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.HashMap;

//TODO implement this
@Entity
@DiscriminatorValue("RallyPoint")
public class RallyPoint extends Building{

    private static String NAME = "Rally point";

    public RallyPoint() {
        setStarterSettings();
    }

    @Override
    public void setStarterSettings() {

        this.level = 0;

        this.maxLevel = 1;

        this.resourceRequirementsForUpgrade = new HashMap<Integer, Resources>(){{
            resourceRequirementsForUpgrade.put(1, new Resources(10,40,30));
        }};
    }
}
