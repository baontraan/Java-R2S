package client;

import entities.Customer;
import exceptions.InvalidFields;
import utils.ScannerUtils;

import java.util.Scanner;

public class CustomerForm {

    // Fields

    private final Scanner sc;

    // Constructor

    public CustomerForm(Scanner sc) {
        this.sc = sc;
    }

    // Methods

    public int getCustomerId() {
        while (true) {
            try {
                return ScannerUtils.readId(sc, "Enter customer ID: ");
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }
    }

    public Customer getCustomer() {
        String name, contact, address, city, postCode, country;

        Customer customer = new Customer();

        while (true) {
            try {
                name = ScannerUtils.readNonEmpty(sc, "Enter name: ");
                customer.setName(name);
                break;
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }

        while (true) {
            try {
                contact = ScannerUtils.readNonEmpty(sc, "Enter contact name: ");
                customer.setContact(contact);
                break;
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }

        while (true) {
            try {
                address = ScannerUtils.readNonEmpty(sc, "Enter address: ");
                customer.setAddress(address);
                break;
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }

        while (true) {
            try {
                city = ScannerUtils.readNonEmpty(sc, "Enter city: ");
                customer.setCity(city);
                break;
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }

        while (true) {
            try {
                postCode = ScannerUtils.readNonEmpty(sc, "Enter post code: ");
                customer.setPostCode(postCode);
                break;
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }

        while (true) {
            try {
                country = ScannerUtils.readNonEmpty(sc, "Enter country: ");
                customer.setCountry(country);
                break;
            } catch (InvalidFields ivf) {
                System.out.println("Error: " + ivf.getMessage());
            }
        }

        return customer;
    }
}
