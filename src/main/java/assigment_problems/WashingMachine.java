package assigment_problems;

import java.util.Locale;

public class WashingMachine {
    private String id;
    private boolean busy;
    private WashCycle currentCycle;

    public WashingMachine(String id) {
        this.id = id;
        this.busy = false;
    }

    public String getId() {
        return id;
    }

    public boolean isBusy() {
        return busy;
    }

    public WashCycle startWash(Student student, WashType washType) {
        if (busy) {
            System.out.println("Machine " + id + " is currently busy.");
            return null;
        }
        busy = true;
        currentCycle = new WashCycle(student, this, washType);
        System.out.println(washType.getName() + " wash started on " + id + " for " + student.getName() + " (" + washType.getDurationMinutes() + " min). Charge: ₹" + String.format(Locale.US, "%.2f", washType.getCharge()) + ".");
        return currentCycle;
    }

    public void completeWash() {
        if (busy) {
            busy = false;
            currentCycle = null;
            System.out.println(id + " cycle completed. " + id + " is now free.");
        }
    }
}
