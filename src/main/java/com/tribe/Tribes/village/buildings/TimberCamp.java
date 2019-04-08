
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//implements resourcesProduction interface?
@Entity
@DiscriminatorValue("TimberCamp")
public class TimberCamp extends Building{
    private static String NAME = "Timber camp";
}
