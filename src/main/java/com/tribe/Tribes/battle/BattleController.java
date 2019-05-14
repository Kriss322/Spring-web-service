package com.tribe.Tribes.battle;

import com.tribe.Tribes.player.PlayerController;
import com.tribe.Tribes.village.VillageController;
import com.tribe.Tribes.village.units.SoldierUnit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/battles")
public class BattleController {

    private final BattleService battleService;

    private static ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public BattleController(BattleService battleService){
        this.battleService = battleService;
    }

    @PostMapping("/attacker-village/{attackerVillageId}/defender-village/{defenderVillageId}")
    public BattleDTO newBattle(@PathVariable Integer attackerVillageId, @PathVariable Integer defenderVillageId, @RequestBody List<SoldierUnit> units) throws InterruptedException, ExecutionException {
        CompletableFuture<Battle> battle = battleService.newBattle(attackerVillageId, defenderVillageId, units);

        CompletableFuture.allOf(battle).join();

        return convertToDto(battle.get());
    }

    @GetMapping
    public List<BattleDTO> getAllBattles(){
        List<Battle> battles = battleService.getAllBattles();
        return battles.stream()
                .map(battle -> convertToDto(battle))
                .collect(Collectors.toList());
    }

    @GetMapping("/players/{playerId")
    @ResponseBody
    public List<BattleDTO> getAllBattlesOfPlayer(@PathVariable Integer playerId){
        List<Battle> battles = battleService.getAllBattlesOfPlayer(playerId);

        return battles.stream()
                .map(battle -> convertToDto(battle))
                .collect(Collectors.toList());
    }

    public static Battle convertToEntity(BattleDTO battleDto){

        Battle battle = modelMapper.map(battleDto, Battle.class);
        return battle;
    }

    public static BattleDTO convertToDto(Battle battle){
        BattleDTO battleDTO = modelMapper.map(battle, BattleDTO.class);

        //battleDTO.setAttackerVillage(VillageController.convertToDto(battle.getAttackerVillage()));
        //battleDTO.setDefenderVillage(VillageController.convertToDto(battle.getDefenderVillage()));

        //battleDTO.setWinnerPlayer(PlayerController.convertToDto(battle.getWinnerPlayer()));

        return  battleDTO;

    }

}
