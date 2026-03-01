

/**
 * Project: Retail Store Database Project
 * Purpose Details: Main driver class
 * Course: IST 242
 * Author: Alyssa Thompson
 * Date Developed: 02/28/2026
 * Last Date Changed: 03/01/2026
 * Rev: 3.0
 */

public class Main {
    public static void main(String[] args) throws Exception{

        Customer customer1 = new Customer(1, "John", "Smith", "john@email.com", "1234567890");
        Customer customer2 = new Customer(2, "Mary", "Brown", "mary@email.com", "2345678901");
        Customer customer3 = new Customer(3, "David", "Bowie", "david@email.com", "3456789012");

        MySQLDatabase mysql = new MySQLDatabase();
        MongoCRUD mongo = new MongoCRUD();

        // Insert
        mysql.insertCustomer(customer1);
        mysql.insertCustomer(customer2);
        mysql.insertCustomer(customer3);

        //Read
        mysql.readCustomers();

        //Update
        mysql.updateCustomer(1, "updated@email.com");

        //Delete
        mysql.deleteCustomer(3);
        mysql.close();

        // Insert
        mongo.insertCustomer(customer1);
        mongo.insertCustomer(customer2);
        mongo.insertCustomer(customer3);

        //Read
        mongo.readCustomers();

        //Update
        mongo.updateCustomer(1, "updated@email.com");

        //Delete
        mongo.deleteCustomer(3);
        mongo.close();
    }
}
