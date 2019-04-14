
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

//implements archer interface?
@Embeddable
public class MountedArcher extends SoldierUnit{
    public static String NAME = "Mounted archer";
}
