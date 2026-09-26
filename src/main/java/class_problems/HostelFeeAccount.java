public class HostelFeeAccount extends FeeAccount {

    @Override
    public void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}
