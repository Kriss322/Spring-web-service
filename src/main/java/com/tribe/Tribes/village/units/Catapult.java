
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Catapult")
public class Catapult extends SoldierUnit{
    public static String NAME = "Catapult";
}
