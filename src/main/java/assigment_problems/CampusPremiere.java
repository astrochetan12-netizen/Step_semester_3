package assigment_problems;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CampusPremiere {
    public Booking bookSeats(Customer customer, Show show, List<Seat> seats) {
        if (seats.size() > 6) {
            System.out.println("Cannot book more than 6 seats per booking.");
            return null;
        }

        for (Seat seat : seats) {
            if (show.isSeatBooked(seat.getSeatNumber())) {
                System.out.println("Seat " + seat.getSeatNumber() + " is already booked for this show.");
                return null;
            }
        }

        show.bookSeats(seats);
        Booking booking = new Booking(customer, show, seats);
        System.out.println("Booking confirmed for " + customer.getName() + ": " + booking.getSeatListString() + ". Total: ₹" + String.format(Locale.US, "%.2f", booking.getTotal()) + ".");
        return booking;
    }

    public void cancelBooking(Booking booking) {
        if (booking != null) {
            booking.getShow().releaseSeats(booking.getSeats());
            System.out.println(booking.getCustomer().getName() + "'s booking cancelled. Seats " + booking.getSeatListString() + " released.");
        }
    }

    public static void main(String[] args) {
        CampusPremiere premiere = new CampusPremiere();
        Show show7PM = new Show("7 PM show");

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Booking ashaBooking = premiere.bookSeats(asha, show7PM, Arrays.asList(
            new RegularSeat("A1"),
            new RegularSeat("A2"),
            new PremiumSeat("F5")
        ));

        premiere.bookSeats(ravi, show7PM, Arrays.asList(new RegularSeat("A2")));

        premiere.bookSeats(ravi, show7PM, Arrays.asList(new ReclinerSeat("R1")));

        premiere.cancelBooking(ashaBooking);

        premiere.bookSeats(neha, show7PM, Arrays.asList(new RegularSeat("A2")));
    }
}
