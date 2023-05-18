package com.example.finalprojectgroup;

import java.io.Serializable;
import java.util.Arrays;

public class GuestAccount extends Customer implements Serializable {

    public GuestAccount(String ID, String name, String address, String phone, String username, String password) {
        super(ID, name, address, phone, username, password);
    }

    @Override
    public void addRental(Rental rental) {
        if (getRentals().size() >= 2 && rental.getDays() == 2) {
            System.out.println("Error: Guest account can only rent 1-day items.");
        } else {
            getRentals().add(rental);
            if (getRentals().size() > 3) {
                RegularAccount regularAccount = new RegularAccount(getID(), getName(), getAddress(), getPhone(), getUsername(), getPassword());
                for (Rental r : getRentals()) {
                    regularAccount.addRental(r);
                }
                // delete the current guest account
            }
        }
    }
}
