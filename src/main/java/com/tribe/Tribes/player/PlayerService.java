package com.tribe.Tribes.player;

import java.util.List;

import com.tribe.Tribes.village.Village;
import com.tribe.Tribes.village.VillageDTO;
import com.tribe.Tribes.village.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    private final VillageService villageService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, VillageService villageService) {
        this.playerRepository = playerRepository;
        this.villageService = villageService;
    }
    
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player addNewPlayer(Player newPlayer) {
        villageService.addNewVillage(newPlayer);
        return playerRepository.save(newPlayer);
    }

    public Player getPlayerById(Integer id) {
        return playerRepository.findById(id).get();
    }

    public List<Village> getVillagesOfPlayer(Integer id) {
        return villageService.getVillageByPlayerId(id);
    }

    public Village getOneVillageOfPlayer(Integer playerId, Integer villageId) {
        return villageService.getOneVillageOfPlayer(playerId, villageId);
    }

    public Player deletePlayer(Integer playerId) {

        Player player = getPlayerById(playerId);

        villageService.setAbandonedVillages(playerId);

        playerRepository.delete(player);

        return player;
    }

}
