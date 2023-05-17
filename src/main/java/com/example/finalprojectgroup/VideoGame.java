package com.example.finalprojectgroup;

public class VideoGame extends Item implements java.io.Serializable {
    String genre = "";
    public VideoGame(Integer year, String title, String rentType, String loanType, Integer numberOfCopies, double rentalFee) {
        super(year, title, rentType, loanType, numberOfCopies, rentalFee);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,%.2f,%s",
                getID(), getTitle(), getRentType(), getLoanType(), getNumberOfCopies(), getRentalFee(), getRentalStatus());
    }


}
