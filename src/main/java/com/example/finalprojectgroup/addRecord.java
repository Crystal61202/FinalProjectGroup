public void addRecord(Rental rental) {
    rentals.add(rental);
    if (this instanceof VIPAccount) {
        ((VIPAccount) this).addRewardPoints(10);
    }
}

public Rental getRecord(int index) {
    return rentals.get(index);
}
