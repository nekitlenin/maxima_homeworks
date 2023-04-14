package org.example.dao;

import org.example.HibernateConfig;
import org.example.models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: hibernate
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.04.2023 00:58 |
 * Created with IntelliJ IDEA
 */
public class CarsDaoJdbc implements CarsDao {

    /**
     * Создание таблицы
     */
    public void createCarsTable() {
        try (Connection connection = HibernateConfig.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS cars" +
                    "(id serial primary key, " +
                    "brand varchar(20), " +
                    "model varchar(20), " +
                    "number_plate varchar(9)," +
                    "date_of_create date)");
            System.out.println("Таблица успешно создана!");
        } catch (SQLException e) {
            System.err.println("Ошибка при создании таблицы: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Удаление таблицы
     */
    public void dropCarsTable() {
        try (Connection connection = HibernateConfig.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS cars");
            System.out.println("Таблица успешно удалена!");
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении таблицы: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Очистка таблицы (не удаление)
     */
    public void cleanCarsTable() {
        // language=SQL
        final String DELETE_ALL_CARS = "DELETE FROM cars";

        try (Connection connection = HibernateConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL_CARS)) {
            int result = preparedStatement.executeUpdate();
            if (result > 0)
                System.out.println("Таблица успешно очищена!");
            else
                System.out.println("Таблица уже пуста!");
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении таблицы: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Добавление машины
     */
    public void addCar(String brand, String model, String numberPlate, java.sql.Date dateOfCreate) {
        // language=SQL
        final String INSERT_CAR = "INSERT INTO cars(brand, model, number_plate, date_of_create) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = HibernateConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CAR)) {
            preparedStatement.setString(1, brand);
            preparedStatement.setString(2, model);
            preparedStatement.setString(3, numberPlate);
            preparedStatement.setDate(4, dateOfCreate);
            preparedStatement.execute();
            System.out.println("Машина успешно добавлена!");
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении машины в таблицу: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Удаление машины по id
     */
    public void deleteCarById(long id) {
        // language=SQL
        final String DELETE_CAR_BY_ID = "DELETE FROM cars WHERE id = ?";

        try (Connection connection = HibernateConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAR_BY_ID)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            System.out.println("Машина успешно удалена!");
        } catch (SQLException e) {
            System.err.println("Ошибка при удалении машины по id из таблицы: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Получение машины по id
     */
    public Car selectCarById(long id) {
        // language=SQL
        final String SELECT_CAR_BY_ID = "SELECT * FROM cars WHERE id = ?";
        Car car = null;

        try (Connection connection = HibernateConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CAR_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                String numberPlate = resultSet.getString("number_plate");
                java.sql.Date dateOfCreate = resultSet.getDate("date_of_create");
                car = new Car(id, brand, model, numberPlate, dateOfCreate);
            }
            System.out.println("Машина успешно найдена!");
            return car;
        } catch (SQLException e) {
            System.err.println("Ошибка при поиске машины по id из таблицы: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Получение List<Car>
     */
    public List<Car> getListOfCarCarsTable() {
        List<Car> cars = new ArrayList<>();

        try (Connection connection = HibernateConfig.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                String numberPlate = resultSet.getString("number_plate");
                java.sql.Date dateOfCreate = resultSet.getDate("date_of_create");

                cars.add(new Car(id, brand, model, numberPlate, dateOfCreate));
            }
            return cars;
        } catch (SQLException e) {
            System.err.println("Ошибка при получении листа таблицы: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
