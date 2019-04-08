
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Academy")
public class Academy extends Building{
    private static String NAME = "Academy";
}
