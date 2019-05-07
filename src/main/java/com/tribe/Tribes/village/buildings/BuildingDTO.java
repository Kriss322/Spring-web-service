package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDTO {

    private Integer id;

    private String name;

    private int level;

    //VillageDTO
    private Integer ownerVillageId;

    private Resources resourcesForNextLevel;

    private Integer populationNeededForNextLevel;

    protected Map<String, Integer> requirements;

}
