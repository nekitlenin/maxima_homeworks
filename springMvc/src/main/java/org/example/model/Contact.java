package org.example.model;

import lombok.*;

/**
 * Project: springMvc
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 23.04.2023 00:44 |
 * Created with IntelliJ IDEA
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Contact {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
