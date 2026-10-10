package class_problems;

public class MultipleChoiceQuestion extends Question {
    private String correctOption;

    public MultipleChoiceQuestion(int questionNumber, int points, String correctOption) {
        super(questionNumber, points);
        this.correctOption = correctOption;
    }

    @Override
    public boolean evaluate(String answer) {
        return correctOption.equalsIgnoreCase(answer);
    }
}
