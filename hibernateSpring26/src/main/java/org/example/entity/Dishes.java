package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Project: hibernateSpring26
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 01.05.2023 02:35 |
 * Created with IntelliJ IDEA
 */
@Entity
@Data
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    @ManyToOne
//    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToMany
    @JoinColumn
    private List<Ingredients> ingredients;
}
