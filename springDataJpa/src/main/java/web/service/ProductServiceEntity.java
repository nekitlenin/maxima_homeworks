package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Product;
import web.repository.ProductRepository;

import java.util.List;

/**
 * Project: springDataJpa
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.05.2023 11:33 |
 * Created with IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceEntity {
    private final ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.getProductById(id);
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

    public void updateProduct(Product product) {
        if (!repository.existsById(product.getId()))
            throw new RuntimeException("Не удалось найти продукт с id: " + product.getId());
        repository.save(product);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
