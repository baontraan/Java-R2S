public class Student {

    // Fields

    private String id;
    private int age;
    private String gender;
    private String name;

    // Constuctors

    public Student() {

    }

    public Student(String id, String name, String gender, int age) {
        setId(id);
        setName(name);
        setGender(gender);
        setAge(age);
    }

    // Getter & Setter

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }

        this.id = id.trim();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name.trim();
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.isEmpty()) {
            throw new IllegalArgumentException("Gender cannot be empty");
        }

        String genderFormat = gender.trim().toLowerCase();

        if (!genderFormat.equals("male") && !genderFormat.equals("female")) {
            throw new IllegalArgumentException("Gender must be 'male' or 'female'");
        }

        this.gender = genderFormat;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must >= 18");
        }

        this.age = age;
    }

    // Methods

    @Override
    public String toString() {
        return String.format("%-8s | %-18s | %-6s | %-3d", id, name, gender, age);
    }
}
