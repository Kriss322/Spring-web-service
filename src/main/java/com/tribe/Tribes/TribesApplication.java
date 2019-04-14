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
                
                
                WorldPosition p = new WorldPosition(1,2,3);
                List<SoldierUnit> army = new ArrayList();
                army.add(new Archer());
                Village v1 = new Village(1, "London", 125, null, p, 34, new Resources(3,3,3), new ResourceProduction(1,1,1), army, null, null);
                villageRepository.save(v1);
                List<Village> v = new ArrayList();
                v.add(v1);
                Player p1 = new Player(1,"Player1",23, null, "Leader", v, null);
                               
                
		playerRepository.save(p1);
                System.out.println(p1.getId());
                v1.setOwnerPlayer(p1);
                villageRepository.merge or persist here
 
                
	}

}

