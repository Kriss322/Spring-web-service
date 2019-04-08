package com.tribe.Tribes.com.tribe.Tribes.tribe;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.village.WorldMap;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Tribe {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy="joinedTribe")
    private List<Player> memberPlayers;

    @ManyToOne
    @JoinColumn(name="world_id")
    private WorldMap world;
    /*
    private List<Tribe> enemyTribes;

    private List<Tribe> allyTribes;
    */
    private int points;

    private String name;

    private String description;
}
