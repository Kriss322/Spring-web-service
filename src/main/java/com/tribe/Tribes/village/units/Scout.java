
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Scout")
public class Scout extends SoldierUnit{
    public static String NAME = "Scout";
}
