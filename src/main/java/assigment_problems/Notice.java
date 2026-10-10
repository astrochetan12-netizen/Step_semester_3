package assigment_problems;

import java.util.List;

public class Notice {
    private String title;
    private List<String> targetDepartments;

    public Notice(String title, List<String> targetDepartments) {
        this.title = title;
        this.targetDepartments = targetDepartments;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTargetDepartments() {
        return targetDepartments;
    }
}
