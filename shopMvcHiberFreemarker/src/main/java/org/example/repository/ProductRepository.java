package org.example.repository;

import org.example.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Project: springMvc
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 06.05.2023 02:43 |
 * Created with IntelliJ IDEA
 */
@Repository
public class ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = sessionFactory.getCurrentSession().createQuery("FROM Product");
        return query.getResultList();
    }

    @Transactional
    public void saveProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Transactional
    public void updateProduct(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Transactional
    public Product getProductById(long id) {
        TypedQuery<Product> query = sessionFactory.getCurrentSession().createQuery("FROM Product WHERE id = :id");
        return query.setParameter("id", id).getSingleResult();
    }

    @Transactional
    public void deleteProductById(long id) {
        Product product = sessionFactory.getCurrentSession().find(Product.class, id);
        sessionFactory.getCurrentSession().delete(product);
    }
}
