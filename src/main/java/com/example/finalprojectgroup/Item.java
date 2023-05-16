package com.example.finalprojectgroup;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public abstract class Item {
    private int numberOfCopies;
    private double rentalFee;
    private String ID, title, rentType, loanType, rentalStatus;

    public Item(String ID, String title, String rentType, String loanType, Integer numberOfCopies, double rentalFee, String rentalStatus){
        this.ID = ID;
        this.title = title;
        this.rentType = rentType;
        this.loanType = loanType;
        this.numberOfCopies = numberOfCopies;
        this.rentalFee = rentalFee;
        this.rentalStatus = rentalStatus;
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

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}

class VideoGame extends Item {
    public VideoGame(String ID, String title, String rentType, String loanType, Integer numberOfCopies, double rentalFee, String rentalStatus) {
        super(ID, title, rentType, loanType, numberOfCopies, rentalFee, rentalStatus);
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,%.2f,%s",
                getID(), getTitle(), getRentType(), getLoanType(), getNumberOfCopies(), getRentalFee(), getRentalStatus());
    }



}

class DVD extends Item{


    private String genre;
    public DVD(String ID, String title, String rentType, String loanType, Integer numberOfCopies, double rentalFee, String rentalStatus, String genre) {
        super(ID, title, rentType, loanType, numberOfCopies, rentalFee, rentalStatus);
        String[] availableGenre = {"Action", "Horror", "Drama", "Comedy"};
        if (Arrays.asList(availableGenre).contains(genre)) {
            this.genre = genre;
        } else{
            System.out.println("the Genre is not available");
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,%.2f,%s,%s",
                getID(), getTitle(), getRentType(), getLoanType(), getNumberOfCopies(), getRentalFee(), getRentalStatus(), getGenre() );
    }
}

class OldMovieRecord extends Item {
    private String genre;

    public OldMovieRecord(String ID, String title, String rentType, String loanType, Integer numberOfCopies, double rentalFee, String rentalStatus, String genre) {
        super(ID, title, rentType, loanType, numberOfCopies, rentalFee, rentalStatus);
        String[] availableGenre = {"Action", "Horror", "Drama", "Comedy"};
        if (Arrays.asList(availableGenre).contains(genre)) {
            this.genre = genre;
        } else{
            System.out.println("the Genre is not available");
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,%.2f,%s,%s",
                getID(), getTitle(), getRentType(), getLoanType(), getNumberOfCopies(), getRentalFee(), getRentalStatus(), getGenre() );
    }
}
