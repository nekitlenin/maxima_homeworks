package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Project: hibernateSpring26
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 01.05.2023 20:45 |
 * Created with IntelliJ IDEA
 */
@Entity
@Data
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int count;

    @ManyToMany(mappedBy = "ingredients")
    private List<Dishes> dishes;
}
