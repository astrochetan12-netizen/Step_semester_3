package class_problems;

import java.util.ArrayList;
import java.util.List;

public class HotelBookingSystem {
    private List<Reservation> reservations;

    public HotelBookingSystem() {
        this.reservations = new ArrayList<>();
    }

    public boolean isAvailable(Room room, String month, int startDay, int endDay) {
        for (Reservation res : reservations) {
            if (res.getRoom().getRoomNumber().equals(room.getRoomNumber()) && res.overlaps(month, startDay, endDay)) {
                return false;
            }
        }
        return true;
    }

    public void checkAvailability(Room room, String month, int startDay, int endDay) {
        if (isAvailable(room, month, startDay, endDay)) {
            System.out.println(room.getCategory() + " " + room.getRoomNumber() + " is available from " + month + " " + startDay + " to " + month + " " + endDay + ".");
        } else {
            System.out.println(room.getCategory() + " " + room.getRoomNumber() + " is not available from " + month + " " + startDay + " to " + month + " " + endDay + ".");
        }
    }

    public Reservation makeReservation(Customer customer, Room room, String month, int startDay, int endDay) {
        if (!isAvailable(room, month, startDay, endDay)) {
            System.out.println(room.getCategory() + " " + room.getRoomNumber() + " is not available from " + month + " " + startDay + " to " + month + " " + endDay + ".");
            return null;
        }
        Reservation res = new Reservation(customer, room, month, startDay, endDay);
        reservations.add(res);
        System.out.println("Reservation confirmed for " + customer.getName() + ", " + room.getCategory() + " " + room.getRoomNumber() + " (" + res.getDateRange() + "). Price: $" + res.getPrice() + ".");
        return res;
    }

    public void cancelReservation(Reservation res) {
        if (res != null && res.isActive()) {
            res.cancel();
            System.out.println("Reservation for " + res.getCustomer().getName() + ", " + res.getRoom().getCategory() + " " + res.getRoom().getRoomNumber() + " (" + res.getDateRange() + ") cancelled successfully.");
        }
    }

    public static void main(String[] args) {
        HotelBookingSystem system = new HotelBookingSystem();

        Customer customerA = new Customer("Customer A");
        Customer customerB = new Customer("Customer B");
        Customer customerC = new Customer("Customer C");

        Room room101 = new StandardRoom("101", 100.0);
        Room room201 = new DeluxeRoom("201", 200.0);

        system.checkAvailability(room101, "Jan", 1, 5);
        Reservation resA = system.makeReservation(customerA, room101, "Jan", 1, 5);
        system.makeReservation(customerB, room101, "Jan", 3, 7);
        system.cancelReservation(resA);
        system.makeReservation(customerC, room201, "Feb", 10, 12);
    }
}
