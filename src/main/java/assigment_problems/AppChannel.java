package assigment_problems;

public class AppChannel implements NotificationChannel {
    @Override
    public String getName() {
        return "App";
    }

    @Override
    public void send(Student student, Notice notice) {
        System.out.println("[App \u2192 " + student.getName() + "] " + notice.getTitle() + ".");
    }
}
