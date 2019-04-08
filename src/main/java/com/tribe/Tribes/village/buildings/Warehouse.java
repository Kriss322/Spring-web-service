
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Warehouse")
public class Warehouse extends Building{
    private static String NAME = "Warehouse";
}
