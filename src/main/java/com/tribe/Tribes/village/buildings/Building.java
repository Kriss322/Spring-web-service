package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.tribe.Tribes.village.Village;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Building_Type")
@Data
//@NoArgsConstructor
@AllArgsConstructor
public class Building implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String name;

    protected Integer productionPerHour;

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

    @ElementCollection(targetClass = Integer.class)
    @CollectionTable(name = "MAX_POPULATION")
    @MapKeyColumn(name="LEVEL")
    @Column(name="MAX_POPULATION")
    protected Map<Integer, Integer> maximumPopulation = new HashMap<>();

    public void setStarterSettings(){}

    public Building(Village village){
        this.ownerVillage = village;
    }

    public Building(){

    }

}
