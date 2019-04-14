
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Catapult extends SoldierUnit{
    public static String NAME = "Catapult";
}
