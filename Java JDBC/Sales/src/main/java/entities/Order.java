package entities;

public class Order {

    // Fields

    private int id;
    private int customerId;
    private int employeeId;
    private String orderDate;

    // Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    // Methods

    @Override
    public String toString() {
        return String.format("Order {Id: %-3d | Customer Id: %-3d | Employee Id: %-3d | Order Date: %-15s}",
                getId(), getCustomerId(), getEmployeeId(), getOrderDate());
    }
}
