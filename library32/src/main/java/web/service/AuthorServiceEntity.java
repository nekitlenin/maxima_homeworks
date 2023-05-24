package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Author;
import web.repository.AuthorRepository;

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
public class AuthorServiceEntity {

    private final AuthorRepository repository;

    public Optional<Author> findById(Long id) {
        return repository.findById(id);
    }

    public List<Author> findAll() {
        return repository.findAll();
    }
}
