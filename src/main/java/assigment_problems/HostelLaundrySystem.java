package assigment_problems;

public class HostelLaundrySystem {
    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashType quick = new QuickWash();
        WashType normal = new NormalWash();
        WashType heavy = new HeavyWash();

        m1.startWash(asha, quick);
        m1.startWash(ravi, heavy);
        m2.startWash(ravi, heavy);
        m1.completeWash();
        m1.startWash(neha, normal);
    }
}
