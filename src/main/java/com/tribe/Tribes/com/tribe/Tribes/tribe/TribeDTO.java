package com.tribe.Tribes.com.tribe.Tribes.tribe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TribeDTO {

    private Integer id;

    private String name;

    private String description;

    private int points;

    private List<Integer> memberPlayerIds;

    private List<Integer> enemyTribeIds;

    private List<Integer> allyTribeIds;
}
