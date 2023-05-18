package com.example.finalprojectgroup;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerGUIController {

    private CustomerDatabase database;

    public void addCustomer() {
        // Create a new customer object.
        ConcreteCustomer customer = new ConcreteCustomer(ID, name, address, phone, username, password);

        // Prompt the user to enter the customer's information.
        System.out.println("Enter the customer's ID: ");
        String ID = scanner.nextLine();
        System.out.println("Enter the customer's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the customer's address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the customer's phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Enter the customer's username: ");
        String username = scanner.nextLine();
        System.out.println("Enter the customer's password: ");
        String password = scanner.nextLine();

        // Set the customer's information.
        customer.setID(ID);
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setUsername(username);
        customer.setPassword(password);

        // Add the customer to the database.
        database.addRecord(customer);

        // Display a message confirming that the customer was added.
        System.out.println("Customer added successfully.");
    }

    public void removeCustomer() {
        // Prompt the user to enter the ID of the customer to remove.
        System.out.println("Enter the ID of the customer to remove: ");
        String ID = scanner.nextLine();

        // Find the customer with the specified ID.
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getID().equals(ID)) {
                customer = c;
                break;
            }
        }

        // If the customer was found, remove it from the database.
        if (customer != null) {
            database.removeRecord(customer);

            // Display a message confirming that the customer was removed.
            System.out.println("Customer removed successfully.");
        } else {
            // Display a message indicating that the customer was not found.
            System.out.println("Customer not found.");
        }
    }

    public void setDatabase(CustomerDatabase database) {
        this.database = database;
    }
}
