package com.example.finalprojectgroup;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ItemDatabase {

    public static void addRecord(String filePath, Item item) {
        ArrayList<Item> existingItems = getRecord(filePath); // Load existing items

        // Add the new item to the existing items
        existingItems.add(item);

        // Remove duplicates from the list
        Set<Item> uniqueItems = new HashSet<>(existingItems);
        existingItems = new ArrayList<>(uniqueItems);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Item existingItem : existingItems) {
                out.writeObject(existingItem); // Write all unique items back to the file
            }

        } catch (IOException e) {
            System.out.println("Error occurred while writing to the database file: " + e.getMessage());
        }
    }


    public static ArrayList<Item> getRecord(String filePath) {
        ArrayList<Item> list = new ArrayList<>();
        Set<String> itemIds = new HashSet<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    Item obj = (Item) in.readObject();

                    if (!itemIds.contains(obj.getID())) {
                        list.add(obj);
                        itemIds.add(obj.getID());
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

    public static void deleteAllItems() {
        String filePath = "src/main/resources/com/example/data/item.txt";
        ArrayList<Item> emptyList = new ArrayList<>();

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (Item obj : emptyList) {
                out.writeObject(obj);
            }

        } catch (IOException e) {
            System.out.println("Error occurred while deleting items from the database file: " + e.getMessage());
        }
    }
}