import java.util.Scanner;

public abstract class Product {

    // Fields

    protected int id;
    protected String name;
    protected float price;

    // Contructors

    public Product() {

    }

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter & Setter

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must > 0");
        }

        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must >= 0");
        }

        this.price = price;
    }

    // Methods

    protected String readNonEmpty(String prompt, Scanner sc) {
        while (true) {
            System.out.print(prompt);
            String value = sc.nextLine().trim();

            if (!value.isEmpty()) return value;

            System.out.println("Value cannot be empty");
        }
    }

    protected float readPrice(String prompt, Scanner sc) {
        while (true) {
            try {
                System.out.print(prompt);
                float price = Float.parseFloat(sc.nextLine());

                if (price >= 0) return price;

                System.out.println("Price must be >= 0");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again");
            }
        }
    }

    public void input(Scanner sc) {
        name = readNonEmpty("Enter name: ", sc);
        price = readPrice("Enter price: ", sc);
    }

    public abstract void update(Scanner sc);

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price;
    }
}
