import java.util.Scanner;

public class Item {

    // Fields

    protected String id;
    protected int value;
    protected String creator;

    // Constructors

    public Item() {

    }

    public Item(String id, int value, String creator) {
        setId(id);
        setValue(value);
        setCreator(creator);
    }

    // Getter & Setter

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }
        this.id = id;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Invalid number. Value must be >= 0");
        }
        this.value = value;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        if (creator == null || creator.isEmpty()) {
            throw new IllegalArgumentException("Creator cannot be empty");
        }
        this.creator = creator;
    }

    // Methods

    // Validate Prompt

    private String validatePrompt(String prompt) {
        Scanner sc = new Scanner(System.in);
        String field;

        while (true) {

            System.out.print(prompt);
            field = sc.nextLine();

            if (field != null && !field.trim().isEmpty()) return field;

            System.out.println("Field cannot be empty ");
        }

    }

    // Validate Value

    private int validateValue(String prompt) {
        Scanner sc = new Scanner(System.in);
        int value;

        while (true) {

            try {
                System.out.print(prompt);
                value = Integer.parseInt(sc.nextLine());

                if (value >= 0) return value;

                System.out.println("Value must be >= 0");

            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again. " + e.getMessage());
            }
        }
    }

    // Input

    public void input(ItemList itemList) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            id = validatePrompt("Enter ID: ");

            if (itemList.findItemById(id) != null) {
                System.out.println(String.format("ID %s exitsted. Try again", id));
                continue;
            }

            break;
        }
        value = validateValue("Enter value: ");
        creator = validatePrompt("Enter creator: ");
    }

    // To String

    @Override
    public String toString() {
        return String.format("ID: %s, Value: %d, Creator: %s", id, value, creator);
    }
}
