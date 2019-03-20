package com.tribe.Tribes.player;

import java.io.Serializable;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Player implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String name;
}
