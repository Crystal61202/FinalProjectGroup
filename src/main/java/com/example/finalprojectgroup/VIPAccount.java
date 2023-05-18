package com.example.finalprojectgroup;

import java.io.Serializable;

public class VIPAccount extends Customer implements Serializable {

    private int rewardPoints;

    public VIPAccount(String ID, String name, String address, String phone, String username, String password) {
        super(ID, name, address, phone, username, password);
        this.rewardPoints = 0;
    }
    public void addRewardPoints(int points) {
        this.rewardPoints += points;
        if (this.rewardPoints >= 100) {
            System.out.println("You have enough reward points to rent 1 item for free.");
        }
    }
}
