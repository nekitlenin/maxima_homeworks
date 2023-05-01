package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Project: hibernateSpring
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 01.05.2023 00:41 |
 * Created with IntelliJ IDEA
 */
@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateOfOrder;

    private int sum;

    @OneToOne
    private Waiters waiter;

    @OneToOne
    private Tables table;

    @OneToMany(mappedBy = "orders")
    private List<Dishes> dishes;
}
