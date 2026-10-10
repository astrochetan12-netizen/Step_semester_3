package assigment_problems;

public class EmailChannel implements NotificationChannel {
    @Override
    public String getName() {
        return "Email";
    }

    @Override
    public void send(Student student, Notice notice) {
        System.out.println("[Email \u2192 " + student.getName() + "] " + notice.getTitle() + ".");
    }
}
