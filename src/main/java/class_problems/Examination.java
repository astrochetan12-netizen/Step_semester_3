package class_problems;

import java.util.ArrayList;
import java.util.List;

public class Examination {
    private String name;
    private List<Question> questions;

    public Examination(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public String getName() {
        return name;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
