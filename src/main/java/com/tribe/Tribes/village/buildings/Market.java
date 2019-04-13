package com.tribe.Tribes.village.buildings;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Market")
public class Market extends Building{
    private static String NAME = "Market";
}
