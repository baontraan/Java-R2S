import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        ProductManagement pm = new ProductManagement();
        Scanner sc = new Scanner(System.in);
        byte choice = 0;

        do {
            System.out.println("\n===PRODUCT MANAGEMENT MENU===");
            System.out.println("1. Add New Product");
            System.out.println("2. Diplay All Product");
            System.out.println("3. Retrieve Product By ID");
            System.out.println("4. Update Product Quantity");
            System.out.println("5. Exit");
            System.out.print("\nSelect an option: ");
            choice = Byte.parseByte(sc.nextLine());

            switch (choice) {
                case 1:
                    try {
                        pm.addNewProduct();
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nError: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        pm.displayAllProduct();
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nError: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        pm.findProductById();
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    int id;

                    if (pm.getNumOfProduct() == 0) {
                        System.out.println("The list is empty. Cannot update.");
                        break;
                    }

                    while (true) {
                        try {


                            System.out.println("Enter ID to update: ");
                            id = Integer.parseInt(sc.nextLine());

                            if (id > 0) break;

                            throw new IllegalArgumentException("ID must > 0");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number. PLease enter an integer number");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    if (pm.getProductById(id) == null) {
                        System.out.printf("Error: The Product ID %d does not exist.%n", id);
                        break;
                    }

                    int newQuantity = pm.readQuantityInStock(sc, "Enter new quantity: ");

                    try {
                        pm.updateProductQuantity(id, newQuantity);
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("\nInvalid choice");
                    break;

            }
        } while (choice != 5);
        System.out.println("\n===END PROGRAM===");

    }
}
