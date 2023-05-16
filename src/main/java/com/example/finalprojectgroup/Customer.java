import java.util.ArrayList;

public abstract class Customer {
    private String ID;
    private String name;
    private String address;
    private String phone;
    private ArrayList<Rental> rentals;
    private String username;
    private String password;

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

class GuestAccount extends Customer {
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

class RegularAccount extends Customer {
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

class VIPAccount extends Customer {
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
