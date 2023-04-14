package org.example.dao;

import org.example.HibernateConfig;
import org.example.models.Car;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

import static org.hibernate.resource.transaction.spi.TransactionStatus.ACTIVE;
import static org.hibernate.resource.transaction.spi.TransactionStatus.MARKED_ROLLBACK;

/**
 * Project: hibernate
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 13.04.2023 03:16 |
 * Created with IntelliJ IDEA
 */
public class CarsDaoHibernate implements CarsDao {

    /**
     * Создание таблицы
     */
    public void createCarsTable() {
        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("CREATE TABLE IF NOT EXISTS cars" +
                    "(id serial primary key, " +
                    "brand varchar(20), " +
                    "model varchar(20), " +
                    "number_plate varchar(9)," +
                    "date_of_create date)");
            query.executeUpdate();
            transaction.commit();
            System.out.println("Таблица успешно создана!");
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK)
                transaction.rollback();
        }
    }

    /**
     * Удаление таблицы
     */
    public void dropCarsTable() {
        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE IF EXISTS cars");
            query.executeUpdate();
            transaction.commit();
            System.out.println("Таблица успешно удалена!");
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK)
                transaction.rollback();
        }
    }

    /**
     * Добавление машины
     */
    public void addCar(String brand, String model, String numberPlate, java.sql.Date dateOfCreate) {
        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(new Car(brand, model, numberPlate, dateOfCreate));
            transaction.commit();
            System.out.println("Машина добавлена!!");
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK)
                transaction.rollback();
        }
    }

    /**
     * Очистка таблицы (не удаление)
     */
    public void cleanCarsTable() {
        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createSQLQuery("DROP TABLE IF EXISTS cars");
            query.executeUpdate();
            transaction.commit();
            System.out.println("Таблица успешно очищена!");
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK)
                transaction.rollback();
        }
    }

    /**
     * Получение машины по id
     */
    public Car selectCarById(long id) {
        Car car = new Car();
        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Car> query = session.createQuery("SELECT c FROM Car c WHERE c.id = :carId");
            query.setParameter("carId", id);
            car = query.getSingleResult();
            transaction.commit();
            System.out.println("Список машин получен!");
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK)
                transaction.rollback();
        }
        return car;
    }

    /**
     * Удаление машины по id
     */
    public void deleteCarById(long id) {
        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Car> query = session.createQuery("DELETE Car WHERE id = :carId");
            query.setParameter("carId", id);
            transaction.commit();
            System.out.println("Машина удалена!");
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK)
                transaction.rollback();
        }
    }


    /**
     * Получение List<Car>
     */
    public List<Car> getListOfCarCarsTable() {
        List<Car> cars = Collections.emptyList();
        Transaction transaction = null;

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Car> query = session.createQuery("FROM Car");
            cars = query.list();
            transaction.commit();
            System.out.println("Список машин получен!");
        } catch (Exception e) {
            if (transaction != null || transaction.getStatus() == ACTIVE || transaction.getStatus() == MARKED_ROLLBACK)
                transaction.rollback();
        }
        return cars;
    }
}
