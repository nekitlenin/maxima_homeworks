package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import web.model.Author;

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
public interface AuthorRepository extends CrudRepository<Author, Long> {

    @NonNull
    Optional<Author> findById(@NonNull Long id);

    @NonNull
    List<Author> findAll();
}
