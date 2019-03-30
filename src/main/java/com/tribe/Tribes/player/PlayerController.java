package com.tribe.Tribes.player;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping({"/players"})
public class PlayerController {

        private PlayerService playerService;

        @Autowired
        public PlayerController(PlayerService playerService) {
            this.playerService = playerService;
        }

        @GetMapping
        public List<Player> getAllPlayers(){
            return playerService.getAllPlayers();
        }

        @PostMapping
        public Player newPlayer(@RequestBody Player newPlayer){
        return playerService.addNewPlayer(newPlayer);
    }
    
}
