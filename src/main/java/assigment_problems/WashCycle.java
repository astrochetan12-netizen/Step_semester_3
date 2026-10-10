package assigment_problems;

public class WashCycle {
    private Student student;
    private WashingMachine machine;
    private WashType washType;

    public WashCycle(Student student, WashingMachine machine, WashType washType) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }

    public Student getStudent() {
        return student;
    }

    public WashingMachine getMachine() {
        return machine;
    }

    public WashType getWashType() {
        return washType;
    }
}
