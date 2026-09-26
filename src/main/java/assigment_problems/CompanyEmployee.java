public class CompanyEmployee {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new CompanyEmployee("Rohan", 50000);
        new CompanyEmployee("Sneha", 60000);
        new CompanyEmployee("Vikram", 70000);

        CompanyEmployee.printCompanyInfo();
    }
}
