package assigment_problems;

public class CodingAssignment extends Assignment {
    public CodingAssignment(String title, int maxMarks, int dueDay) {
        super(title, maxMarks, dueDay);
    }

    @Override
    public int getPenaltyPercentagePerDay() {
        return 10;
    }
}
