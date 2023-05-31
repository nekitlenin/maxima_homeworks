package web.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import web.model.Author;
import web.model.Book;
import web.model.Genre;

import java.util.List;
import java.util.Optional;

/**
 * Project: Pikcha
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 03:22 |
 * Created with IntelliJ IDEA
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @NonNull
    @EntityGraph(attributePaths = {"author", "genre"})
    List<Book> findAll();

    @EntityGraph("Book.authorsAndGenres")
    List<Book> findByGenre(Optional<Genre> genre);

    @EntityGraph("Book.authorsAndGenres")
    List<Author> findByAuthor(Optional<Author> author);

    @NonNull
    @EntityGraph("Book.titleAndAuthorName")
    Optional<Book> findById(@NonNull Long id);
}
