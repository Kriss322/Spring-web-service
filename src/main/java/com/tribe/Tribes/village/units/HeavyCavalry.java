
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HeavyCavalry")
public class HeavyCavalry extends SoldierUnit{
    public static String NAME = "Heavy cavalry";
}
