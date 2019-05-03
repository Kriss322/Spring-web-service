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
public class ResourceProduction implements Serializable {
    private Integer clayProdPerHour;
    private Integer woodProdPerHour;
    private Integer ironProdPerHour;

    public void addClay(Integer clayValue){
        this.clayProdPerHour += clayValue;
    }

    public void addWood(Integer woodValue){
        this.woodProdPerHour += woodValue;
    }

    public void addIron(Integer ironValue){
        this.ironProdPerHour += ironValue;
    }
}
