
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Swordsman extends SoldierUnit{
    private static String NAME = "Swordsman";
}
