package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

/**
 * Project: springDataJpa
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 03:36 |
 * Created with IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceEntity {
    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.getUserById(id);
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public void updateUser(User user) {
        if (!repository.existsById(user.getId()))
            throw new RuntimeException("Не удалось найти пользователя с id: " + user.getId());
        repository.save(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return repository.getUserByEmailAndPassword(email, password);
    }
}
