import java.util.Scanner;

public class Statue extends Item {

    // Fields

    private int weight;
    private String color;

    // Constructors

    public Statue() {

    }

    public Statue(String id, int value, String creator, int weight, String color) {
        super(id, value, creator);
        setWeight(weight);
        setColor(color);
    }

    // Getter & Setter

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        if (weight < 0 || weight > 1000) {
            throw new IllegalArgumentException("Weight must between 0 - 1000");
        }

        this.weight = weight;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        if (color == null || color.isEmpty()) {
            throw new IllegalArgumentException("Color cannot be empty");
        }

        this.color = color;
    }

    // Method

    private int validateWeight(String prompt) {
        Scanner sc = new Scanner(System.in);
        int value;

        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(sc.nextLine());

                if (value >= 0 && value <= 1000) return value;

                System.out.println("Weight must between 0 - 1000");

            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again. " + e.getMessage());
            }
        }
    }

    private String validatePrompt(String prompt) {
        Scanner sc = new Scanner(System.in);
        String value;

        while (true) {

            System.out.print(prompt);
            value = sc.nextLine();

            if (value != null && !value.trim().isEmpty()) return value;

            System.out.println("Value cannot be empty");
        }
    }

    @Override
    public void input(ItemList itemList) {
        super.input(itemList);
        Scanner sc = new Scanner(System.in);

        weight = validateWeight("Enter weight: ");
        color = validatePrompt("Enter color: ");
    }

    // To String


    @Override
    public String toString() {
        return super.toString() + ", Weight: " + weight + ", Color: " + color;
    }
}
