
package com.tribe.Tribes.village;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.village.buildings.Building;
import com.tribe.Tribes.village.units.SoldierUnit;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VillageDTO {
    
    private Integer id;
    
    private String name;
    
    private int villagePoints;
    
    private Integer ownerPlayerId;
//    
    private WorldPosition position;
//    
    private Resources resourcesInWareHouse;
//    
    private ResourceProduction resourceProducementPerHour;
//    
    // private List<SoldierUnit> army;
//    
    private List<Integer> buildingsId;

    private List<Integer> buildingsLevel;
//    
    private WorldMap worldMap;
//    
}
