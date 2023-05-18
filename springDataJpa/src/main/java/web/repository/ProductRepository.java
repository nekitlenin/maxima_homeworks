package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.Product;
import web.model.User;

import java.util.List;

/**
 * Project: springDataJpa
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 03:22 |
 * Created with IntelliJ IDEA
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    Product getProductById(Long id);

    Product save(Product product);

    void deleteById(Long id);
}
