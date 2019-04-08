
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Stables")
public class Stables extends Building{
    
    private static String NAME = "Stables";
    
}
