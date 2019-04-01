package com.tribe.Tribes.player;

import com.tribe.Tribes.village.Village;
import java.io.Serializable;
import java.util.List;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
@NoArgsConstructor
public class Player implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Integer playerPoints;
    @NonNull
    @OneToMany
    private List<Village> villages;
    
}
