
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Workshop")
public class Workshop extends Building{
    private static String NAME = "Workshop";
}
