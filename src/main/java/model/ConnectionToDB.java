package model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {
    public Connection getNewConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/Semestrovka1";
            String user = "postgres";
            String password = "fIZIKA2002";
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
