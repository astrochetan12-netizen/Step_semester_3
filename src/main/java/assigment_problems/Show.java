package assigment_problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Show {
    private String name;
    private Set<String> bookedSeats;

    public Show(String name) {
        this.name = name;
        this.bookedSeats = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public boolean isSeatBooked(String seatNumber) {
        return bookedSeats.contains(seatNumber);
    }

    public void bookSeats(List<Seat> seats) {
        for (Seat s : seats) {
            bookedSeats.add(s.getSeatNumber());
        }
    }

    public void releaseSeats(List<Seat> seats) {
        for (Seat s : seats) {
            bookedSeats.remove(s.getSeatNumber());
        }
    }
}
