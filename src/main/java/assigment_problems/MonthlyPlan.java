package assigment_problems;

public class MonthlyPlan extends MembershipPlan {
    public MonthlyPlan() {
        super("Monthly", 1);
    }

    @Override
    public double calculateFee() {
        return 1000.0;
    }
}
