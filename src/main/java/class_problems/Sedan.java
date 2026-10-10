package class_problems;

public class Sedan extends Vehicle {
    public Sedan(String model, double dailyRate) {
        super(model, dailyRate);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return getDailyRate() * days;
    }
}
