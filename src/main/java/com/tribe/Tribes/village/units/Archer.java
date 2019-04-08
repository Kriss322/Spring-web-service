
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Archer")
public class Archer extends SoldierUnit{
    public static String NAME = "Archer";
}
