package entities;

public class Employee {

    // Fields

    private int id;
    private String lastName;
    private String firstName;
    private String birthdate;
    private int supervisor;

    // Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    // Methods
    
    @Override
    public String toString() {
        return String.format("Employee {Id: %-3d | Last Name: %-15s | First Name: %-15s | Birthdate: %s | Supervisor: %d}",
                getId(), getLastName(), getFirstName(), getBirthdate(), getSupervisor());
    }
}
