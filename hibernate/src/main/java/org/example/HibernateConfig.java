package org.example;

import org.example.models.Car;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Project: hibernate
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.04.2023 00:17 |
 * Created with IntelliJ IDEA
 */
public class HibernateConfig {
    /**
     * JDBC
     */
    private static final String user = "postgres";
    private static final String pass = "1234";
    private static final String db = "Car";
    private static final String url = "jdbc:postgresql://localhost:5432/" + db;
    private static final String driver = "org.postgresql.Driver";
    /**
     * hibernate
     */
    private static SessionFactory sessionFactory;

    /**
     * JDBC
     */
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    /**
     * hibernate
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.URL, url);
                settings.put(Environment.DRIVER, driver);
                settings.put(Environment.USER, user);
                settings.put(Environment.PASS, pass);
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Car.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
