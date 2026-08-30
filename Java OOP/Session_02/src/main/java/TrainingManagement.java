import java.util.Arrays;
import java.util.Scanner;

public class TrainingManagement {

    // Fields

    private final TraineeForm traineeForm;
    private final Scanner scanner;
    private final Trainee[] listOfTrainees = new Trainee[100];
    private byte count = 0;

    // Contructors

    public TrainingManagement() {
        this.scanner = new Scanner(System.in);
        this.traineeForm = new TraineeForm(scanner);
    }

    // Methods

    private void menu() {
        while (true) {
            System.out.println("\n====Trainee Management====");
            System.out.println("1. Add trainee");
            System.out.println("2. Display all trainees");
            System.out.println("3. Find trainee by ID");
            System.out.println("4. Find trainee by name");
            System.out.println("5. Update trainee by ID");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": {
                    addTrainee();
                    break;
                }

                case "2": {
                    displayAllTrainee();
                    break;
                }

                case "3": {
                    System.out.print("Enter id to find: ");
                    String id = scanner.nextLine();

                    Trainee trainee = findTraineeById(id);
                    System.out.println(trainee != null ? header() + "\n" + trainee : "Not found");

                }

                case "4": {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine().trim();

                    Trainee[] result = findTraineeByName(name);

                    if (result.length == 0) {
                        System.out.println("No match");
                    } else {
                        System.out.println(header());
                        for (Trainee t : result) System.out.println(t);
                    }
                    break;
                }

                case "5": {
                    System.out.print("Enter id to update: ");
                    String id = scanner.nextLine().trim();


                    updateTraineeById(id, traineeForm);
                    break;
                }

                case "0": {
                    System.out.println("End Program");
                    return;
                }

                default: {
                    System.out.println("Invalid choice");
                    break;
                }
            }
        }
    }

    //

    private int indexOfId(String id) {
        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getId().equalsIgnoreCase(id)) return i;
        }

        return -1;
    }

    // Add Trainee

    public void addTrainee() {

        if (count >= listOfTrainees.length) {
            System.out.println("Storage full!");
            return;
        }

        String id;

        while (true) {

            id = traineeForm.getId();

            if (indexOfId(id) == -1) break;

            System.out.println("ID is already exits. Enter another");

        }

        Trainee trainee = traineeForm.getTrainee();
        trainee.setId(id);
        listOfTrainees[count] = trainee;
        count++;

        System.out.println("Create Successfully");
    }

    private String header() {
        return String.format("%-8s | %-18s | %-6s | %3s", "ID", "NAME", "SEX", "AGE");
    }

    // Display all trainee

    public void displayAllTrainee() {

        if (count == 0) {
            System.out.println("No trainees yet");
            return;
        }

        System.out.println(header());

        for (int i = 0; i < count; i++) {
            System.out.println(listOfTrainees[i]);
        }
    }

    // Find trainee by id

    public Trainee findTraineeById(String id) {
        int index = indexOfId(id);
        return index == -1 ? null : listOfTrainees[index];
    }

    // Find trainee by name

    public Trainee[] findTraineeByName(String name) {
        String search = name.toLowerCase().trim();

        Trainee[] temp = new Trainee[count];

        int k = 0;

        for (int i = 0; i < count; i++) {
            if (listOfTrainees[i].getName().toLowerCase().contains(search)) {
                temp[k++] = listOfTrainees[i];
            }
        }

        return Arrays.copyOf(temp, k);
    }

    // Update trainee by id

    public void updateTraineeById(String id, TraineeForm traineeForm) {
        int index = indexOfId(id);

        if (index == -1) {
            System.out.println("ID not found");
            return;
        }

        Trainee newTrainee = traineeForm.getTrainee();

        listOfTrainees[index].setName(newTrainee.getName());
        listOfTrainees[index].setGender(newTrainee.getGender());
        listOfTrainees[index].setAge(newTrainee.getAge());

        System.out.println("Updated");
    }

    public static void main(String[] args) {

        TrainingManagement trainingManagement = new TrainingManagement();

        trainingManagement.menu();
    }

}
