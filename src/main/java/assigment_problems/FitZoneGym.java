package assigment_problems;

public class FitZoneGym {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership ashaMembership = new Membership(asha, new QuarterlyPlan());
        Membership raviMembership = new Membership(ravi, new MonthlyPlan());

        ashaMembership.checkIn();
        ashaMembership.freeze();
        ashaMembership.checkIn();

        raviMembership.expire();
        raviMembership.freeze();
    }
}
