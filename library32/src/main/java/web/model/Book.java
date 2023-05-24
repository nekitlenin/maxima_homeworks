package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Project: Pikcha
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 03:15 |
 * Created with IntelliJ IDEA
 */
@NamedEntityGraph(
        name = "Book.authorsAndGenres",
        attributeNodes = {
                @NamedAttributeNode("title"),
                @NamedAttributeNode("author"),
                @NamedAttributeNode("genre")
        }
)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date_create")
    private LocalDate dateCreate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
