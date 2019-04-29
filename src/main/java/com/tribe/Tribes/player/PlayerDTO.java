/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribe.Tribes.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tribe.Tribes.com.tribe.Tribes.tribe.Tribe;
import com.tribe.Tribes.village.Village;
import com.tribe.Tribes.village.VillageDTO;
import com.tribe.Tribes.village.WorldMap;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kkassa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class PlayerDTO {
    
    private Integer id;
    
    private String name;

    private int playerPoints;

    private Tribe joinedTribe;

    // private String titleInTribe;

    @JsonProperty
    private List<Integer> villageIds;

    //private WorldMap world;
}
