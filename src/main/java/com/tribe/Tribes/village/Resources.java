
package com.tribe.Tribes.village;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
public class Resources {
    private int clay;
    private int wood;
    private int iron;
}
