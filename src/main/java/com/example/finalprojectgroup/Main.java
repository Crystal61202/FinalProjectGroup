package com.example.finalprojectgroup;

public class Main {
    public static void main(String[] args){

        // testing adding data, later we will create GUI to do it.
        DVD dvd1 = new DVD(2002,"Medal of Honour","Game","1-week",3,3.99,"rented","Horror");
        VideoGame game1 = new VideoGame(2003,"Medal of Honour","Game","1-week",3,3.99,"rented");
        OldMovieRecord rc1 = new OldMovieRecord(2005,"Medal of Honour","Game","1-week",3,3.99,"rented","Drama");
        VideoGame game2 = new VideoGame(2017,"COD","Game","1-week",3,5.99,"rented");

        ItemDatabase.addRecord("src/main/resources/com/example/data/item.txt",dvd1.toString());
        ItemDatabase.addRecord("src/main/resources/com/example/data/item.txt",game1.toString());
        ItemDatabase.addRecord("src/main/resources/com/example/data/item.txt",rc1.toString());


    }
}