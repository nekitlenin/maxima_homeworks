package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Order;
import web.model.Product;
import web.repository.OrderRepository;

import java.util.List;

/**
 * Project: springDataJpa
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 18.05.2023 02:20 |
 * Created with IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceEntity {
    private final OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order getOrderById(Long id) {
        return repository.getOrderById(id);
    }

    public Order saveOrder(Order order) {
       return repository.save(order);
    }

    public void deleteById(Long id) { repository.deleteById(id);}

    public List<Order> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
