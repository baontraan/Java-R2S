import java.util.Scanner;

public class AntiqueShop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemList itemList = new ItemList();
        byte choice = 0;

        do {
            System.out.println("\n------ANTIQUE SHOP MANAGEMENT------");
            System.out.println("1. Add a new Vase");
            System.out.println("2. Add a new Statue");
            System.out.println("3. Add a new Painting");
            System.out.println("4. Dispay all items");
            System.out.println("5. Find the items by the creator");
            System.out.println("6. Display the list of items");
//            System.out.println("7. Update item by id");
            System.out.println("7. Quit");
            System.out.print("\nEnter your choice: ");
            choice = Byte.parseByte(sc.nextLine());

            switch (choice) {
                case 1:
                    Vase item = new Vase();
                    item.input(itemList);

                    if (itemList.addItem(item)) {
                        System.out.println("Added new Vase Successfully!");
                    } else {
                        System.out.println("Added new Vase Unsuccessfully!");
                    }

                    break;

                case 2:
                    Statue statue = new Statue();
                    statue.input(itemList);

                    if (itemList.addItem(statue)) {
                        System.out.println("Added new Statue Successfully!");
                    } else {
                        System.out.println("Added new Statue Unsuccessfully!");
                    }
                    break;

                case 3:
                    Painting painting = new Painting();
                    painting.input(itemList);

                    if (itemList.addItem(painting)) {
                        System.out.println("Added new Painting Successfully!");
                    } else {
                        System.out.println("Added new Painting Unsuccessfully!");
                    }
                    break;

                case 4:
                    itemList.displayAll();
                    break;

                case 5:
                    itemList.findItemByCreator();
                    break;

                case 6:
                    String type;

                    if (itemList.getNumOfItem() <= 0) {
                        System.out.println("The list is empty. Cannot display");
                        break;
                    }

                    System.out.print("Enter type to display (VASE/STATUE/PAINTING): ");
                    type = sc.nextLine();

                    while (true) {
                        if (type == null || type.trim().isEmpty()) {
                            System.out.println("Type cannot be empty");
                        }
                        break;
                    }

                    itemList.displayItemsByType(type);
                    break;

//                case 7:
//                    String id;
//                    System.out.print("Enter ID item to update: ");
//                    id = sc.nextLine();
//
//                    while (true) {
//                        if (id == null || id.trim().isEmpty()) {
//                            System.out.println("ID cannot be empty");
//                        }
//                        break;
//                    }
//
//                    if (itemList.updateItemById(id)) {
//                        new Item().input(itemList);
//                    }
//                    break;

                case 7:
                    break;

                default:
                    System.out.println("\nInvalid choice");
                    break;
            }
        } while (choice != 8);

        System.out.println("\n------END PROGRAM------");
    }
}
