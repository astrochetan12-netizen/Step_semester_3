package class_problems;

public class EmployeeLeaveSystem {
    public LeaveRequest submitLeaveRequest(Employee employee, String dateRange) {
        LeaveRequest request = new LeaveRequest(employee, dateRange);
        System.out.println("Leave request submitted for " + employee.getName() + " (" + dateRange + "). Status: " + request.getStatus() + ".");
        return request;
    }

    public void approveRequest(LeaveRequest request) {
        request.approve();
        System.out.println(request.getEmployee().getName() + "'s leave request (" + request.getDateRange() + ") approved. Status: " + request.getStatus() + ".");
    }

    public void rejectRequest(LeaveRequest request) {
        request.reject();
        System.out.println(request.getEmployee().getName() + "'s leave request (" + request.getDateRange() + ") rejected. Status: " + request.getStatus() + ".");
    }

    public static void main(String[] args) {
        EmployeeLeaveSystem system = new EmployeeLeaveSystem();

        Employee john = new FullTimeEmployee("John");
        LeaveRequest johnRequest = system.submitLeaveRequest(john, "Jan 1-5");
        system.approveRequest(johnRequest);

        Employee jane = new PartTimeEmployee("Jane");
        LeaveRequest janeRequest = system.submitLeaveRequest(jane, "Feb 10-11");
        system.rejectRequest(janeRequest);

        johnRequest.setStatus("Pending");
    }
}
