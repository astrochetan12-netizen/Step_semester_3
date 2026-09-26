public class AlarmClock implements Ringable {

    private String time;

    public AlarmClock(String time) {
        this.time = time;
    }

    @Override
    public String ring() {
        return "Alarm ringing for " + time;
    }

    public static void main(String[] args) {
        AlarmClock a = new AlarmClock("7:00 AM");
        Doorbell d = new Doorbell("Front Door");

        System.out.println(a.ring());
        System.out.println(d.ring());

        Ringable.ringAll(new Ringable[]{a, d});
    }
}