import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        byte choice = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n======STUDENT MANAGEMENT======");
            System.out.println("1. Add new student");
            System.out.println("2. Display all student");
            System.out.println("3. Find a student by id");
            System.out.println("4. Update student by id");
            System.out.println("5. Quit");
            System.out.print("Enter yor choice: ");
            choice = Byte.parseByte(sc.nextLine());

            switch (choice) {
                case 1:
                    try {
                        sm.addNewStudent();
                    } catch (StudentNotFound e) {
                        System.out.println(e.getMessage());

                    }

                    break;

                case 2:
                    System.out.println("\n");
                    try {
                        sm.displayAllStudent();
                    } catch (StudentNotFound snf) {
                        System.out.println(snf.getMessage());
                    }

                    break;

                case 3:
                    System.out.println("\n");

                    try {
                        sm.printStudentById();
                    } catch (StudentNotFound snf) {
                        System.out.println(snf.getMessage());
                    }
                    break;

                case 4:
                    try {
                        sm.updateStudentById();
                    } catch (StudentNotFound snf) {
                        System.out.println(snf.getMessage());
                    }
                    break;

                case 5:
                    break;

                default:
                    System.out.println("\nInvalid choice");
                    break;
            }
        } while (choice != 5);

        System.out.println("\n======END PROGRAM======");
    }
}
