package class_problems;

public abstract class Vehicle {
    private String model;
    private double dailyRate;
    private boolean available;

    public Vehicle(String model, double dailyRate) {
        this.model = model;
        this.dailyRate = dailyRate;
        this.available = true;
    }

    public String getModel() {
        return model;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateRentalCharge(int days);
}
