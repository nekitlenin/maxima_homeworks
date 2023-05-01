package org.example.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Project: hibernateSpring
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 01.05.2023 00:42 |
 * Created with IntelliJ IDEA
 */
@Entity
@Data
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int tableNumber;

    private int numberOfSeats;

    @OneToOne
    private Orders orders;
}
