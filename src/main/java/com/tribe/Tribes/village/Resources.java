
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
public class Resources implements Serializable{
    private Integer clay;
    private Integer wood;
    private Integer iron;
}
