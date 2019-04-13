
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ClayPit")
public class ClayPit extends Building{
    private static String NAME = "Clay pit";
}
