package com.tribe.Tribes.village;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
public class ResourceProduction{
    private int clayProdPerHour;
    private int woodProdPerHour;
    private int ironProdPerHour;
}
