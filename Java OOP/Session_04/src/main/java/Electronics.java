import java.util.Scanner;

public class Electronics extends Product {

    // Fields

    private String brand;

    // Constructors

    public Electronics(int id, String name, float price, String brand) {
        super(id, name, price);
        setBrand(brand);
    }

    public Electronics() {
    }

    // Getter & Setter

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.brand = brand;
    }

    // Methods

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        brand = readNonEmpty("Enter brand: ", sc);
    }

    @Override
    public void update(Scanner sc) {
        name = readNonEmpty("Enter new name: ", sc);
        price = readPrice("Enter new price: ", sc);
        brand = readNonEmpty("Enter new brand: ", sc);
    }

    @Override
    public String toString() {
        return super.toString() + ", Brand: " + brand;
    }
}
