
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
public class Resources implements Serializable, Comparable<Resources> {
    private Integer clay;
    private Integer wood;
    private Integer iron;

    @Override
    public int compareTo(Resources r) {
        if(r.getIron() > this.iron || r.getWood() > this.wood || r.getClay() > this.clay)
            return 1;
        else return 0;
    }

    public void subtract(Integer clay, Integer wood, Integer iron){
        this.clay -= clay;
        this.wood -= wood;
        this.iron -= iron;
    }

    public void subtract(Resources r){
        this.clay -= r.getClay();
        this.wood -= r.getWood();
        this.iron -= r.getIron();
    }

    public void multiply(int value){
        this.clay *= value;
        this.wood *= value;
        this.iron *= value;
    }

    public Resources multiplyResource(int value){
        return new Resources(this.getClay() * value, this.getWood() * value, this.getIron() * value);
    }
}
