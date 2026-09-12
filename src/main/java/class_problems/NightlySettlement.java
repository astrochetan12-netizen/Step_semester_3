import java.util.Arrays;

public class NightlySettlement {

    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        if (receipts != null) {
            for (BookingReceipt r : receipts) {
                if (r == null) {
                    nullSkipped++;
                } else {
                    processed++;
                    if (r instanceof GroupBookingReceipt) {
                        group++;
                    } else {
                        individual++;
                    }
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual";
    }

    public static void main(String[] args) {
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println("Defensive copy test: " + b.getSeatNumbers()[0]);

        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println("Original: " + Arrays.toString(b.getSeatNumbers()));
        System.out.println("Updated:  " + Arrays.toString(updated.getSeatNumbers()));

        BookingReceipt[] batch = {
            new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println(processNightlySettlement(batch));
    }
}