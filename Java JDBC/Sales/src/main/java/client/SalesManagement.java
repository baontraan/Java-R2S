package client;

import dao.CustomerDAO;
import dao.EmployeeDAO;
import entities.Customer;
import entities.Employee;
import exceptions.CustomerNotFound;
import exceptions.EmployeeNotFound;
import services.CustomerService;
import services.EmployeeService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesManagement {

    // Fields

    private CustomerDAO customerDAO;
    private EmployeeDAO employeeDAO;
    private CustomerForm customerForm;
    private EmployeeForm employeeForm;
    private static Scanner sc;
    private CustomerService customerService;
    private EmployeeService employeeService;

    // Constructors

    public SalesManagement() throws SQLException {
        sc = new Scanner(System.in);
        customerForm = new CustomerForm(sc);
        employeeForm = new EmployeeForm(sc);
        Connection conn = getConnection();
        customerDAO = new CustomerDAO(conn);
        employeeDAO = new EmployeeDAO(conn);
        customerService = new CustomerService(customerDAO);
        employeeService = new EmployeeService(employeeDAO);
    }

    // Methods

    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sales_demo";
            return DriverManager.getConnection(url, "root", "passw0rd");
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Cannot open connection " + e.getMessage());
        }
    }

    private static void createMenu() {
        System.out.println("\n======CUSTOMER MANAGEMENT======");
        System.out.println("\n1. Get all customers");
        System.out.println("2. Add new customer");
        System.out.println("3. Change customer information");
        System.out.println("4. Remove a customer");
        System.out.println("5. Get all employees");
        System.out.println("6. Add new employee");
        System.out.println("7. Change employee information");
        System.out.println("8. Remove a employee");
        System.out.println("9. Quit");
        System.out.print("Enter your choice: ");
    }

    // 1. Get All Customers

    private void displayAllCustomers() throws SQLException, CustomerNotFound {
        ArrayList<Customer> customers = customerDAO.selectAll();

        if (customers == null || customers.isEmpty()) {
            throw new CustomerNotFound("The list is empty. Cannot found any customers");
        }

        for (Customer c : customers) {
            System.out.println(c.toString());
        }
    }

    // 2. Add New Customer

    private void addNewCustomer() throws SQLException {
        Customer customer = customerForm.getCustomer();

        if (customerDAO.insert(customer)) {
            System.out.println("Add new customer Successfully!");
        } else {
            System.out.println("Add new customer Unsuccessfully!");
        }
    }

    // 3. Change Customer Information

    private void updateCustomer() throws SQLException {
        int id = customerForm.getCustomerId();

        try {
            customerService.checkCustomerExist(id);
            Customer customer = customerForm.getCustomer();
            customerService.handleUpdateCustomer(id, customer);
            System.out.println("Update customer Successfully");
        } catch (CustomerNotFound cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    // 4. Remove A Customer

    private void deleteCustomer() throws SQLException {
        int id = customerForm.getCustomerId();

        try {
            customerService.checkCustomerExist(id);
            customerService.handleDeleteCustomer(id);
            System.out.println("Delete customer Successfully!");
        } catch (CustomerNotFound cnf) {
            System.out.println(cnf.getMessage());
        }
    }

    // 5. Get ALl Employess

    private void displayAllEmployee() throws SQLException, EmployeeNotFound {
        ArrayList<Employee> employees = employeeDAO.selectAll();

        if (employees == null || employees.isEmpty()) {
            throw new EmployeeNotFound("The list is empty. Cannot found any Employees");
        }

        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    // 6. Add New Employee

    private void addNewEmployee() throws SQLException {
        Employee employee = employeeForm.getEmployee();

        if (employeeDAO.insert(employee)) {
            System.out.println("Add new employee Successfully!");
        } else {
            System.out.println("Add new employee Unsuccessfully!");
        }
    }

    // 7. Update Employee By ID

    private void updateEmployee() throws SQLException {
        int id = employeeForm.getEmployeeId();

        try {
            employeeService.checkEmployeeExist(id);
            Employee employee = employeeForm.getEmployee();
            employeeService.handleUpdateEmployee(id, employee);
            System.out.println("Updated Employee Successfully!");
        } catch (EmployeeNotFound enf) {
            System.out.println("Error: " + enf.getMessage());
        }
    }

    // 8. Delete Employee By ID

    private void deleteEmployee() throws SQLException {
        int id = employeeForm.getEmployeeId();

        try {
            employeeService.checkEmployeeExist(id);
            employeeService.handleDeleteEmployee(id);
            System.out.println("Deleted Employee Successfully!");
        } catch (EmployeeNotFound enf) {
            System.out.println("Error: " + enf.getMessage());
        }
    }

    public static void main(String[] args) {
        byte choice = 0;
        SalesManagement sm = null;

        try {
            sm = new SalesManagement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }

        do {
            try {
                createMenu();
                choice = Byte.parseByte(sc.nextLine());

                switch (choice) {
                    case 1:
                        sm.displayAllCustomers();
                        break;

                    case 2:
                        sm.addNewCustomer();
                        break;

                    case 3:
                        sm.updateCustomer();
                        break;

                    case 4:
                        sm.deleteCustomer();
                        break;

                    case 5:
                        sm.displayAllEmployee();
                        break;

                    case 6:
                        sm.addNewEmployee();
                        break;

                    case 7:
                        sm.updateEmployee();
                        break;

                    case 8:
                        sm.deleteEmployee();
                        break;

                    case 9:
                        break;

                    default:
                        System.out.println("\nInvalid choice");
                        break;
                }
            } catch (SQLException | CustomerNotFound | EmployeeNotFound e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 9);

        System.out.println("\n======END PROGRAM======");
    }
}
