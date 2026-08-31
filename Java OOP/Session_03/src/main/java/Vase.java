import java.util.Scanner;

public class Vase extends Item {

    // Fields

    private int height;
    private String material;

    // Contructors

    public Vase() {

    }

    public Vase(String id, int value, String creator, int height, String material) {
        super(id, value, creator);
        setHeight(height);
        setMaterial(material);
    }

    // Getter & Setter

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        if (height < 0 || height > 2000) {
            throw new IllegalArgumentException("Invalid number. Height must between 0 - 2000");
        }

        this.height = height;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        if (material == null || material.isEmpty()) {
            throw new IllegalArgumentException("Material cannot be empty");
        }

        this.material = material;
    }

    // Methods

    private String validatePrompt(String prompt) {
        Scanner sc = new Scanner(System.in);
        String value;

        while (true) {

            try {
                System.out.printf(prompt);
                value = sc.nextLine();

                if (value != null && !value.trim().isEmpty()) return value;

                System.out.println("Value cannot be empty");

            } catch (IllegalArgumentException e) {
                System.out.println("Value cannot be empty. " + e.getMessage());

            }
        }
    }

    private int validateHeight(String prompt) {
        Scanner sc = new Scanner(System.in);
        int value;

        while (true) {

            try {
                System.out.print(prompt);
                value = Integer.parseInt(sc.nextLine());

                if (value >= 0 && value <= 2000) return value;

                System.out.println("Invalid number.Height must between 0 - 2000");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Input must be a number & cannot be empty " + e.getMessage());
            }

        }
    }

    @Override
    public void input(ItemList itemList) {
        super.input(itemList);
        Scanner sc = new Scanner(System.in);

        height = validateHeight("Enter height: ");
        material = validatePrompt("Enter material: ");

    }

    // To String

    @Override
    public String toString() {
        return super.toString() + ", Height: " + height + ", Material: " + material;
    }


}



