
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Farm")
public class Farm extends Building{
    private static String NAME = "Farm";
}
