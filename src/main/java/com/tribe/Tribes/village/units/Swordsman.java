
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Swordsman")
public class Swordsman extends SoldierUnit{
    private static String NAME = "Swordsman";
}
