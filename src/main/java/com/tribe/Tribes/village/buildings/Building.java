package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;

import java.io.Serializable;
import java.util.List;

import com.tribe.Tribes.village.Village;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Building_Type")
@Data
@NoArgsConstructor
public abstract class Building implements Serializable {
   
    //private static String NAME;
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="village_id")
    private Village ownerVillage;
    private int level;
    private long timeFactor;
    
    private int populationNeededForUpgrade;
    private int totalOfPopulation;
    
    private Resources resourceRequirementsForUpgrade;

    @OneToMany(mappedBy = "requiredFor")
    private List<Building> requirements;

    @ManyToOne
    @JoinColumn(name = "requirement_id")
    private Building requiredFor;
    
}
