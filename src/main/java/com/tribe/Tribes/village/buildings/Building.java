package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;

import java.io.Serializable;
import java.util.Map;

import com.tribe.Tribes.village.Village;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class Building implements Serializable {

    protected int level;

    protected int maxLevel;

    protected Map<Integer, Integer> populationNeededForUpgrade;

    protected Map<Integer, Integer> totalOfPopulation;

    protected Map<Integer, Resources> resourceRequirementsForUpgrade;

    protected Map<String, Integer> requirements;

    // private Building requiredFor;

    public abstract void setStarterSettings();

}
