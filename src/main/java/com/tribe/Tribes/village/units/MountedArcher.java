
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//implements archer interface?
@Entity
@DiscriminatorValue("MountedArcher")
public class MountedArcher extends SoldierUnit{
    public static String NAME = "Mounted archer";
}
