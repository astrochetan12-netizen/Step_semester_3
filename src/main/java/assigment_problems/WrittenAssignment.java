package assigment_problems;

public class WrittenAssignment extends Assignment {
    public WrittenAssignment(String title, int maxMarks, int dueDay) {
        super(title, maxMarks, dueDay);
    }

    @Override
    public int getPenaltyPercentagePerDay() {
        return 20;
    }
}
