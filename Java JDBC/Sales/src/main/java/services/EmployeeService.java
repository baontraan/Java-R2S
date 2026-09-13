package services;

import dao.EmployeeDAO;
import entities.Employee;
import exceptions.EmployeeNotFound;

import java.sql.SQLException;

public class EmployeeService {

    // Fields

    private EmployeeDAO employeeDAO;

    // Constructors

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // Methods

    public void checkEmployeeExist(int id) throws EmployeeNotFound, SQLException {
        if (!employeeDAO.isIdExist(id)) {
            throw new EmployeeNotFound(String.format("Employee with ID %d does not exist", id));
        }
    }

    public void handleUpdateEmployee(int id, Employee employee) throws SQLException {
        boolean isSuccess = employeeDAO.update(id, employee);

        if (!isSuccess) throw new SQLException("Cannot update Employee");
    }

    public void handleDeleteEmployee(int id) throws SQLException {
        boolean isSuccess = employeeDAO.delete(id);

        if (!isSuccess) throw new SQLException("Cannot delete Employee");
    }
}
