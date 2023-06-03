package com.example.SpringBootDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Project: SpringBoot_3_1_2
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 03.06.2023 17:45 |
 * Created with IntelliJ IDEA
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String text;

    private LocalDate dateCreate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

}
