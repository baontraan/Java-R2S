import java.util.Scanner;

public class StudentManagement {

    // Fields

    private final StudentForm studentForm;
    private final Scanner sc;
    private final int MAX = 100;
    private Student[] listOfStudents = new Student[MAX];
    private byte numOfCount = 0;


    // Constructor

    public StudentManagement() {
        this.sc = new Scanner(System.in);
        this.studentForm = new StudentForm(sc);
    }

    // Getter & Setter

    public byte getNumOfCount() {
        return this.numOfCount;
    }

    // Methods

    public Student findStudentById(String id) {
        for (int i = 0; i < numOfCount; i++) {
            if (listOfStudents[i].getId().trim().toLowerCase().equals(id.trim().toLowerCase())) {
                return listOfStudents[i];
            }
        }

        return null;
    }

    // Add New Student

    public void addNewStudent() throws StudentNotFound {
        String id = studentForm.getStudentId();

        if (findStudentById(id) != null)
            throw new StudentNotFound(String.format("ID: %s already exits. PLease try again", id));

        Student student = studentForm.input();
        student.setId(id);

        listOfStudents[numOfCount++] = student;

        System.out.println("Added Successfully!");
    }

    private String header() {
        return String.format("%-8s | %-18s | %-6s | %-3s", "ID", "NAME", "SEX", "AGE");
    }

    // Display All Student

    public void displayAllStudent() throws StudentNotFound {
        if (numOfCount == 0) {
            throw new StudentNotFound("The list is empty. Cannot display");
        }

        System.out.println(header());
        for (int i = 0; i < numOfCount; i++) {
            System.out.println(listOfStudents[i].toString());
        }
    }

    // Find Student By ID

    public Student printStudentById() throws StudentNotFound {
        if (numOfCount == 0) {
            throw new StudentNotFound("The list is empty. Cannot find");
        }

        String id = studentForm.getStudentId();

        for (int i = 0; i < numOfCount; i++) {
            if (listOfStudents[i].getId().trim().equals(id.trim())) {
                System.out.println(header());
                System.out.println(listOfStudents[i].toString());

                return listOfStudents[i];
            }
        }

        throw new StudentNotFound(String.format("The Student ID: %s does not exits", id));

    }

    // Update Student By ID

    public void updateStudentById() throws StudentNotFound {
        if (numOfCount == 0) {
            throw new StudentNotFound("The list is empty. Cannot update");
        }

        String id = studentForm.getStudentId();

        Student foundStudent = findStudentById(id);

        if (foundStudent == null) {
            throw new StudentNotFound(String.format("The Student ID: %s does not exits", id));
        }

        Student newData = studentForm.input();

        foundStudent.setName(newData.getName());
        foundStudent.setGender(newData.getGender());
        foundStudent.setAge(newData.getAge());

        System.out.println("Update student successfully!");
    }

}
