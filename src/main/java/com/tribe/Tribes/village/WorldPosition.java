
package com.tribe.Tribes.village;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorldPosition implements Serializable {
    
    private int xPosition;
    private int yPosition;
    private int zPosition;

}
