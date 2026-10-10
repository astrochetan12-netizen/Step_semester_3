package assigment_problems;

import java.util.Arrays;
import java.util.Collections;

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBoard noticeBoard = new NoticeBoard();

        Student asha = new Student("Asha", "CSE");
        asha.addPreferredChannel(new EmailChannel());
        asha.addPreferredChannel(new AppChannel());

        Student ravi = new Student("Ravi", "ECE");
        ravi.addPreferredChannel(new SmsChannel());

        noticeBoard.registerStudent(asha);
        noticeBoard.registerStudent(ravi);

        noticeBoard.postNotice("Lab Closed Tomorrow", Collections.singletonList("CSE"));
        noticeBoard.postNotice("Fee Deadline Extended", Arrays.asList("CSE", "ECE"));
        noticeBoard.postNotice("Sports Day", Collections.emptyList());
    }
}
