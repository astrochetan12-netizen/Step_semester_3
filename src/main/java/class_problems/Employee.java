public class Employee {

    String empId;
    double salary;

    public Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void printSalary() {
        System.out.printf("%s | Final Salary: Rs %.1f%n", empId, salary);
    }

    public static void main(String[] args) {
        String[] empIds = {"E-101", "E-102", "E-103", "E-104"};
        double[] salaries = {40000, 55000, 62000, 48000};

        Employee[] employees = new Employee[empIds.length];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee(empIds[i], salaries[i]);
            employees[i].raiseSalary(5000);
            employees[i].printSalary();
        }
    }
}
