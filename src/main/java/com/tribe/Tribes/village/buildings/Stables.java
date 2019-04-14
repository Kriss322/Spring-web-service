
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;


@Embeddable
public class Stables extends Building{
    
    private static String NAME = "Stables";
    
}
