import java.util.Scanner;

public class ItemList {

    // Fields

    private Item[] list;
    private int numOfItem;
    private final int MAX = 100;

    // Constructors

    public ItemList() {
        list = new Item[MAX];
        numOfItem = 0;
    }

    // Getter & Setter

    public int getNumOfItem() {
        return this.numOfItem;
    }

    // Methods

    // FindItemById

    public Item findItemById(String id) {
        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getId().trim().equalsIgnoreCase(id)) {
                return list[i];
            }
        }

        return null;
    }

    // 1. Add New Item

    public boolean addItem(Item item) {
        if (item == null || getNumOfItem() >= MAX) {
            return false;
        }

        list[numOfItem++] = item;

        return true;
    }

    // 2. Display All

    public void displayAll() {
        if (numOfItem <= 0) {
            System.out.println("The list is empty. Cannot display");
        }

        for (int i = 0; i < numOfItem; i++) {
            System.out.println(list[i].toString());
        }
    }

    // 3. Find Item By Creator

    public Item findItemByCreator() {
        if (numOfItem <= 0) {
            System.out.println("The list is empty. Cannot find");
            return null;
        }

        Scanner sc = new Scanner(System.in);
        boolean found = false;

        System.out.print("Enter creator name to find: ");
        String creator = sc.nextLine();


        for (int i = 0; i < numOfItem; i++) {
            if (list[i].getCreator().trim().equalsIgnoreCase(creator.trim())) {
                System.out.println(list[i].toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println(String.format("Cannot find item with creator name: %s", creator));
        }

        return null;
    }

    // Display Item By Type

    public void displayItemsByType(String type) {
        if (type.equals("VASE")) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Vase) {
                    System.out.println(list[i].toString());
                }
            }
        } else if (type.equals("STATUE")) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Statue) {
                    System.out.println(list[i].toString());
                }
            }
        } else if (type.equals("PAINTING")) {
            for (int i = 0; i < numOfItem; i++) {
                if (list[i] instanceof Painting) {
                    System.out.println(list[i].toString());
                }
            }
        } else {
            System.out.println(String.format("Invalid type. The type %s does not exits", type));
        }
    }

    // Update Item By ID

    public boolean updateItemById(String id) {
        if (numOfItem <= 0) {
            System.out.println("The list is empty. Cannot update");
            return false;
        }

        return findItemById(id) != null;
    }


}
