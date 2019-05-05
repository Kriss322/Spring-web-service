package com.tribe.Tribes.village.buildings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDTO {

    private Integer id;

    private String name;

    private int level;

    //VillageDTO
    private Integer ownerVillageId;

}
