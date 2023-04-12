package org.example;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Project: jdbc22
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 11.04.2023 00:21 |
 * Created with IntelliJ IDEA
 */
public class ConnectionTest {

    @Test
    @SneakyThrows
    public void testConnection() {
        Connection connection = Config.getConnection();
        System.out.println(connection.isValid(1));
        System.out.println(connection.isClosed());
        Assert.assertTrue(connection.isValid(1));
        Assert.assertFalse(connection.isClosed());
    }
}
