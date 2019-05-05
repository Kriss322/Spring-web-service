package com.tribe.Tribes.com.tribe.Tribes.tribe;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.village.WorldMap;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Tribe {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy="joinedTribe")
    private List<Player> memberPlayers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="world_id")
    private WorldMap world;

    @ManyToMany
    @JoinTable(name = "ENEMY_TRIBES")
    private List<Tribe> enemyTribes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ALLY_TRIBES")
    private List<Tribe> allyTribes = new ArrayList<>();

    private int points;

    private String name;

    private String description;

    public void addPlayer(Player player){
        this.memberPlayers.add(player);
    }

    public void addEnemyTribe(Tribe tribe){
        this.enemyTribes.add(tribe);
    }

    public void addAllyTribe(Tribe tribe){
        this.allyTribes.add(tribe);
    }
}
