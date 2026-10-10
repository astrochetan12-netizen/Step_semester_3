package class_problems;

public class Reservation {
    private Customer customer;
    private Room room;
    private String month;
    private int startDay;
    private int endDay;
    private double price;
    private boolean active;

    public Reservation(Customer customer, Room room, String month, int startDay, int endDay) {
        this.customer = customer;
        this.room = room;
        this.month = month;
        this.startDay = startDay;
        this.endDay = endDay;
        this.price = room.calculatePrice(endDay - startDay);
        this.active = true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public String getMonth() {
        return month;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public double getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public void cancel() {
        this.active = false;
    }

    public boolean overlaps(String month, int startDay, int endDay) {
        if (!this.active) {
            return false;
        }
        if (!this.month.equalsIgnoreCase(month)) {
            return false;
        }
        return this.startDay < endDay && this.endDay > startDay;
    }

    public String getDateRange() {
        return month + " " + startDay + "-" + endDay;
    }
}
