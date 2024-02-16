package electricitybillingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class conn {
    Connection connection;
    Statement s;
    PreparedStatement preparedStatement;

    public conn() {
        try {
            // Initialize the database connection and statement
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill", "root", "yashika14");
            s = connection.createStatement();
        } catch (SQLException e) {
            // Handle exceptions properly, e.g., print the error message
            e.printStackTrace();
        }
    }

    public PreparedStatement getPreparedStatement(String query) {
        try {
            // Create a prepared statement from the connection
            preparedStatement = connection.prepareStatement(query);
            return preparedStatement;
        } catch (SQLException e) {
            // Handle exceptions properly, e.g., print the error message
            e.printStackTrace();
            return null;
        }
    }

    public Statement getStatement() {
        return s;
    }
}

