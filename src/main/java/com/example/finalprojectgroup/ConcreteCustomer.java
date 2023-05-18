package com.example.finalprojectgroup;
import java.util.Scanner;

public class ConcreteCustomer extends Customer {

    public ConcreteCustomer(String ID, String name, String address, String phone, String username, String password) {
        super(ID, name, address, phone, username, password);
    }

    @Override
    public void addCustomer() {
        // Add the customer to the database.
        database.addRecord(this);

        // Display a message confirming that the customer was added.
        System.out.println("Customer added successfully.");
    }

    @Override
    public void removeCustomer() {
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
}
