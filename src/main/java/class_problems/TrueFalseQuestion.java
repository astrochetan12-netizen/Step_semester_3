package class_problems;

public class TrueFalseQuestion extends Question {
    private String correctAnswer;

    public TrueFalseQuestion(int questionNumber, int points, String correctAnswer) {
        super(questionNumber, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}
