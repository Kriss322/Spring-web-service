package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Village;
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

    private Integer ownerVillageId;

}
