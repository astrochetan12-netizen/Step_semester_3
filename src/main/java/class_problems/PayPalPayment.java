package class_problems;

public class PayPalPayment implements PaymentMethod {
    private boolean shouldSucceed;

    public PayPalPayment() {
        this.shouldSucceed = true;
    }

    public PayPalPayment(boolean shouldSucceed) {
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public String getName() {
        return "PayPal";
    }

    @Override
    public boolean processPayment(double amount) {
        return shouldSucceed;
    }
}
