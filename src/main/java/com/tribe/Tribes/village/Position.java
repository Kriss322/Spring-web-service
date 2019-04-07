
package com.tribe.Tribes.village;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor

class Position implements Serializable{
    
    private int x;
    private int y;
    private int z;

}
