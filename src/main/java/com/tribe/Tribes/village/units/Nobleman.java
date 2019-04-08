
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Nobleman")
public class Nobleman extends SoldierUnit{
    public static String NAME = "Nobleman";
}
