import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Scanner sc = new Scanner(System.in);

        String choice;

        do {
            System.out.println("\n------CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN------");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo ID");
            System.out.println("4. Cập nhật thông tinh sinh viên theo ID");
            System.out.println("5. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextLine();

            switch (choice){
                case "1":
                    sm.createNewStudent();
                    break;

                case "2":
                    sm.displayStudent();
                    break;

                case "3":
                    sm.printStudentById();
                    break;

                case "4":
                    sm.updateStudentById();
                    break;

                case "5":
                    break;

                default:
                    System.out.println("\nLựa chọn không hợp lệ. Vui lòng nhập lại");
                    break;
            }
        }while(!choice.equals("5"));

        System.out.println("\n------CHƯƠNG TRÌNH ĐÃ KẾT THÚC------");
    }
}
