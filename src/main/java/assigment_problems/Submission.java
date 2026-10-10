package assigment_problems;

public class Submission {
    private Student student;
    private Assignment assignment;
    private int submissionDay;
    private String status;
    private int finalMarks;

    public Submission(Student student, Assignment assignment, int submissionDay) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDay = submissionDay;
        this.status = "Submitted";
        int lateDays = Math.max(0, submissionDay - assignment.getDueDay());
        String timing = lateDays == 0 ? "on time" : lateDays + " days late";
        System.out.println(student.getName() + "'s submission for '" + assignment.getTitle() + "' received (" + timing + "). Status: " + status + ".");
    }

    public Student getStudent() {
        return student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public String getStatus() {
        return status;
    }

    public void grade(int rawMarks) {
        int lateDays = Math.max(0, submissionDay - assignment.getDueDay());
        this.status = "Graded";
        if (lateDays > 0) {
            int penaltyPercent = lateDays * assignment.getPenaltyPercentagePerDay();
            double factor = (100 - penaltyPercent) / 100.0;
            this.finalMarks = (int) Math.round(rawMarks * factor);
            System.out.println(student.getName() + " graded: " + finalMarks + "/" + assignment.getMaxMarks() + " after " + penaltyPercent + "% late penalty. Status: " + status + ".");
        } else {
            this.finalMarks = rawMarks;
            System.out.println(student.getName() + " graded: " + finalMarks + "/" + assignment.getMaxMarks() + ". Status: " + status + ".");
        }
    }
}
