package assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class AssignmentPortal {
    private Map<String, Submission> submissions = new HashMap<>();

    public Submission submitWork(Student student, Assignment assignment, int day) {
        String key = student.getName() + ":" + assignment.getTitle();
        if (submissions.containsKey(key)) {
            Submission existing = submissions.get(key);
            if ("Graded".equals(existing.getStatus())) {
                System.out.println("Cannot resubmit: '" + assignment.getTitle() + "' has already been graded.");
                return null;
            }
        }
        Submission sub = new Submission(student, assignment, day);
        submissions.put(key, sub);
        return sub;
    }

    public static void main(String[] args) {
        AssignmentPortal portal = new AssignmentPortal();

        Assignment linkedListLab = new CodingAssignment("Linked List Lab", 50, 10);
        Assignment designEssay = new WrittenAssignment("Design Essay", 50, 12);

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Submission ashaSub = portal.submitWork(asha, linkedListLab, 10);
        Submission raviSub = portal.submitWork(ravi, designEssay, 14);

        ashaSub.grade(45);
        raviSub.grade(40);

        portal.submitWork(asha, linkedListLab, 11);
    }
}
