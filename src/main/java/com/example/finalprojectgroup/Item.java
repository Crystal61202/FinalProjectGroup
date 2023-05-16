package com.example.finalprojectgroup;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public abstract class Item implements java.io.Serializable {
    private int numberOfCopies;
    private double rentalFee;
    private String ID, title, rentType, loanType, rentalStatus;
    private static int trackingId = 0;
    private int year;

    public Item(Integer year, String title, String rentType, String loanType, Integer numberOfCopies, double rentalFee, String rentalStatus){
        this.year = year;
        this.title = title;
        setRentType(rentType);
        this.loanType = loanType;
        this.numberOfCopies = numberOfCopies;
        this.rentalFee = rentalFee;
        this.rentalStatus = rentalStatus;
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
        return String.format("I"+"%03d"+"-"+getYear(),getTrackingId());
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

    public void setYear(int year) {
        this.year = year;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
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

class VideoGame extends Item {
    public VideoGame(Integer year, String title, String rentType, String loanType, Integer numberOfCopies, double rentalFee, String rentalStatus) {
        super(year, title, rentType, loanType, numberOfCopies, rentalFee, rentalStatus);
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,%.2f,%s",
                getID(), getTitle(), getRentType(), getLoanType(), getNumberOfCopies(), getRentalFee(), getRentalStatus());
    }



}

class DVD extends Item{


    private String genre;
    public DVD(Integer year, String title, String rentType, String loanType, Integer numberOfCopies, double rentalFee, String rentalStatus, String genre) {
        super(year, title, rentType, loanType, numberOfCopies, rentalFee, rentalStatus);
        setGenre(genre);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        String[] availableGenre = {"Action", "Horror", "Drama", "Comedy"};
        if (Arrays.asList(availableGenre).contains(genre)) {
            this.genre = genre;
        } else{
            throw new IllegalArgumentException("Genre is not valid, 4 available genres are Action, Horror, Drama, Comedy ");
        }
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,%.2f,%s,%s",
                getID(), getTitle(), getRentType(), getLoanType(), getNumberOfCopies(), getRentalFee(), getRentalStatus(), getGenre() );
    }
}

class OldMovieRecord extends Item {
    private String genre;

    public OldMovieRecord(Integer year, String title, String rentType, String loanType, Integer numberOfCopies, double rentalFee, String rentalStatus, String genre) {
        super(year, title, rentType, loanType, numberOfCopies, rentalFee, rentalStatus);
        setGenre(genre);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        String[] availableGenre = {"Action", "Horror", "Drama", "Comedy"};
        if (Arrays.asList(availableGenre).contains(genre)) {
            this.genre = genre;
        } else{
            throw new IllegalArgumentException("Genre is not valid, 4 available genres are Action, Horror, Drama, Comedy ");
        }
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,%.2f,%s,%s",
                getID(), getTitle(), getRentType(), getLoanType(), getNumberOfCopies(), getRentalFee(), getRentalStatus(), getGenre() );
    }
}
