import java.util.Scanner;

public class TraineeForm {

    // Fields

    private final Scanner scanner;

    // Constructors

    public TraineeForm(Scanner scanner) {
        this.scanner = scanner;
    }

    // Methods

    public String getId() {
        while (true) {
            System.out.print("Enter trainee ID: ");
            String id = scanner.nextLine();

            if (!id.isEmpty()) return id;

            System.out.println("ID cannot be empty. Try again");
        }
    }

    private String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine();

            if (!value.isEmpty()) return value;

            System.out.println("Value cannot be empty");
        }
    }

    private String readGender(String prompt) {
        String gender;

        while (true) {
            System.out.print(prompt);
            gender = scanner.nextLine().trim().toLowerCase();

            if (gender.isEmpty()) {
                System.out.println("Gender cannot be empty");
                break;
            }

            if (gender.equals("male") || gender.equals("female")) break;

            System.out.println("Gender must be 'male' or 'female'");

        }

        return gender;
    }

    private byte readAge(String prompt) {
        byte age;

        while (true) {

            try {
                System.out.print(prompt);
                age = Byte.parseByte(scanner.nextLine().trim());

                if (age >= 6) return age;

                System.out.println("Age must be >= 6");

            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again");
            }

        }
    }

    public Trainee getTrainee() {
        String name = readNonEmpty("Enter name: ");
        String gender = readGender("Enter gender (male/female): ");
        byte age = readAge("Enter age (>=6): ");

        return new Trainee("TEMP", name, gender, age);
    }
}
