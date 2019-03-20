package com.tribe.Tribes.player;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    
    
    List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    Player addNewPlayer(Player newPlayer) {
        return playerRepository.save(newPlayer);
    }
}
