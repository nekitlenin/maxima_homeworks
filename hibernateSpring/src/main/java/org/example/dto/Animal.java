package org.example.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Project: hibernateSpring
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 21.04.2023 20:36 |
 * Created with IntelliJ IDEA
 */
@Data
@MappedSuperclass
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String color;
    private int height;
    private int weight;
}
