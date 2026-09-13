package client;

import entities.Employee;
import exceptions.InvalidFields;
import utils.ScannerUtils;

import java.util.Scanner;

public class EmployeeForm {

    // Fields

    private final Scanner sc;

    // Constructors

    public EmployeeForm(Scanner sc) {
        this.sc = sc;
    }

    // Methods

    public int getEmployeeId() {
        while (true) {
            try {
                return ScannerUtils.readId(sc, "Enter employee id: ");
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }
    }

    public Employee getEmployee() {
        int supervisor;
        String lastName, firstName, birthDate;

        Employee employee = new Employee();

        while (true) {
            try {
                lastName = ScannerUtils.readNonEmpty(sc, "Enter employee last name: ");
                employee.setLastName(lastName);
                break;
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }

        while (true) {
            try {
                firstName = ScannerUtils.readNonEmpty(sc, "Enter employee first name: ");
                employee.setFirstName(firstName);
                break;
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }

        while (true) {
            try {
                birthDate = ScannerUtils.readNonEmpty(sc, "Enter employee birthdate (yyyy/mm/dd): ");
                employee.setBirthdate(birthDate);
                break;
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }

        while (true) {
            try {
                supervisor = ScannerUtils.readId(sc, "Enter supervisor id (id/ null): ");
                employee.setSupervisor(supervisor);
                break;
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }

        return employee;
    }
}
