package assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class NoticeBoard {
    private List<Student> students;

    public NoticeBoard() {
        this.students = new ArrayList<>();
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void postNotice(String title, List<String> targetDepartments) {
        if (targetDepartments == null || targetDepartments.isEmpty()) {
            System.out.println("Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println("Notice '" + title + "' posted to " + String.join(", ", targetDepartments) + ".");
        Notice notice = new Notice(title, targetDepartments);

        for (Student student : students) {
            if (targetDepartments.contains(student.getDepartment())) {
                for (NotificationChannel channel : student.getPreferredChannels()) {
                    channel.send(student, notice);
                }
            }
        }
    }
}
