package com.example.finalprojectgroup;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerGUI extends Application {

    private Label label;
    private Button addButton;
    private Button removeButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        label = new Label("No customers");
        addButton = new Button("Add Customer");
        removeButton = new Button("Remove Customer");

        addButton.setOnAction(e -> {
            // Add customer code here
        });

        removeButton.setOnAction(e -> {
            // Remove customer code here
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, addButton, removeButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private Customer currentCustomer;

    public void addCustomer() {
    // Create a new customer object.
    Customer customer = new Customer();

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

    // Add the customer to the list of customers.
    customers.add(customer);

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

    // If the customer was found, remove it from the list of customers.
    if (customer != null) {
        customers.remove(customer);

        // Display a message confirming that the customer was removed.
        System.out.println("Customer removed successfully.");
    } else {
        // Display a message indicating that the customer was not found.
        System.out.println("Customer not found.");
    }
}
}
