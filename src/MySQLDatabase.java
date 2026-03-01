/**
 * Project: Retail Store Database Project
 * Purpose Details: Handles MySQL CRUD operations
 * Course: IST 242
 * Author: Alyssa Thompson
 * Date Developed: 02/28/2026
 * Last Date Changed: 03/01/2026
 * Rev: 3.0
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

    private Connection connection;

    // Constructor opens the connection
    public MySQLDatabase() throws SQLException {
        this.connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    /**
     * Inserts a customer into MySQL database.
     */
    public void insertCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO Customer (customerId, firstName, lastName, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getPhone());
            ps.executeUpdate();
        }
    }
    /**
     * Reads all customers.
     */
    public void readCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT customerId, firstName, lastName, email, phone FROM Customer";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("customerId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("phone")
                ));
            }
        }
        for (Customer c : customers) {
            System.out.println(c.toString());
        }
    }
    /**
     * Updates customer email.
     */
    public void updateCustomer(int id, String newEmail) throws SQLException {
        String sql = "UPDATE Customer SET email = ? WHERE customerId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newEmail);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
    /**
     * Deletes a customer.
     */
    public void deleteCustomer(int id) throws SQLException {
        String sql = "DELETE FROM Customer WHERE customerId = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    /**
     * Closes the database connection.
     */
    public void close() throws SQLException {
        if (connection != null) connection.close();
    }
}


