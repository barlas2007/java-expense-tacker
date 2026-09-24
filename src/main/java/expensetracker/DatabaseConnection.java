package expensetracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/Java Expense Tracker";

    private static final String USER = "postgres";

    private static final String PASSWORD =
            System.getenv("DB_PASSWORD");

    static {
        if (PASSWORD == null) {
            throw new IllegalStateException(
                    "DB_PASSWORD environment variable is not set"
            );
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
