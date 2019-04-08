
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Axeman")
public class Axeman extends SoldierUnit{
    public static String NAME = "Axeman";
}
