
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IronMine")
public class IronMine extends Building{
    private static String NAME = "Iron mine";
}
