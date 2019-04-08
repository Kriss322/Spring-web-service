
package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VillageHeadquarters")
public class VillageHeadquarters extends Building{

    private static String NAME = "VillageHeadquarters";
    
    
    
}
