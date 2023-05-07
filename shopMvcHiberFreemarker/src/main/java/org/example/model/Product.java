package org.example.model;

import lombok.*;

import javax.persistence.*;

/**
 * Project: springMvc
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 23.04.2023 00:44 |
 * Created with IntelliJ IDEA
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private int count;
}
