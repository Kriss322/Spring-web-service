package com.tribe.Tribes.battle;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.player.PlayerRepository;
import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;
import com.tribe.Tribes.village.VillageRepository;
import com.tribe.Tribes.village.units.SoldierUnit;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BattleService {

    private final VillageRepository villageRepository;

    private final BattleRepository battleRepository;

    private final PlayerRepository playerRepository;

    public BattleService(VillageRepository villageRepository, BattleRepository battleRepository, PlayerRepository playerRepository){
        this.villageRepository = villageRepository;
        this.battleRepository = battleRepository;
        this.playerRepository = playerRepository;
    }

    @Async("asyncExecutor")
    public CompletableFuture<Battle> newBattle(Integer attackerVillageId, Integer defenderVillageId, List<SoldierUnit> attackerUnits) throws InterruptedException {

        Battle battle = new Battle();

        Village attackerVillage = villageRepository.findById(attackerVillageId).get();
        Village defenderVillage = villageRepository.findById(defenderVillageId).get();

        SoldierUnit slowestUnit = this.getSlowestUnit(attackerUnits);

        int travelTime = calculateTravelTime(attackerVillage, defenderVillage, slowestUnit.getSpeed());

        battle.setAttackerArmy(attackerUnits);
        battle.setDefenderArmy(defenderVillage.getUnitsAtHome());
        battle.setAttackerVillage(attackerVillage);
        battle.setDefenderVillage(defenderVillage);
        battle.setDate(LocalDateTime.now());

        Village winnerVillage = battle.simulateBattle();

        if(winnerVillage.getId().equals(attackerVillage.getId())){
            attackerVillage.getResourcesInWarehouse().add(new Resources(3000,3000,3000));
            //battle.setWinnerPlayer(attackerVillage.getOwnerPlayer());
        }
        else {
            defenderVillage.killUnitsAtHome();
           //battle.setWinnerPlayer(defenderVillage.getOwnerPlayer());
        }

        battleRepository.save(battle);
        villageRepository.save(defenderVillage);
        villageRepository.save(attackerVillage);

        //Thread.sleep(travelTime * 30);
        Thread.sleep(0);
        return CompletableFuture.completedFuture(battle);

    }

    private SoldierUnit getSlowestUnit(List<SoldierUnit> units) {

        SoldierUnit slowestSoldierUnit = units
                .stream()
                .min(Comparator.comparing(SoldierUnit::getSpeed))
                .orElseThrow(NoSuchElementException::new);

        return  slowestSoldierUnit;

    }

    public int calculateTravelTime(Village v1, Village v2, int speed){

        double x1 = (double) v1.getPosition().getXPosition();
        double y1 = (double) v1.getPosition().getYPosition();

        double x2 = (double) v2.getPosition().getXPosition();
        double y2 = (double) v2.getPosition().getYPosition();

        return (int) Point2D.distance(x1,y1,x2,y2) * speed;

    }

    public List<Battle> getAllBattles() {
        return battleRepository.findAll();
    }

    public List<Battle> getAllBattlesOfPlayer(Integer playerId) {

        Player player = playerRepository.getOne(playerId);
        List<Battle> battlesOfPlayer = battleRepository.findAll();

        List<Battle> battleStream = battlesOfPlayer
                .stream()
                .filter(battle -> battle.getAttackerVillage().getOwnerPlayer().equals(player) || battle.getDefenderVillage().getOwnerPlayer().equals(player))
                .collect(Collectors.toList());

        return battleStream;
    }
}
