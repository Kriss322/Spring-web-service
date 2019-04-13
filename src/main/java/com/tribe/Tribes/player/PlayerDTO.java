/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribe.Tribes.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kkassa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class PlayerDTO {
    
    private String name;

    private int playerPoints;

    private String titleInTribe;
}
