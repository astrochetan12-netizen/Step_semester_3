public class CanteenPayment {

    public static double processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cp = (CardPayment) payment;
            cp.payWithProcessingFee(amount);
            return amount * 1.02;
        } else {
            payment.pay(amount);
            return amount;
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};
        double totalCollected = 0.0;

        for (int i = 0; i < payments.length; i++) {
            totalCollected += processTransaction(payments[i], amounts[i]);
        }

        System.out.printf("Total Collected: Rs %.1f%n", totalCollected);
    }
}
