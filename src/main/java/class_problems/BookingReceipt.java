import java.util.Arrays;

public class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = (seatNumbers != null) ? seatNumbers.clone() : new String[0];
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        if (index < 0 || index >= seatNumbers.length) {
            return this;
        }
        String[] updated = seatNumbers.clone();
        updated[index] = newSeat;
        return new BookingReceipt(this.bookingId, updated);
    }
}
