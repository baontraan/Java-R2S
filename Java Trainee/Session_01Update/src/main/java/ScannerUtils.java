import java.util.Scanner;

public class ScannerUtils {

    // Methods

    public static String readNonEmpty(Scanner sc, String prompt) throws StudentNotFound {
        System.out.print(prompt);
        String value = sc.nextLine().trim();

        if (!value.isEmpty()) return value;

        throw new StudentNotFound("Value cannot be empty");
    }

    public static int readAge(Scanner sc, String prompt) throws StudentNotFound {
        System.out.print(prompt);
        int age = Integer.parseInt(sc.nextLine());

        if (age < 18) throw new StudentNotFound("Age must be >= 18");

        return age;
    }

    public static String readGender(Scanner sc, String prompt) throws StudentNotFound {
        System.out.print(prompt);
        String gender = sc.nextLine().trim().toLowerCase();

        if (!gender.equals("male") && !gender.equals("female"))
            throw new StudentNotFound("Gender must be 'male' or 'female'");

        return gender;
    }
}
