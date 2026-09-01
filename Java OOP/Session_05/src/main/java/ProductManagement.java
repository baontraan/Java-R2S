import java.util.Scanner;

public class ProductManagement {

    // Fields

    private final static int MAX = 10;
    private Product[] products = new Product[MAX];
    private int numOfProduct = 0;
    private final static Scanner sc = new Scanner(System.in);

    // Getter & Setter

    public int getNumOfProduct() {
        return this.numOfProduct;
    }

    // Methods

    public boolean isProductIdExits(int id) {
        for (int i = 0; i < numOfProduct; i++) {
            if (products[i].getProductID() == id) return true;
        }
        return false;
    }

    public int readProductId(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int id = Integer.parseInt(sc.nextLine());

                if (isProductIdExits(id))
                    throw new IllegalArgumentException(String.format("The product ID: %d already exits", id));

                if (id > 0) return id;

                throw new IllegalArgumentException("ID must > 0");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter an integer number");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public String readProductName(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String name = sc.nextLine().trim();

                if (!name.isEmpty()) return name;

                throw new IllegalArgumentException("Name cannot be empty");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public double readProductPrice(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double price = Double.parseDouble(sc.nextLine());

                if (price >= 0) return price;

                throw new IllegalArgumentException("Price must be >= 0");

            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Please enter a valid number " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public int readQuantityInStock(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int quantity = Integer.parseInt(sc.nextLine());

                if (quantity >= 0) return quantity;

                throw new IllegalArgumentException("Quantity must be >= 0");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid number");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // 1. Add new Product

    public void addNewProduct() throws IllegalArgumentException {
        if (numOfProduct >= MAX) {
            throw new IllegalArgumentException("The list is full. Cannot add more");
        }

        int productId = readProductId(sc, "Enter product ID: ");
        String name = readProductName(sc, "Enter name: ");
        double price = readProductPrice(sc, "Enter price: ");
        int quantityInStock = readQuantityInStock(sc, "Enter quantity in stock: ");

        Product product = new Product(productId, name, price, quantityInStock);
        products[numOfProduct++] = product;
    }

    // 2. Display All Product

    public void displayAllProduct() throws IllegalArgumentException {
        if (numOfProduct == 0) {
            throw new IllegalArgumentException("The list is empty. Cannot display");
        }

        for (int i = 0; i < numOfProduct; i++) {
            products[i].displayProductInfo();
        }
    }

    // 3. Find Product By ID

    public Product findProductById() throws ProductNotFoundException {
        if (numOfProduct == 0) {
            throw new ProductNotFoundException("\nThe list is empty. Cannot find");
        }

        int id;

        while (true) {
            try {
                System.out.print("Enter Product ID to find: ");
                id = Integer.parseInt(sc.nextLine());
                if (id > 0) break;

                throw new IllegalArgumentException("ID must > 0");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. PLease enter an integer number");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        for (int i = 0; i < numOfProduct; i++) {
            if (isProductIdExits(id)) {
                products[i].displayProductInfo();
                return products[i];
            } else {
                System.out.println(String.format("The Product ID: %d does not exits", id));
                break;
            }
        }
        return null;
    }

    public Product getProductById(int id) {
        for (int i = 0; i < numOfProduct; i++) {
            if (products[i].getProductID() == id) return products[i];
        }

        return null;
    }

    // 4. Update Product Quantity

    public void updateProductQuantity(int productID, int newQuantity) throws ProductNotFoundException {
        Product productFound = getProductById(productID);
        if (productFound != null) {
            productFound.setQuantityInStock(newQuantity);
        } else {
            throw new ProductNotFoundException(String.format("The Product ID %d does not exist", productID));
        }
    }
}
