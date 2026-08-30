public class Trainee {

    // Fields

    private String id;
    private String name;
    private String gender;
    private byte age;

    // Constructor

    public Trainee() {

    }

    public Trainee(String id, String name, String gender, byte age) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.age = age;

        // Cách này gán trực tiếp giá trị vào các thuộc tính của đối tượng
        // Ko thể validate => Dùng setter để gán giá trị + validate

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
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");

            // Tạo ra 1 đối tượng lỗi(tham số ko hợp lệ) và ném ra kèm thông báo
            // Khi có lỗi, ném lỗi ra và crash chương trình. Chương trình dừng lại ko chạy tiếp
            // Để ko crash thì dùng try-catch xử lý
        }

        this.id = id.trim();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
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

        String result = gender.trim().toLowerCase();

        if (!result.equals("male") && !result.equals("female")) {
            throw new IllegalArgumentException("Gender must be 'male' or 'female'");
        }

        this.gender = result;
    }

    public byte getAge() {
        return this.age;
    }

    public void setAge(byte age) {
        if (age < 6) {
            throw new IllegalArgumentException("Age must be >= 6");
        }

        this.age = age;
    }

    // Methods

    @Override
    public String toString() {
        return String.format("%-8s | %-18s | %-6s | %-3d", id, name, gender, age);

        // -: Căn lề trái
        // 8,18: Độ rộng tối thiểu của cột đó phải chiếm ít nhất 8, 18 ký tự
    }
}
