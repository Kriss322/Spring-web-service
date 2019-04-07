package com.tribe.Tribes.village;

import com.tribe.Tribes.village.units.SoldierUnit;
import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.village.buildings.Building;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    
    @NonNull
    @ManyToOne
    private Player ownerPlayer;
    
    @NonNull
    private Position position;

    private int population;
    
    @OneToOne
    private Resources resourcesInWarehouse;
    
    @OneToOne
    private Resources resourceProducement;
    
    private HashMap<SoldierUnit, Integer> army;
    
    private List<Building> buildings;
}
