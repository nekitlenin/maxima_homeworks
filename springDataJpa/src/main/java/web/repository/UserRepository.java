package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

/**
 * Project: springDataJpa
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 00:28 |
 * Created with IntelliJ IDEA
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User getUserById(Long id);

    User save(User user);

    void deleteById(Long id);

    User getUserByEmailAndPassword(String email, String password);
}
