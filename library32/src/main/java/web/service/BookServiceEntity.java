package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Author;
import web.model.Book;
import web.model.Genre;
import web.repository.BookRepository;

import java.util.List;
import java.util.Optional;

/**
 * Project: Pikcha
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 11:33 |
 * Created with IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceEntity {

    private final BookRepository repository;

    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public List<Book> findByGenre(Optional<Genre> genre) {
        return repository.findByGenre(genre);
    }

    public List<Author> findByAuthor(Optional<Author> author) {
        return repository.findByAuthor(author);
    }
}
