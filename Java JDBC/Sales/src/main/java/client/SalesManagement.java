package client;

import dao.CustomerDAO;
import entities.Customer;
import exceptions.CustomerNotFound;
import services.CustomerService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesManagement {

    // Fields

    private CustomerDAO customerDAO;
    private CustomerForm customerForm;
    private static Scanner sc;
    private CustomerService customerService;

    // Constructors

    public SalesManagement() throws SQLException {
        sc = new Scanner(System.in);
        customerForm = new CustomerForm(sc);
        Connection conn = getConnection();
        customerDAO = new CustomerDAO(conn);
        customerService = new CustomerService(customerDAO);
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
        System.out.println("5. Quit");
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
                        break;

                    default:
                        System.out.println("\nInvalid choice");
                        break;
                }
            } catch (SQLException | CustomerNotFound e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 5);

        System.out.println("\n======END PROGRAM======");
    }
}
