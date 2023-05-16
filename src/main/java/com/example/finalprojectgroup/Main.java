package com.example.finalprojectgroup;

public class Main {
    public static void main(String[] args) {
        DVD dvd1 = new DVD("I001-2001","Medal of Honour","Game","1-week",3,3.99,"rented","Horror");
        VideoGame game1 = new VideoGame("I001-2001","Medal of Honour","Game","1-week",3,3.99,"rented");
        OldMovieRecord rc1 = new OldMovieRecord("I001-2001","Medal of Honour","Game","1-week",3,3.99,"rented","Horror");


        ItemDatabase.addRecord("src/main/resources/com/example/data/item.txt",dvd1.toString());
        ItemDatabase.addRecord("src/main/resources/com/example/data/item.txt",game1.toString());
        ItemDatabase.addRecord("src/main/resources/com/example/data/item.txt",rc1.toString());

    }
}