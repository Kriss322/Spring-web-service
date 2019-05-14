package com.tribe.Tribes.battle;

import com.tribe.Tribes.player.PlayerDTO;
import com.tribe.Tribes.village.VillageDTO;
import com.tribe.Tribes.village.units.SoldierUnit;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.List;

@MappedSuperclass
@Data
@NoArgsConstructor
public class BattleDTO {

    //private Integer attackerVillageId;

    //private Integer defenderVillageId;

    private List<SoldierUnit> attackerArmy;

    private List<SoldierUnit> defenderArmy;

    private LocalDateTime date;

    private PlayerDTO winnerPlayer;

    private List<SoldierUnit> survivedUnits;

}
