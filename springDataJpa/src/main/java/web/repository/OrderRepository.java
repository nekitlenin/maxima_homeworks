package web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.model.Order;

import java.util.List;

/**
 * Project: springDataJpa
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 18.05.2023 02:18 |
 * Created with IntelliJ IDEA
 */
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();

    Order getOrderById(Long id);

    Order save(Order order);

    void deleteById(Long id);

    List<Order> findByUserId(Long userId);
}
