package com.tribe.Tribes.village;

import com.tribe.Tribes.player.Player;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    
    private Integer wood;
    private Integer clay;
    private Integer metal;
    private Integer food;
    
    private Integer woodPerMinutes;
    private Integer clayPerMinutes;
    private Integer metalPerMinutes;
    private Integer foodPerMinutes;
}
