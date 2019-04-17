package com.tribe.Tribes;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.player.PlayerRepository;
import com.tribe.Tribes.player.PlayerService;
import com.tribe.Tribes.village.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootConfiguration
@SpringBootApplication
public class TribesApplication implements CommandLineRunner {

	@Autowired
	PlayerRepository playerRepository;
        
    @Autowired
    VillageRepository villageRepository;

    @Autowired
	PlayerService playerService;

    @Autowired
	VillageService villageService;

	public static void main(String[] args) {
		SpringApplication.run(TribesApplication.class, args);
	}

	@Override
	public void run(String... args){

		villageService.addNewVillage(new Player());

		System.out.println("Running");
	}

}

