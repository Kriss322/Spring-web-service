package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

    @Id @GeneratedValue
    private Long Id;

    @ManyToOne
    @JoinColumn(name="village_id")
    protected Village ownerVillage;

    protected int level;

    protected int maxLevel;

    protected int pointsPerLevel = 20;

    @ElementCollection(targetClass = Integer.class)
    @CollectionTable(name = "POPULATION_NEEDED_PER_LEVEL")
    @MapKeyColumn(name="LEVEL")
    @Column(name="POPULATION")
    protected Map<Integer, Integer> populationNeededForUpgrade = new HashMap<>();

    @ElementCollection(targetClass = Integer.class)
    @CollectionTable(name = "TOTAL_OF_POPULATION")
    @MapKeyColumn(name="LEVEL")
    @Column(name="TOTAL_OF_POPULATION")
    protected Map<Integer, Integer> totalOfPopulation = new HashMap<>();

    @ElementCollection(targetClass = Resources.class)
    @CollectionTable(name = "RESOURCES_NEEDED_PER_LEVEL")
    @MapKeyColumn(name="LEVEL")
    @Column(name="RESOURCES")
    protected Map<Integer, Resources> resourceRequirementsForUpgrade = new HashMap<>();

    @ElementCollection(targetClass = Integer.class)
    @CollectionTable(name = "REQUIREMENTS_NEEDED")
    @MapKeyColumn(name="LEVEL")
    @Column(name="NAME")
    protected Map<String, Integer> requirements = new HashMap<>();

    public abstract void setStarterSettings();

}
