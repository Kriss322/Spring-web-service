package com.tribe.Tribes.village;

import com.tribe.Tribes.village.units.SoldierUnit;
import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.village.buildings.Building;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    private int villagePoints;

    @ManyToOne
    @JoinColumn(name="player_id")
    private Player ownerPlayer;

    @Embedded
    private WorldPosition position;

    private int currentPopulation;

    private int maxPopulation;

    @Embedded
    private Resources resourcesInWarehouse;

    @Embedded
    private ResourceProduction resourceProducementPerHour;

    @ElementCollection
    @CollectionTable(
            name="UNITS",
            joinColumns=@JoinColumn(name="VILLAGE_ID")
    )
    private List<SoldierUnit> unitsAtHome = new ArrayList<>();

    //TODO implement unit trainings
    @ElementCollection
    @CollectionTable(
            name="UNITS_RECRUITMENT",
            joinColumns=@JoinColumn(name="VILLAGE_ID")
    )
    private List<SoldierUnit> unitsUnderRecruitment;

    @OneToMany(mappedBy="ownerVillage", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Building> buildings;

    @ManyToOne
    @JoinColumn(name="worldmap_id")
    private WorldMap worldMap;

    public void addToCurrentPopulation(int population){
        this.currentPopulation += population;
    }

    public void addToMaxPopulation(int population){
        this.maxPopulation += population;
    }

    public void addToArmy(SoldierUnit unit){
        this.addToCurrentPopulation(unit.getPopulation() * unit.getNumberOfSoldiers());
        this.unitsAtHome.add(unit);
    }

    public Building getBuildingById(Integer id){
        return this.getBuildings()
                .stream()
                .filter(building -> building.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }

    public void recruitUnits(String name, int value){
        this.unitsAtHome
                .stream()
                .filter(soldierUnit -> soldierUnit.getName().equals(name))
                .forEach(soldierUnit -> soldierUnit.addToNumberOfSoldiers(value));
    }
}
