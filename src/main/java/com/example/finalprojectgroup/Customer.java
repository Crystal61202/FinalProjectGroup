package com.example.finalprojectgroup;

import java.util.ArrayList;

public abstract class Customer {
    protected static String ID;
    private String name;
    private String address;
    private String phone;
    private ArrayList<Rental> rentals;
    private String username;
    private String password;
    private List<Customer> customers;

    public Customer(String ID, String name, String address, String phone, String username, String password) {
        if (!isValidID(ID)) {
            throw new IllegalArgumentException("Invalid ID format.");
        }
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rentals = new ArrayList<>();
        this.username = username;
        this.password = password;
        customers = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental rental) {
        if (this instanceof GuestAccount && rentals.size() >= 2 && rental.getDays() == 2) {
            System.out.println("Error: Guest account can only rent 1-day items.");
        } else {
            rentals.add(rental);
            if (this instanceof VIPAccount) {
                ((VIPAccount) this).addRewardPoints(10);
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static boolean isValidID(String ID) {
        return ID.matches("^C\\d{3}$");
    }
}

class Rental {
    private String itemID;
    private int days;

    public Rental(String itemID, int days) {
        this.itemID = itemID;
        this.days = days;
    }

    public String getItemID() {
        return itemID;
    }

    public int getDays() {
        return days;
    }
}
