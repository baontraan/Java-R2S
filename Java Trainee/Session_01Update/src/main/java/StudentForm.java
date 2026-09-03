import java.util.Scanner;

public class StudentForm {

    // Fields

    private final Scanner sc;

    // Constuctors

    public StudentForm(Scanner sc) {
        this.sc = sc;
    }

    // Methods

    public String getStudentId() {
        while (true) {
            try {
                return ScannerUtils.readNonEmpty(sc, "Enter student id: ");
            } catch (StudentNotFound snf) {
                System.out.println("Error: " + snf.getMessage());
            }
        }
    }

    public Student input() throws StudentNotFound {
        String name, gender;
        int age;

        while (true) {

            try {
                name = ScannerUtils.readNonEmpty(sc, "Enter name: ");
                break;
            } catch (StudentNotFound snf) {
                System.out.println("Error: " + snf.getMessage());
            }
        }

        while (true) {

            try {
                gender = ScannerUtils.readGender(sc, "Enter gender (male/female): ");
                break;
            } catch (StudentNotFound snf) {
                System.out.println("Error: " + snf.getMessage());
            }
        }

        while (true) {

            try {
                age = ScannerUtils.readAge(sc, "Enter age (age >= 18): ");
                break;
            } catch (StudentNotFound snf) {
                System.out.println("Error: " + snf.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number " + e.getMessage());
            }
        }

        return new Student("TEMP", name, gender, age);
    }
}
