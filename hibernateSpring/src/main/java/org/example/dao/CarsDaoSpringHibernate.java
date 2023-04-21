package org.example.dao;

import org.example.entity.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Project: hibernateSpring
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 14.04.2023 23:26 |
 * Created with IntelliJ IDEA
 */
@Repository
public class CarsDaoSpringHibernate implements CarsDao {

    @Autowired
    SessionFactory sessionFactory;

    /**
     * Получение машины по id
     */
    @Transactional
    public Car selectCarById(long id) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car car WHERE car.id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    /**
     * Получение List<Car>
     */
    @Transactional
    public List<Car> getListOfCarCarsTable() {
        return sessionFactory.getCurrentSession().createQuery("FROM Car").getResultList();
    }
}
