
package com.example.finalprojectgroup;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CustomerDatabase {

    private static final String CUSTOMER_DATABASE_FILE_PATH = "customer_database.txt";

    public static void addCustomer(String CUSTOMER_DATABASE_FILE_PATH, Customer customer) {
        ArrayList<Customer> existingCustomers = getCustomers(CUSTOMER_DATABASE_FILE_PATH); // Load existing customers

        // Add the new customer to the existing customers
        existingCustomers.add(customer);

        // Remove duplicates from the list
        Set<Customer> uniqueCustomers = new HashSet<>(existingCustomers);
        existingCustomers = new ArrayList<>(uniqueCustomers);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CUSTOMER_DATABASE_FILE_PATH))) {
            for (Customer existingCustomer : existingCustomers) {
                out.writeObject(existingCustomer); // Write all unique customers back to the file
            }
            System.out.println("Customer added successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the database file: " + e.getMessage());
        }
    }


    public static ArrayList<Customer> getCustomers(String FilePath ) {
        ArrayList<Customer> list = new ArrayList<>();
        Set<String> customerIds = new HashSet<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(CUSTOMER_DATABASE_FILE_PATH))) {
            while (true) {
                try {
                    Customer obj = (Customer) in.readObject();

                    if (!customerIds.contains(obj.getID())) {
                        list.add(obj);
                        customerIds.add(obj.getID());
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading the database file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public static void removeCustomer(String customerID) {
        ArrayList<Customer> existingCustomers = getCustomers(CUSTOMER_DATABASE_FILE_PATH); // Load existing customers

        // Find the customer with the specified ID
        int index = -1;
        for (int i = 0; i < existingCustomers.size(); i++) {
            if (existingCustomers.get(i).getID().equals(customerID)) {
                index = i;
                break;
            }
        }

        // If the customer was found, remove it from the list
        if (index != -1) {
            existingCustomers.remove(index);
        }

        // Write the updated list to the database file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CUSTOMER_DATABASE_FILE_PATH))) {
            for (Customer existingCustomer : existingCustomers) {
                out.writeObject(existingCustomer);
            }
            System.out.println("Customer removed successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the database file: " + e.getMessage());
        }
    }
}

