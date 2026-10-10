package class_problems;

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Examination examA = new Examination("Exam A");
        examA.addQuestion(new MultipleChoiceQuestion(1, 5, "C"));
        examA.addQuestion(new TrueFalseQuestion(2, 5, "False"));

        Student student1 = new Student("Student 1");
        Attempt attempt = new Attempt(student1, examA);

        attempt.recordAnswer(1, "C");
        attempt.recordAnswer(2, "True");
        attempt.submit();
        attempt.recordAnswer(1, "A");
    }
}
