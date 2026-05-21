import java.util.ArrayList;
import java.util.Scanner;

// Employee Class
class Employee {

    int empId;
    String name;
    double basicSalary;
    double hra;
    double da;
    double grossSalary;

    // Constructor
    Employee(int empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;

        calculateSalary();
    }

    // Salary Calculation
    void calculateSalary() {

        hra = basicSalary * 0.20; // 20% HRA
        da = basicSalary * 0.10;  // 10% DA

        grossSalary = basicSalary + hra + da;
    }

    // Display Employee Details
    void display() {

        System.out.println("\n===== EMPLOYEE DETAILS =====");
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Basic Salary  : " + basicSalary);
        System.out.println("HRA           : " + hra);
        System.out.println("DA            : " + da);
        System.out.println("Gross Salary  : " + grossSalary);
        System.out.println("------------------------------");
    }
}

// Main Class
public class EmployeePayrollSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Employee
    static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, salary);

        employees.add(emp);

        System.out.println("Employee Added Successfully!");
    }

    // View Employees
    static void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No Employee Records Found.");
            return;
        }

        for (Employee emp : employees) {
            emp.display();
        }
    }

    // Search Employee
    static void searchEmployee() {

        System.out.print("Enter Employee ID to Search: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {

            if (emp.empId == id) {
                System.out.println("Employee Found!");
                emp.display();
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    // Update Employee
    static void updateEmployee() {

        System.out.print("Enter Employee ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee emp : employees) {

            if (emp.empId == id) {

                System.out.print("Enter New Name: ");
                emp.name = sc.nextLine();

                System.out.print("Enter New Basic Salary: ");
                emp.basicSalary = sc.nextDouble();

                emp.calculateSalary();

                System.out.println("Employee Updated Successfully!");
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    // Delete Employee
    static void deleteEmployee() {

        System.out.print("Enter Employee ID to Delete: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {

            if (emp.empId == id) {

                employees.remove(emp);

                System.out.println("Employee Deleted Successfully!");
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    // Generate Payroll
    static void generatePayroll() {

        if (employees.isEmpty()) {
            System.out.println("No Employees Available.");
            return;
        }

        System.out.println("\n========= PAYROLL REPORT =========");

        for (Employee emp : employees) {

            System.out.println(
                "ID: " + emp.empId +
                " | Name: " + emp.name +
                " | Gross Salary: " + emp.grossSalary
            );
        }

        System.out.println("==================================");
    }

    // Main Method
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE PAYROLL SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Generate Payroll");
            System.out.println("7. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    generatePayroll();
                    break;

                case 7:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);
    }
}
