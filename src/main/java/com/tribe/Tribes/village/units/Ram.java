
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Ram")
public class Ram extends SoldierUnit{
    public static String NAME = "Ram";
}
