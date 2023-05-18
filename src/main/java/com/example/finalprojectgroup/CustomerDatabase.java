
package com.example.finalprojectgroup;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CustomerDatabase {

    public static void addRecord(String filePath, Rental rental) {
        ArrayList<Rental> existingRecords = getRecord(filePath); // Load existing records

        // Add the new record to the existing records
        existingRecords.add(rental);

        // Remove duplicates from the list
        Set<Rental> uniqueRecords = new HashSet<>(existingRecords);
        existingRecords = new ArrayList<>(uniqueRecords);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Rental existingRecord : existingRecords) {
                out.writeObject(existingRecord); // Write all unique records back to the file
            }
            System.out.println("Record added successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the database file: " + e.getMessage());
        }
    }


    public static ArrayList<Rental> getRecord(String filePath) {
        ArrayList<Rental> list = new ArrayList<>();
        Set<String> rentalIds = new HashSet<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    Rental obj = (Rental) in.readObject();

                    if (!rentalIds.contains(obj.getItemID())) {
                        list.add(obj);
                        rentalIds.add(obj.getItemID());
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

    public static void removeRecord(String filePath, Rental itemID) {
        ArrayList<Rental> existingRecords = getRecord(filePath); // Load existing records

        // Find the record with the specified ID
        int index = -1;
        for (int i = 0; i < existingRecords.size(); i++) {
            if (existingRecords.get(i).getItemID().equals(itemID)) {
                index = i;
                break;
            }
        }

        // If the record was found, remove it from the list
        if (index != -1) {
            existingRecords.remove(index);
        }

        // Write the updated list to the database file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Rental existingRecord : existingRecords) {
                out.writeObject(existingRecord);
            }
            System.out.println("Record removed successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the database file: " + e.getMessage());
        }
    }
}

