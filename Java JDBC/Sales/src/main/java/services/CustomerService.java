package services;

import dao.CustomerDAO;
import entities.Customer;
import exceptions.CustomerNotFound;

import java.sql.SQLException;

public class CustomerService {

    // Fields

    private CustomerDAO customerDAO;

    // Constructors

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    // Methods

    public void checkCustomerExist(int id) throws CustomerNotFound, SQLException {
        if (!customerDAO.isIdExist(id)) {
            throw new CustomerNotFound(String.format("Customer with ID %d does not exist", id));
        }
    }

    public void handleUpdateCustomer(int id, Customer customer) throws SQLException {

        boolean isSuccess = customerDAO.update(id, customer);

        if (!isSuccess) throw new SQLException("Cannot update customer");
    }

    public void handleDeleteCustomer(int id) throws SQLException {

        boolean isSuccess = customerDAO.delete(id);

        if (!isSuccess) throw new SQLException("Cannot delete customer");
    }

}
