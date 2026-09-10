package entities;

public class Customer {

    // Fields

    private int id;
    private String name;
    private String contact;
    private String address;
    private String city;
    private String postCode;
    private String country;

    // Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Methods
    
    @Override
    public String toString() {
        return String.format("Customer { Id: %-4d | Name: %-20s | Contact Name: %-15s | Address: %-25s | City: %-15s | Post Code: %-8s | Country: %-10s }",
                getId(), getName(), getContact(), getAddress(), getCity(), getPostCode(), getCountry());
    }
}
