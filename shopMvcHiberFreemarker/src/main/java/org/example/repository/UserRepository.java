package org.example.repository;

import org.example.model.Product;
import org.example.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

/**
 * Project: springMvc
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 07.05.2023 00:16 |
 * Created with IntelliJ IDEA
 */
@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    public User getUserByEmail(String email) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email = :email");
        return query.setParameter("email", email).getSingleResult();
    }
}
