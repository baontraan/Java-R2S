package dao;

import entities.Employee;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {

    // Fields

    private final Connection conn;

    // Constructors

    public EmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    // methods

    public boolean isIdExist(int id) throws SQLException {
        if (conn == null) return false;

        String querry = "select 1 from Employees where Employee_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(querry);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                return rs.next();
            }
        }
    }

    public ArrayList<Employee> selectAll() throws SQLException {
        if (conn == null) return null;

        String select = "select * from employees";
        ArrayList<Employee> employees = new ArrayList<>();

        try (Statement s = conn.createStatement();
             ResultSet rs = s.executeQuery(select)) {

            while (rs.next()) {
                Employee employee = new Employee();

                employee.setId(rs.getInt("Employee_ID"));
                employee.setLastName(rs.getNString("Last_Name"));
                employee.setFirstName(rs.getString("First_Name"));
                employee.setBirthdate(rs.getString("Birth_Date"));
                employee.setSupervisor(rs.getInt("Supervisor_ID"));

                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new SQLException("Cannot display all employees " + e.getMessage());
        }

        return employees;
    }

    public boolean insert(Employee employee) throws SQLException {
        if (conn == null) return false;

        String insert = "{call sp_add_employee(?, ?, ?, ?)}";

        int index = 1;

        try (CallableStatement cs = conn.prepareCall(insert);) {

            cs.setString(index++, employee.getLastName());
            cs.setString(index++, employee.getFirstName());
            cs.setString(index++, employee.getBirthdate());

            if (employee.getSupervisor() == null) {
                cs.setNull(index++, java.sql.Types.INTEGER);
            } else {
                cs.setInt(index++, employee.getSupervisor());
            }
            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new SQLException("Cannot insert Employee " + e.getMessage());
        }
    }

    public boolean update(int id, Employee employee) throws SQLException {
        if (conn == null) return false;

        String update = "{call sp_update_employee_by_id(?, ?, ?, ?, ?)}";

        int index = 1;

        try (CallableStatement cs = conn.prepareCall(update);) {

            cs.setInt(index++, id);
            cs.setString(index++, employee.getLastName());
            cs.setString(index++, employee.getFirstName());
            cs.setString(index++, employee.getBirthdate());

            if (employee.getSupervisor() == null) {
                cs.setNull(index++, java.sql.Types.INTEGER);
            } else {
                cs.setInt(index++, employee.getSupervisor());
            }

            return cs.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new SQLException("Cannot update Employee " + e.getMessage());
        }
    }

    public boolean delete(int id) throws SQLException {
        if (conn == null) return false;

        String delete = "{call sp_delete_employee_by_id(?)}";

        int index = 1;

        try (CallableStatement cs = conn.prepareCall(delete);) {
            cs.setInt(index++, id);

            return cs.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new SQLException("Cannot delete Employee " + e.getMessage());
        }
    }
}
