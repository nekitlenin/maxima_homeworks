package org.example.entity;

import lombok.Data;
import org.example.dto.Animal;

import javax.persistence.Entity;

/**
 * Project: hibernateSpring
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 21.04.2023 21:26 |
 * Created with IntelliJ IDEA
 */
@Entity
@Data
public class Dog extends Animal {
    private String sex;
    private String breed;
    private String behavior;
    private int numberOfCommands;
    private String rabiesVaccine;
}
