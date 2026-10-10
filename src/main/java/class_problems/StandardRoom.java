package class_problems;

public class StandardRoom extends Room {
    public StandardRoom(String roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    @Override
    public String getCategory() {
        return "Standard Room";
    }

    @Override
    public double calculatePrice(int nights) {
        return getPricePerNight() * nights;
    }
}
