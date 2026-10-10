package class_problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attempt {
    private Student student;
    private Examination examination;
    private Map<Integer, String> answers;
    private boolean submitted;

    public Attempt(Student student, Examination examination) {
        this.student = student;
        this.examination = examination;
        this.answers = new HashMap<>();
        this.submitted = false;
        System.out.println(examination.getName() + " started by " + student.getName() + ".");
    }

    public boolean recordAnswer(int questionNumber, String answer) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return false;
        }
        answers.put(questionNumber, answer);
        System.out.println("Answer recorded for Question " + questionNumber + ".");
        return true;
    }

    public void submit() {
        if (submitted) {
            return;
        }
        this.submitted = true;
        int totalScore = 0;
        int maxScore = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(examination.getName()).append(" submitted by ").append(student.getName()).append(". Result: ");

        List<Question> questions = examination.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            maxScore += q.getPoints();
            String ans = answers.get(q.getQuestionNumber());
            boolean correct = ans != null && q.evaluate(ans);
            int earned = correct ? q.getPoints() : 0;
            totalScore += earned;

            sb.append("Question ").append(q.getQuestionNumber()).append(": ");
            sb.append(correct ? "Correct (" + earned + " points)" : "Incorrect (0 points)");
            if (i < questions.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(". Total score: ").append(totalScore).append("/").append(maxScore).append(".");
        System.out.println(sb.toString());
    }

    public boolean isSubmitted() {
        return submitted;
    }
}
