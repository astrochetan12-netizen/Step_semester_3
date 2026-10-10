package class_problems;

public class DeluxeRoom extends Room {
    public DeluxeRoom(String roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    @Override
    public String getCategory() {
        return "Deluxe Room";
    }

    @Override
    public double calculatePrice(int nights) {
        return getPricePerNight() * nights;
    }
}
