package com.example.finalprojectgroup;

import java.io.Serializable;
import java.util.Arrays;

public class RegularAccount extends Customer implements Serializable {

    public RegularAccount(String ID, String name, String address, String phone, String username, String password) {
        super(ID, name, address, phone, username, password);
    }

    @Override
    public void addRental(Rental rental) {
        super.addRental(rental);
        if (getRentals().size() > 5) {
            VIPAccount vipAccount = new VIPAccount(getID(), getName(), getAddress(), getPhone(), getUsername(), getPassword());
            for (Rental r : getRentals()) {
                vipAccount.addRental(r);
            }
            // delete the current regular account
        }
    }
}
