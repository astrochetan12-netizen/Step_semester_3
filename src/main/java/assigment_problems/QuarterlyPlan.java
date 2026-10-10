package assigment_problems;

public class QuarterlyPlan extends MembershipPlan {
    public QuarterlyPlan() {
        super("Quarterly", 3);
    }

    @Override
    public double calculateFee() {
        return 2700.0;
    }
}
