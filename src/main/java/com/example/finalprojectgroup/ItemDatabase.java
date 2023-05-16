package com.example.finalprojectgroup;
import java.io.*;

public class ItemDatabase {
    private static final String DELIMITER = ",";

    public static void addRecord(String filePath, String record) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String line = String.join(DELIMITER, record);
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the database file: " + e.getMessage());
        }
    }

}