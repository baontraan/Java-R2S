import java.util.Scanner;

public class StudentManagement {

    Student[] students = new Student[100];
    Scanner sc = new Scanner(System.in);

    int count = 0;

    // Hàm kiểm tra các trường không dc bỏ trống

    String checkEmptyFields(String fields){
        while (true){
            System.out.print(String.format("Nhập %s: ", fields));
            String value = sc.nextLine().trim();

            if(value.isEmpty()){
                System.out.println(String.format("Lỗi ! Trường %s không được để trống", fields));
                System.out.println("Vui lòng nhập lại");
            }else{
                return value;
            }
        }
    }

    // Hàm validate tuổi

    int validateAge(){
        int age;
        while (true){
             age = Integer.parseInt(checkEmptyFields("tuổi"));

            if(age < 18){
                System.out.println("Tuổi phải từ 18 trở lên. Vui lòng nhập lại");
            }else{
                break;
            }
        }
        return age;
    }

    // Hàm validate giới tính

    String validateGender(){
        String gender;

        while (true){
            gender = checkEmptyFields("giới tính");

            if(gender.equalsIgnoreCase("nam") || gender.equalsIgnoreCase("nữ")){
                break;
            }else{
                System.out.println("Giới tính không hợp lệ. Vui lòng nhập lại");
            }
        }

        return gender;
    }

    // Hàm validate email

    String validateEmail(){
        String email;

        while (true){
            email = checkEmptyFields("email");

            if(email.contains("@")){
                break;
            }else{
                System.out.println("Email không hợp lệ. Vui lòng nhập lại");
            }
        }

        return email;

    }

    // Hàm validate trùng id

    Student findStudentById(int id){

        for (int i = 0; i < count; i++){
            if(students[i] != null && students[i].id == id) return  students[i];
        }

        return null;
    }

    // Hàm thêm mới sinh viên

    void createNewStudent() {

        if(count >= 100){
            System.out.println("Danh sách sinh viên đã đầy. Không thể thêm mới");
            return;
        }

        Student student = new Student();

        while (true){
            student.id = Integer.parseInt(checkEmptyFields("ID sinh viên"));

            if(student.id <= 0){
                System.out.println("Mã sinh viên phải > 0. Vui lòng nhập lại");
                continue;

            }

            if(findStudentById(student.id) == null){
                break;
            }else{
                System.out.println(String.format("Mã sinh viên %d đã tồn tại. Vui lòng nhập lại", student.id));
            }
        }

        student.name = checkEmptyFields("tên sinh viên");
        student.age = validateAge();
        student.gender = validateGender();
        student.address = checkEmptyFields("địa chỉ");
        student.email = validateEmail();

        students[count] = student;
        count++;

        System.out.println(String.format("Thêm sinh viên mới có ID = %d, Tên: %s thành công", student.id, student.name));

    }

    // Hàm hiển thị danh sách sinh viên

    void displayStudent(){
        if(count == 0){
            System.out.println("\nDanh sách rỗng. Chưa có sinh viên nào để hiển thị");
            return;
        }

        System.out.println("\nDanh Sách Sinh Viên");

        for (int i = 0; i < count; i++) {
            System.out.println(String.format("\nSinh viên thứ %d ", i + 1));
            System.out.println(String.format("ID: %d", students[i].id));
            System.out.println(String.format("Họ tên: %s", students[i].name));
            System.out.println(String.format("Tuổi: %d", students[i].age));
            System.out.println(String.format("Giới tính: %s", students[i].gender));
            System.out.println(String.format("Địa chỉ: %s", students[i].address));
            System.out.println(String.format("Email: %s", students[i].email));
        }
    }

    // Tìm và xuất thông tin sinh viên thông qua id

    void printStudentById(){
        int id;

        while (true){

            if(count == 0){
                System.out.println("Hiện chưa có sinh viên nào tồn tại trong hệ thống");
                System.out.println("Vui lòng chọn chức năng thêm mới sinh viên trước rồi hãy truy vấn");
                break;
            }

            System.out.print("Nhập ID của sinh viên cần tìm: ");
            id = Integer.parseInt(sc.nextLine());

            Student result = findStudentById(id);

            if(id <= 0){
                System.out.println("ID không hợp lệ (ID > 0). Vui lòng nhập lại");
                continue;
            }

            if(result != null) {
                System.out.println(String.format("\nThông tin sinh viên có ID = %d: ", id));
                System.out.println(String.format("ID: %d", result.id));
                System.out.println(String.format("Họ tên: %s", result.name));
                System.out.println(String.format("Tuổi: %d", result.age));
                System.out.println(String.format("Giới tính: %s", result.gender));
                System.out.println(String.format("Địa chỉ: %s", result.address));
                System.out.println(String.format("Email: %s", result.email));
                break;
            }else{
                System.out.println(String.format("Sinh viên có ID = %d không tồn tại. Vui lòng thử lại", id));
            }
        }

    }

    // Hàm cập nhật sinh viên theo ID

    void updateStudentById(){
        int id;

        while (true){

            if(count == 0){
                System.out.println("Hiện chưa có sinh viên nào tồn tại trong hệ thống");
                System.out.println("Vui lòng chọn chức năng thêm mới sinh viên trước rồi hãy cập nhật");
                break;
            }

            id = Integer.parseInt(checkEmptyFields("vào ID của sinh viên cần cập nhật"));

            Student result = findStudentById(id);

            if(id <= 0){
                System.out.println("ID không hợp lệ (id > 0). Vui lòng nhập lại");
                continue;
            }

            if(result != null){
                System.out.println(String.format("\nNhập thông tin cập nhật cho sinh viên có ID = %d", id));
                result.name = checkEmptyFields("họ tên");
                result.age = validateAge();
                result.gender = validateGender();
                result.address = checkEmptyFields("dịa chỉ");
                result.email = validateEmail();

                System.out.println(String.format("Cập nhật sinh viên có ID = %d thành công", id));

                break;
            }else{
                System.out.println(String.format("Sinh viên có ID = %d không tồn tại trong hệ thống. Vui lòng thử lại", id));
            }
        }
    }

}

