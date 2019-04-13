
package com.tribe.Tribes.village.units;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Unit_Type")
@Data
@NoArgsConstructor
public abstract class SoldierUnit {

    @Id @GeneratedValue
    private Long id;

    // private String name;
    private Resources resourceTrainingCost;

    @ManyToOne
    @JoinColumn(name="village_id")
    private Village ownerVillage;

    private int population;
    private int archerDefenseStrength;
    private int generalDefeneseStrength;
    private int offensiveStrength;
    private int speed;
    private int haulCapacity;
}
