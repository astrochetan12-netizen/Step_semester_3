package assigment_problems;

public abstract class MembershipPlan {
    private String name;
    private int months;

    public MembershipPlan(String name, int months) {
        this.name = name;
        this.months = months;
    }

    public String getName() {
        return name;
    }

    public int getMonths() {
        return months;
    }

    public abstract double calculateFee();
}
