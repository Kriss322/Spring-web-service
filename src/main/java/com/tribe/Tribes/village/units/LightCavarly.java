
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LightCavalry")
public class LightCavarly extends SoldierUnit{
    public static String NAME = "Light cavalry";
}
