package class_problems;

public abstract class Question {
    private int questionNumber;
    private int points;

    public Question(int questionNumber, int points) {
        this.questionNumber = questionNumber;
        this.points = points;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getPoints() {
        return points;
    }

    public abstract boolean evaluate(String answer);
}
