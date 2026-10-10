package class_problems;

public class LeaveRequest {
    private Employee employee;
    private String dateRange;
    private String status;

    public LeaveRequest(Employee employee, String dateRange) {
        this.employee = employee;
        this.dateRange = dateRange;
        this.status = "Pending";
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getDateRange() {
        return dateRange;
    }

    public String getStatus() {
        return status;
    }

    public void approve() {
        if ("Pending".equals(status)) {
            this.status = "Approved";
        }
    }

    public void reject() {
        if ("Pending".equals(status)) {
            this.status = "Rejected";
        }
    }

    public boolean setStatus(String newStatus) {
        if ("Pending".equals(newStatus)) {
            if ("Approved".equals(status) || "Rejected".equals(status)) {
                System.out.println("Cannot change leave request status from " + status + " to Pending.");
                return false;
            }
        }
        this.status = newStatus;
        return true;
    }
}
