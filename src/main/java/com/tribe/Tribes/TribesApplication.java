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

import java.util.List;

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

		Player testPlayer1 = new Player(1, "test-player-1 ", 60, null, "", null, null);
		Player testPlayer2 = new Player(2, "test-player-2", 60, null, "", null, null);
		Player testPlayer3 = new Player(3, "test-player-3 ", 60, null, "", null, null);
		playerService.addNewPlayer(testPlayer1);
		playerService.addNewPlayer(testPlayer2);
		playerService.addNewPlayer(testPlayer3);

		//villageService.deleteVillage(1);

		List<Village> villagesInDb = villageRepository.findAll();


		new Thread(() -> {
			while(true){

				villageService.updateResources(villageRepository.findAll());
				try {
					/*PerHour
					Thread.sleep(3600000);*/

					//For testing
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();




		System.out.println("Running");
	}

}

