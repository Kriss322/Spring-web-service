package com.tribe.Tribes.village;

import com.tribe.Tribes.village.units.SoldierUnit;
import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.village.buildings.Building;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Village implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;
    
    @NonNull
    private Integer villagePoints;

    @ManyToOne
    @JoinColumn(name="player_id")
    private Player ownerPlayer;

    @NonNull
    @Embedded
    private Position position;

    private int population;
    
    @Embedded
    private Resources resourcesInWarehouse;

    @Embedded
    private ResourceProduction resourceProducementPerHour;

    @ElementCollection
    @CollectionTable(name="VILLAGE_ARMY")
    @MapKeyJoinColumn(name="SOLDIER_ID")
    private Map<SoldierUnit, Integer> army;

    @OneToMany(mappedBy="ownerVillage")
    private List<Building> buildings;

    @ManyToOne
    @JoinColumn(name="worldmap_id")
    private WorldMap worldMap;
}
