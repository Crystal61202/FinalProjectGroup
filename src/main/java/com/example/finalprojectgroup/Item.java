package com.example.finalprojectgroup;

import java.util.Arrays;

public abstract class Item implements java.io.Serializable {
    private int numberOfCopies;
    private double rentalFee;
    private String ID, title, rentType, loanType, rentalStatus;
    private static int trackingId = 0;
    private int year;

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

    private void setID(){
        this.ID = formatID();
    }

    private String formatID(){
        trackingId++;
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
        String[] availableRentType = {"DVD", "Game", "Record"};
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

