
package com.tribe.Tribes.village;

import com.tribe.Tribes.com.tribe.Tribes.tribe.Tribe;
import com.tribe.Tribes.player.Player;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class WorldMap implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numberOfPlayers;
    private int numberOfVillages;

    private int numberOfContinents;

    @OneToMany(mappedBy="world")
    private List<Player> players;

    @OneToMany(mappedBy="worldMap")
    private List<Village> villages;

    @OneToMany(mappedBy = "world")
    private List<Tribe> tribes;
}
