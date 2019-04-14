
package com.tribe.Tribes.village.units;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class HeavyCavalry extends SoldierUnit{
    public static String NAME = "Heavy cavalry";
}
