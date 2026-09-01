import com.sun.nio.sctp.IllegalReceiveException;

import java.util.Scanner;

public class Clothing extends Product {

    // Fields

    private String size;

    // Contructors

    public Clothing(int id, String name, float price, String size) {
        super(id, name, price);
        setSize(size);
    }

    public Clothing() {
    }

    // Getter & Setter

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        if (size == null || size.isEmpty()) {
            throw new IllegalReceiveException("Size cannot be empty");
        }

        this.size = size;
    }

    // Methods

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        size = readNonEmpty("Enter size: ", sc);
    }

    @Override
    public void update(Scanner sc) {
        name = readNonEmpty("Enter new name: ", sc);
        price = readPrice("Enter new price: ", sc);
        size = readNonEmpty("Enter new size: ", sc);
    }


    @Override
    public String toString() {
        return super.toString() + ", Size: " + size;
    }
}
