/**
 * Project: Retail Store Database Project
 * Purpose Details: MongoDB CRUD operations using Customer collection
 * Course: IST 242
 * Author: Alyssa Thompson
 * Date Developed: 02/28/2026
 * Last Date Changed: 03/01/2026
 * Rev: 3.0
 */

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class MongoCRUD {
    private MongoClient mongoClient;
    private MongoCollection<Document> collection;

    // Constructor opens the connection
    public MongoCRUD() {
        this.mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("retaildb");
        this.collection = database.getCollection("customers");
    }
    /**
     * Inserts a new customer
     */
    public void insertCustomer(Customer customer) {
        Document doc = new Document("customerId", customer.getCustomerId())
                .append("firstName", customer.getFirstName())
                .append("lastName", customer.getLastName())
                .append("email", customer.getEmail())
                .append("phone", customer.getPhone());
        collection.insertOne(doc);
    }

    /**
     * Reads all customers.
     */
    public void readCustomers() {
        System.out.println("MongoDB Read:");
        FindIterable<Document> customers = collection.find();
        for (Document customer : customers) {
            System.out.println(customer.toJson());
        }
    }

    /**
     * Updates customer email.
     */
    public void updateCustomer(int id, String newEmail) {
        Document filter = new Document("customerId", id);
        Document update = new Document("$set", new Document("email", newEmail));
        collection.updateOne(filter, update);
    }

    /**
     * Deletes a customer.
     */
    public void deleteCustomer(int id) {
        collection.deleteOne(new Document("customerId", id));
    }

    /**
     * Closes the database connection.
     */
    public void close() {
        if (mongoClient != null) mongoClient.close();
    }
}