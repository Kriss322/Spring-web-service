
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//implements unitRecruiting interface
@Entity
@DiscriminatorValue("Barracks")
public class Barracks extends Building{
    
    private static String NAME = "Barracks";
    
}
