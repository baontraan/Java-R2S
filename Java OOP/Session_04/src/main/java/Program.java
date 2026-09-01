import java.util.Scanner;

public class Program {

    // Fields

    private Product[] products;
    private byte numOfType;
    private final byte MAX = 100;

    // Constructors

    public Program() {
        products = new Product[MAX];
        numOfType = 0;
    }

    // Getter & Setter

    public byte getNumOfType() {
        return this.numOfType;
    }

    public void setNumOfType(byte numOfType) {
        if (numOfType < 0) {
            throw new IllegalArgumentException("Num of type must >= 0");
        }

        this.numOfType = numOfType;
    }

    // Methods

    // Find Product By ID

    public boolean isProductExits(int id) {
        for (int i = 0; i < numOfType; i++) {
            if (products[i].getId() == id) return true;
        }

        return false;
    }

    // 1. Add New Product

    public void addNewProduct(Product product) {
        if (numOfType >= MAX) {
            System.out.println("The list is full. Cannot add more!");
        } else {
            products[numOfType++] = product;
        }

        System.out.println("Added Successfully!");
    }

    public void addProductSubMenu(Scanner sc) {
        byte choice = 0;
        do {
            System.out.println("\n------Add Product------");
            System.out.println("1. Electronics");
            System.out.println("2. Clothing");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");

            choice = Byte.parseByte(sc.nextLine());

            Product p;

            switch (choice) {
                case 1: {
                    int id;

                    p = new Electronics();
                    while (true) {

                        System.out.print("Enter id: ");
                        id = Integer.parseInt(sc.nextLine());

                        if (!isProductExits(id)) break;

                        System.out.println("ID already exits. Try again");

                    }
                    p.setId(id);
                    p.input(sc);
                    addNewProduct(p);
                    break;
                }

                case 2: {
                    int id;
                    p = new Clothing();
                    while (true) {
                        System.out.print("Enter id: ");
                        id = Integer.parseInt(sc.nextLine());

                        if (!isProductExits(id)) break;

                        System.out.println("ID already exits. Try again");
                    }
                    p.setId(id);
                    p.input(sc);
                    addNewProduct(p);
                    break;
                }

                case 3:
                    break;

                default:
                    System.out.println("\nInvalid choice!");
                    break;
            }

        } while (choice != 3);
    }

    // 2. Display ALl Products

    public void displayAllProducts() {
        if (numOfType == 0) {
            System.out.println("The list products is empty. Cannot display");
        } else {
            for (int i = 0; i < numOfType; i++) {
                System.out.println(products[i].toString());
            }
        }
    }

    // 3. Find Product By Id

    public Product findProductById(int id) {
        for (int i = 0; i < numOfType; i++) {
            if (products[i].getId() == id) return products[i];
        }

        return null;
    }

    // 4 Update Product By ID

    public void updateProductById(int id, Scanner sc) {
        Product result = findProductById(id);

        if (result != null) result.update(sc);
    }

    public static void main(String[] args) {
        Program program = new Program();
        Scanner sc = new Scanner(System.in);

        byte option = 0;

        do {
            System.out.println("\n======PROGRAMMING======");
            System.out.println("1. Add new product");
            System.out.println("2. Display all products");
            System.out.println("3. Find product by ID");
            System.out.println("4. Update product by ID");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            option = Byte.parseByte(sc.nextLine());

            switch (option) {
                case 1:
                    program.addProductSubMenu(sc);
                    break;

                case 2:
                    program.displayAllProducts();
                    break;

                case 3:
                    int id;
                    while (true) {
                        if (program.getNumOfType() == 0) {
                            System.out.println("The list products is empty. Cannot find");
                            break;
                        }

                        System.out.print("\nEnter id to find product: ");
                        id = Integer.parseInt(sc.nextLine());

                        Product result = program.findProductById(id);
                        if (result != null) {
                            System.out.println(result.toString());
                            break;
                        }

                        System.out.println(String.format("\nThe product ID: %d does not exits. Please try again", id));
                    }

                    break;

                case 4:
                    int id_update;

                    while (true) {
                        if (program.getNumOfType() == 0) {
                            System.out.println("The list product is empty. Cannot update");
                            break;
                        }

                        System.out.print("\nEnter product id to update: ");
                        id_update = Integer.parseInt(sc.nextLine());

                        if (program.findProductById(id_update) != null) {
                            program.updateProductById(id_update, sc);
                            System.out.println("\nUpdated Successfully");
                            break;
                        }

                        System.out.println(String.format("\nThe product ID: %d does not exits. Try again", id_update));

                    }
                    break;

                case 5:
                    break;

                default:
                    System.out.println("\nInvalid option. Try again");
                    break;
            }
        } while (option != 5);

        System.out.println("\n======END PROGRAM======");
    }

}
