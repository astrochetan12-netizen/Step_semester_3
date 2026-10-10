package class_problems;

public class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private int days;
    private double totalCharge;

    public Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        this.totalCharge = vehicle.calculateRentalCharge(days);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDays() {
        return days;
    }

    public double getTotalCharge() {
        return totalCharge;
    }
}
