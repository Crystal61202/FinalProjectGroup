package com.example.finalprojectgroup;

import java.util.Arrays;

public class DVD extends Item implements java.io.Serializable {


    private String genre;

    public DVD(Integer year, String title, String rentType, String loanType, Integer numberOfCopies, double rentalFee, String genre) {
        super(year, title, rentType, loanType, numberOfCopies, rentalFee);
        setGenre(genre);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        String[] availableGenre = {"Action", "Horror", "Drama", "Comedy"};
        if (Arrays.asList(availableGenre).contains(genre)) {
            this.genre = genre;
        } else {
            throw new IllegalArgumentException("Genre is not valid, 4 available genres are Action, Horror, Drama, Comedy ");
        }
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,%.2f,%s,%s",
                getID(), getTitle(), getRentType(), getLoanType(), getNumberOfCopies(), getRentalFee(), getRentalStatus(), getGenre());
    }
}
