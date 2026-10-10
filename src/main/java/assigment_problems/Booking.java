package assigment_problems;

import java.util.List;
import java.util.Locale;

public class Booking {
    private Customer customer;
    private Show show;
    private List<Seat> seats;
    private double total;

    public Booking(Customer customer, Show show, List<Seat> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = seats;
        double sum = 0;
        for (Seat s : seats) {
            sum += s.getPrice();
        }
        this.total = sum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public double getTotal() {
        return total;
    }

    public String getSeatListString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seats.size(); i++) {
            sb.append(seats.get(i).getSeatNumber());
            if (i < seats.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
