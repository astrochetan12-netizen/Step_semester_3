public class PaymentProcessor {

    static int hostelCount = 0;
    static int dayScholarCount = 0;

    public static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            account.pay(amount);
            hostelCount++;
        } else {
            account.pay(amount);
            dayScholarCount++;
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        double amount = 60000;
        for (FeeAccount acc : accounts) {
            processPayment(acc, amount);
        }

        System.out.printf("Hostel accounts processed: %d | Day-scholar accounts processed: %d%n",
                hostelCount, dayScholarCount);
    }
}