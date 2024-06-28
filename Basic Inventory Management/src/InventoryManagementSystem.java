import java.util.Scanner;

public class InventoryManagementSystem {

    private static DatabaseHandler dbHandler = new DatabaseHandler();

    public static void main(String[] args) {
        dbHandler.createNewDatabase();
        dbHandler.createNewTable();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    viewItems();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter item name: ");
        String name = scanner.next();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        dbHandler.insert(name, quantity);
        System.out.println("Item added successfully.");
    }

    private static void viewItems() {
        dbHandler.selectAll();
    }
}

