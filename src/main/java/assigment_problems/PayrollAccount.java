public class PayrollAccount {

    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingSalary) {
        if (openingSalary < 0) {
            System.out.println("Warning: Salary cannot be negative. Setting to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = openingSalary;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Rejected: Bonus amount must be positive.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Rejected: Tax percent must be between 0 and 100.");
        } else {
            double taxAmount = basicSalary * (percent / 100.0);
            basicSalary -= taxAmount;
            System.out.printf("Tax deducted: %.0f%%%n", percent);
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}