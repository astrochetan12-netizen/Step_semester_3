package assigment_problems;

import java.util.Locale;

public class Membership {
    private Member member;
    private MembershipPlan plan;
    private double fee;
    private String status;

    public Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        this.fee = plan.calculateFee();
        this.status = "Active";
        System.out.println(plan.getName() + " membership created for " + member.getName() + ". Fee: ₹" + String.format(Locale.US, "%,.2f", fee) + ". Status: " + status + ".");
    }

    public Member getMember() {
        return member;
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    public double getFee() {
        return fee;
    }

    public String getStatus() {
        return status;
    }

    public void checkIn() {
        if ("Active".equals(status)) {
            System.out.println(member.getName() + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " + member.getName() + "'s membership is " + status + ".");
        }
    }

    public void freeze() {
        if ("Expired".equals(status)) {
            System.out.println("Cannot freeze an Expired membership.");
            return;
        }
        this.status = "Frozen";
        System.out.println(member.getName() + "'s membership frozen. Status: " + status + ".");
    }

    public void unfreeze() {
        if ("Expired".equals(status)) {
            System.out.println("Cannot unfreeze an Expired membership.");
            return;
        }
        this.status = "Active";
        System.out.println(member.getName() + "'s membership unfrozen. Status: " + status + ".");
    }

    public void expire() {
        this.status = "Expired";
        System.out.println(member.getName() + "'s membership expired. Status: " + status + ".");
    }
}
