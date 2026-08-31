import java.util.Scanner;

public class Painting extends Item {

    // Fields

    private int height;
    private int width;
    private boolean isWaterColor;
    private boolean isFramed;

    // Constructors

    public Painting() {

    }

    public Painting(String id, int value, String creator, int height, int width, boolean isWaterColor, boolean isFramed) {
        super(id, value, creator);
        setHeight(height);
        setWidth(width);
        setWaterColor(isWaterColor);
        setFramed(isFramed);
    }

    // Getter & Setter

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        if (height < 0 || height > 2000) {
            throw new IllegalArgumentException("Height must between 0 - 2000");
        }

        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        if (width < 0 || width > 3000) {
            throw new IllegalArgumentException("Width must between 0 - 3000");
        }

        this.width = width;
    }

    public boolean isWaterColor() {
        return this.isWaterColor;
    }

    public void setWaterColor(boolean waterColor) {
        this.isWaterColor = waterColor;
    }

    public boolean isFramed() {
        return this.isFramed;
    }

    public void setFramed(boolean framed) {
        this.isFramed = framed;
    }

    // Methods

    private int validateHeight(String prompt) {
        Scanner sc = new Scanner(System.in);
        int value;

        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(sc.nextLine());

                if (value >= 0 && value <= 2000) return value;

                System.out.println("Height must between 0 - 2000");

            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again " + e.getMessage());
            }
        }
    }

    private int validateWidth(String prompt) {
        Scanner sc = new Scanner(System.in);
        int value;

        while (true) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(sc.nextLine());

                if (value >= 0 && value <= 3000) return value;

                System.out.println("Width must between 0 - 3000");

            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again " + e.getMessage());
            }
        }
    }

    private String validateBoolean(String prompt) {
        Scanner sc = new Scanner(System.in);
        String value;

        while (true) {
            System.out.print(prompt);
            value = sc.nextLine().trim().toLowerCase();

            if (value.isEmpty()) System.out.println("Value cannot be empty");

            if (value.equals("true") || value.equals("false")) break;

            System.out.println("Input accepted True/False. PLease try again");
        }

        return value;
    }

    @Override
    public void input(ItemList itemList) {
        super.input(itemList);
        Scanner sc = new Scanner(System.in);

        height = validateHeight("Enter height: ");
        width = validateWidth("Enter width: ");
        isWaterColor = Boolean.parseBoolean(validateBoolean("Watercolor (True/False): "));
        isFramed = Boolean.parseBoolean(validateBoolean("Framed (True/False): "));
    }

    // To String

    @Override
    public String toString() {
        return super.toString() + ", Height: " + height + ", Width: " + width + ", Is Watercolor: " + isWaterColor + ", Is Framed: " + isFramed;
    }
}
