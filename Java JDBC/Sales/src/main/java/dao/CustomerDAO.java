package dao;

import entities.Customer;
import exceptions.CustomerNotFound;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {

    // Fields

    private final Connection conn;

    // Contructors

    public CustomerDAO(Connection conn) {
        this.conn = conn;
    }

    // Methods

    public boolean isIdExist(int id) throws SQLException, CustomerNotFound {
        if (conn == null) return false;

        String query = "select 1 from customers where Customer_ID = ?"; // Trả về 1 nếu customer_id tồn tại

        // Đối tượng PS dc khởi tạo, nhận vào câu lệnh SQL để sẵn sàng truy vấn khi dc gọi
        try (PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                return rs.next();
            }
        }

    }

    public ArrayList<Customer> selectAll() throws SQLException {
        if (conn == null) return null;

        String select = "select * from customers";
        ArrayList<Customer> customers = new ArrayList<>();

        try (Statement s = conn.createStatement();
             ResultSet rs = s.executeQuery(select);) {

            while (rs.next()) {
                Customer customer = new Customer();

                customer.setId(rs.getInt("Customer_ID"));
                customer.setName(rs.getString("Customer_Name"));
                customer.setContact(rs.getString("Contact_Name"));
                customer.setAddress(rs.getString("Address"));
                customer.setCity(rs.getString("City"));
                customer.setPostCode(rs.getString("Post_Code"));
                customer.setCountry(rs.getString("Country"));

                customers.add(customer);
            }

        } catch (SQLException e) {
            throw new SQLException("Cannot display customers " + e.getMessage());
        }

        return customers;
    }

    public boolean insert(Customer customer) throws SQLException {
        if (conn == null) return false;

        String insert = "insert into customers(Customer_Name, Contact_Name, Address, City, Post_Code, Country) values (?, ?, ?, ?, ?, ?)";

        int index = 1;

        try (PreparedStatement ps = conn.prepareStatement(insert);) {
            ps.setString(index++, customer.getName());
            ps.setString(index++, customer.getContact());
            ps.setString(index++, customer.getAddress());
            ps.setString(index++, customer.getCity());
            ps.setString(index++, customer.getPostCode());
            ps.setString(index++, customer.getCountry());

            if (ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            throw new SQLException("Cannot insert customer " + e.getMessage());
        }

        return false;
    }

    public boolean update(int id, Customer customer) throws SQLException {
        if (conn == null) return false;

        String update = "update customers set Customer_Name = ?, Contact_Name = ?, Address = ?, City = ?, Post_Code = ?, Country = ? where Customer_ID = ?";

        int index = 1;

        try (PreparedStatement ps = conn.prepareStatement(update);) {
            ps.setString(index++, customer.getName());
            ps.setString(index++, customer.getContact());
            ps.setString(index++, customer.getAddress());
            ps.setString(index++, customer.getCity());
            ps.setString(index++, customer.getPostCode());
            ps.setString(index++, customer.getCountry());

            ps.setInt(index++, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new SQLException("Cannot update customer " + e.getMessage());
        }
    }

    public boolean delete(int id) throws SQLException {
        if (conn == null) return false;

        String delete = "delete from customers where Customer_ID = ?";

        int index = 1;

        try (PreparedStatement ps = conn.prepareStatement(delete);) {
            ps.setInt(index++, id);

            if (ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            throw new SQLException("Cannot delete customer " + e.getMessage());
        }

        return false;
    }
}
