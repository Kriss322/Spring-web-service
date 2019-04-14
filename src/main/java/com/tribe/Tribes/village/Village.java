package com.tribe.Tribes.village;

import com.tribe.Tribes.village.units.SoldierUnit;
import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.village.buildings.Building;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Village implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;
    
    private int villagePoints;

    @ManyToOne
    @JoinColumn(name="player_id")
    private Player ownerPlayer;

    @Embedded
    private WorldPosition position;

    private int population;
    
    @Embedded
    private Resources resourcesInWarehouse;

    @Embedded
    private ResourceProduction resourceProducementPerHour;

    @ElementCollection
    @CollectionTable(
        name="UNITS",
        joinColumns=@JoinColumn(name="VILLAGE_ID")
    )
    private List<SoldierUnit> army;

    //TODO implement unit trainings
    private List<SoldierUnit> unitsUnderRecruitment;

    @OneToMany(mappedBy="ownerVillage")
    private List<Building> buildings;

    @ManyToOne
    @JoinColumn(name="worldmap_id")
    private WorldMap worldMap;
}
