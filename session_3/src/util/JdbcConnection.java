package session_3.src.util;

import session_3.src.model.DBProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class JdbcConnection {

    public JdbcConnection() {
    }

    public static Connection connect() {

        Connection connection = null;
        try (FileInputStream stream = new FileInputStream("session_3/db.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            DBProperties db = getDbProperties(properties);
            connection = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUser(),
                    db.getPassword());
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

    private static DBProperties getDbProperties(Properties properties) {
        DBProperties dbProperties = new DBProperties();
        dbProperties.setUrl(properties.getProperty("jdbc.url"));
        dbProperties.setUser(properties.getProperty("jdbc.user"));
        dbProperties.setPassword(properties.getProperty("jdbc.password"));
        return dbProperties;
    }

}
