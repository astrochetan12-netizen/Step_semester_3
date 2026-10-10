package class_problems;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public String getName() {
        return "Credit Card";
    }

    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
