package com.example.finalprojectgroup;

import java.util.Arrays;

//Creating abstract class Item, implements Serializable for saving the whole object in the file
public abstract class Item implements java.io.Serializable {
    //Declare Item's field
    private int numberOfCopies;
    private double rentalFee;
    private String ID, title, rentType, loanType, rentalStatus;
    private static int trackingId = ItemDatabase.getRecord("src/main/resources/com/example/data/item.txt").size();
    private int year;

    // Contructor for Item
    // year to make ID,
    public Item(Integer year, String title, String rentType, String loanType, Integer numberOfCopies, double rentalFee){
        this.year = year;
        this.title = title;
        setRentType(rentType);
        this.loanType = loanType;
        this.numberOfCopies = numberOfCopies;
        this.rentalFee = rentalFee;
        setRentalStatus();
        setID();
    }

    //default constructor
    public Item() {

    }

    public double getRentalFee() {
        return rentalFee;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public String getID() {
        return ID;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getRentalStatus() {
        return rentalStatus;
    }

    public String getRentType() {
        return rentType;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public static int getTrackingId() {
        return trackingId;
    }

    public void setID(){
        this.ID = formatID();
    }

    private String formatID(){
        trackingId = ItemDatabase.getRecord("src/main/resources/com/example/data/item.txt").size()+1;
        return String.format("I"+"%03d"+"-"+getYear(),trackingId);
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
        setRentalStatus();
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setRentalStatus() {
        if(getNumberOfCopies() <= 0){
            this.rentalStatus = "borrowed";
        } else {
            this.rentalStatus = "available";
        }
    }

    public void setRentType(String rentType) {
        String[] availableRentType = {"DVD", "VideoGame", "OldMovieRecord"};
        if (Arrays.asList(availableRentType).contains(rentType)) {
            this.rentType = rentType;
        } else{
            throw new IllegalArgumentException("rent type is not valid, 3 available rent type are DVD, VideoGame, OldMovieRecord");
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

