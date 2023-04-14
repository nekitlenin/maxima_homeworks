package org.example.dao;

import org.example.HibernateConfig;
import org.example.models.Car;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

import static org.hibernate.resource.transaction.spi.TransactionStatus.ACTIVE;
import static org.hibernate.resource.transaction.spi.TransactionStatus.MARKED_ROLLBACK;

/**
 * Project: hibernate
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
     * Добавление машины
     */
    @Transactional
    public void addCar(String brand, String model, String numberPlate, java.sql.Date dateOfCreate) {
        sessionFactory.getCurrentSession().save(new Car(brand, model, numberPlate, dateOfCreate));
    }

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
//        return typedQuery.getResultList();
    }
}
