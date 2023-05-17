package com.example.finalprojectgroup;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        // testing adding data, later we will create GUI to do it.
        DVD dvd1 = new DVD(2002,"Medal of Honour","Game","1-week",3,3.99,"Horror");
        VideoGame game1 = new VideoGame(2003,"Medal of Honour","Game","1-week",3,3.99);
        OldMovieRecord rc1 = new OldMovieRecord(2005,"Medal of Honour","Game","1-week",3,3.99,"Drama");


        ItemDatabase.addRecord("src/main/resources/com/example/data/item.txt",dvd1);
        ItemDatabase.addRecord("src/main/resources/com/example/data/item.txt",game1);
        ItemDatabase.addRecord("src/main/resources/com/example/data/item.txt",rc1);

        ArrayList<Item> list = ItemDatabase.getRecord("src/main/resources/com/example/data/item.txt");

        for (Item item : list) {
            System.out.println(item);
        }
        
        
        Customer customer = new Customer("C001", "Minh Dinh", "18 Irwin Street", "0421473243", "minhdinh", "123456");
        Rental rental1 = new Rental("I001-2001", 1);
        Rental rental2 = new Rental("I002-1988", 1);

        customer.addRecord(rental1);
        customer.addRecord(rental2);

        ArrayList<Rental> records = customer.getRecords();

        for (Rental record : records) {
            System.out.println(record);
        }

    }
}
