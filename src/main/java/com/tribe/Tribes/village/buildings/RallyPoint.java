package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RallyPoint")
public class RallyPoint extends Building{
    private static String NAME = "Rally point";
}
