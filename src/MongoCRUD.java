/**
 * Project: Retail Store Database Project
 * Purpose Details: MongoDB CRUD operations using Customer collection
 * Course: IST 242
 * Author: Alyssa Thompson
 * Date Developed: 02/28/2026
 * Last Date Changed: 03/01/2026
 * Rev: 1.0
 */

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class MongoCRUD {
    public static void main(String[] args) {
        // Create a MongoClient using the factory method
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            // Access the database and collection
            MongoDatabase database = mongoClient.getDatabase("retaildb");
            MongoCollection<Document> collection = database.getCollection("customers");

            // Create
            Document newCustomer1 = new Document("customerId", 1)
                    .append("firstName", "John")
                    .append("lastName", "Smith")
                    .append("email", "john@email.com")
                    .append("phone", "1234567890");

            Document newCustomer2 = new Document("customerId", 2)
                    .append("firstName", "Mary")
                    .append("lastName", "Brown")
                    .append("email", "mary@email.com")
                    .append("phone", "2345678901");

            Document newCustomer3 = new Document("customerId", 3)
                    .append("firstName", "David")
                    .append("lastName", "Bowie")
                    .append("email", "david@email.com")
                    .append("phone", "3456789012");

            collection.insertOne(newCustomer1);
            collection.insertOne(newCustomer2);
            collection.insertOne(newCustomer3);

            // Read
            System.out.println("MongoDB Read:");
            FindIterable<Document> customers = collection.find();
            for (Document customer : customers) {
                System.out.println(customer.toJson());
            }

            // Update
            Document updatedCustomer = new Document("$set", new Document("email", "updated@email.com"));
            collection.updateOne(new Document("customerId", 1), updatedCustomer);

            // Read again
            System.out.println("MongoDB READ AFTER UPDATE:");
            customers = collection.find();
            for (Document customer : customers) {
                System.out.println(customer.toJson());
            }

            // Delete
            collection.deleteOne(new Document("customerId", 3));

        }
    }
}


