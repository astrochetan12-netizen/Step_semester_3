package class_problems;

public class SUV extends Vehicle {
    public SUV(String model, double dailyRate) {
        super(model, dailyRate);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return getDailyRate() * days;
    }
}
