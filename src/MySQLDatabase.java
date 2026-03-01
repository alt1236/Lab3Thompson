/**
 * Project: Retail Store Database Project
 * Purpose Details: Handles MySQL CRUD operations
 * Course: IST 242
 * Author: Alyssa Thompson
 * Date Developed: 02/28/2026
 * Last Date Changed: 03/01/2026
 * Rev: 1.0
 */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


public class MySQLDatabase {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/retaildb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "IST888IST888";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create
            insertCustomer(connection, 1, "John", "Smith", "john@email.com", "1234567890");
            insertCustomer(connection, 2, "Mary", "Brown", "mary@email.com", "2345678901");
            insertCustomer(connection, 3, "David", "Bowie", "david@email.com", "3456789012");



            // Read
            List<Customer> customers = getAllCustomers(connection);
            for (Customer customer : customers) {
                System.out.println(customer.toString());
            }

            // Update
            updateCustomer(connection, 1, "updated@email.com");

            // Read again
            customers = getALLCustomers(connection);
            for (Customer customer : customers) {
                System.out.println(customer.toString());
            }

            // Delete
            deleteCustomer(connection, 3);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Customer> getAllCustomers(Connection connection) {
        return List.of();
    };

    public static void insertCustomer(Connection connection, int id, String firstName, String lastName, String email, String phone) throws SQLException {

        String sql = "INSERT INTO Customer (customerId, firstName, lastName, email, phone) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.executeUpdate();
        }
    }

    private static List<Customer> getALLCustomers(Connection connection) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT customerId, firstName, lastName, email, phone FROM Customer";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("customerId");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                customers.add(new Customer(id, firstName, lastName, email, phone));
            }
        }
        return customers;
    }

    private static void updateCustomer(Connection connection, int id, String newEmail) throws SQLException {
        String sql = "UPDATE Customer SET email = ? WHERE customerId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }

    private static void deleteCustomer(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM Customer WHERE customerId = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}


