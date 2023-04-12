package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Project: jdbc22
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.04.2023 00:17 |
 * Created with IntelliJ IDEA
 */
public class Config {
    private static final String user = "postgres";
    private static final String pass = "1234";
    private static final String db = "Car";
    private static final String url = "jdbc:postgresql://localhost:5432/" + db;

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException | ClassNotFoundException e) {
           throw new RuntimeException();
        }
    }
}
