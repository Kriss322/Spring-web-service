
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Wall")
public class Wall extends Building{
    private static String NAME = "Wall";
}
