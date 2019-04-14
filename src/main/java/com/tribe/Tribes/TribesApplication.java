package com.tribe.Tribes;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.player.PlayerRepository;
import com.tribe.Tribes.village.ResourceProduction;
import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.WorldPosition;
import com.tribe.Tribes.village.Village;
import com.tribe.Tribes.village.VillageRepository;
import com.tribe.Tribes.village.units.Archer;
import com.tribe.Tribes.village.units.SoldierUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootConfiguration
@SpringBootApplication
public class TribesApplication implements CommandLineRunner {

	@Autowired
	PlayerRepository playerRepository;
        
    @Autowired
    VillageRepository villageRepository;

	public static void main(String[] args) {
		SpringApplication.run(TribesApplication.class, args);
	}

	@Override
	public void run(String... args){
		System.out.println("Running");
	}

}

