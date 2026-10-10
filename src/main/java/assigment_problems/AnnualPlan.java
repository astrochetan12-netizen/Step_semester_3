package assigment_problems;

public class AnnualPlan extends MembershipPlan {
    public AnnualPlan() {
        super("Annual", 12);
    }

    @Override
    public double calculateFee() {
        return 9000.0;
    }
}
