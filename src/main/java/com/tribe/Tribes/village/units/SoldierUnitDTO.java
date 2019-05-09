package com.tribe.Tribes.village.units;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SoldierUnitDTO {

    private String name;

    protected int numberOfSoldiers;
}
