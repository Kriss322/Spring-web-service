
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SpearFighter")
public class SpearFighter extends SoldierUnit{
    private static String NAME = "Spear fighter";
}
