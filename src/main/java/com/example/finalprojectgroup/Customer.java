package com.example.finalprojectgroup;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Customer implements java.io.Serializable {
    private String ID;
    private String name;
    private String address;
    private String phone;
    private static String accountType;
    private ArrayList<Item> rentals;
    private String username;
    private String password;
    public int Number_pay=0;
    public int Max_rent=0;
    public int promote_condition=0;


    public Customer(){

    }
    public Customer(String ID, String name, String address, String phone, String accountType,String username, String password) {
        if (!isValidID(ID)) {
            throw new IllegalArgumentException("Invalid ID format.");
        }
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        setAccountType(accountType);
        this.rentals = new ArrayList<>();
        this.username = username;
        this.password = password;
    }


    public String getID() {
        return ID;
    }
    public void SetID(String a){
        ID=a;
    }
    public String getName() {
        return name;
    }
    public void SetName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void SetAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void SetPhone(String phone) {this.phone = phone;}

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
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAccountType(){
        return accountType;
    }
    public void setAccountType(String accountType) {
        String[] availableAccountType = {"GuestAccount","RegularAccount","ViPAccount"};
        if (Arrays.asList(availableAccountType).contains(accountType)) {
            this.accountType = accountType;
        } else{
            throw new IllegalArgumentException("rent type is not valid, 3 available rent type are DVD, VideoGame, OldMovieRecord");
        }
    }


    public ArrayList<Item> getRentals() {return rentals;}
    public void SetRentals(ArrayList<Item> rental){this.rentals=rental;}
    public String getUsername() {return username;}
    public void SetUsername(String a){username=a;}
    public String getPassword() {return password;}
    public void SetPassword(String a){password=a;}
    public static boolean isValidID(String ID) {return ID.matches("^C\\d{3}$");}


    public static class GuestAccount extends Customer implements java.io.Serializable {
        public GuestAccount(){

        }

        public GuestAccount(String ID, String name, String address, String phone, String accountType, String username, String password) {
            super(ID, name, address, phone, accountType, username, password);
            Max_rent=2;
            promote_condition=3;
        }




        public int addRental(Item rental) {
            if (getRentals().size() == Max_rent) {
            return 0;
            //System.out.println("Error: Guest account can only rent 1-day items.");
            }
            if (rental.getLoanType()=="2-day"){
            return -1;
            }
            getRentals().add(rental);
            return 1;
        }
        //__2 promote ___ 0 false ____ 1 true
        public int remoteRental(Item rental){
            for (Item r : getRentals())
                if (rental.getTitle() == r.getTitle()){
                    getRentals().remove(r);
                    Number_pay+=1;
                    //promote account
                    if(Number_pay>promote_condition){
                        return 2;
                    }
                    return 1;
                }
            return 0;
        }
    }
    public static class RegularAccount extends GuestAccount implements  java.io.Serializable {
        public RegularAccount(){

        }

        public RegularAccount(String ID, String name, String address, String phone, String accountType, String username, String password){
            super(ID, name, address, phone, accountType, username, password);
            promote_condition=5;
        }



        @Override
        public int addRental(Item rental) {
            getRentals().add(rental);
            return 1;
        }
    }
    public static class VIPAccount extends RegularAccount implements java.io.Serializable {
        private int rewardPoints=0;
        private int rent_free=0;
        public VIPAccount(){

        }

        public VIPAccount(String ID, String name, String address, String phone, String accountType, String username, String password) {
            super(ID, name, address, phone, accountType, username, password);
        }



        public int addRental(Item rental) {
            getRentals().add(rental);
            this.rewardPoints += 10;
            //reward---------------------------
            if (this.rewardPoints >= 100) {
                rewardPoints=0;
                rent_free+=1;
                //System.out.println("You have enough reward points to rent 1 item for free.");
            }
            return 1;
        }
    }
}
