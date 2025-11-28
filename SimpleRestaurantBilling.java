import java.util.*;

class MenuItem {
    String name;
    double price;

    MenuItem(String n, double p) {
        name = n;
        price = p;
    }
}

public class SimpleRestaurantBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Menu stored with ID and MenuItem object
        HashMap<Integer, MenuItem> menu = new HashMap<>();

        // Lists to store ordered items
        ArrayList<MenuItem> orderItems = new ArrayList<>();
        ArrayList<Integer> orderQty = new ArrayList<>();

        int id = 1;   // For menu item numbering
        int choice = 0;

        // Loop until user exits
        while (choice != 6) {

            // Showing options
            System.out.println("\n=== RESTAURANT BILLING SYSTEM ===");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. Show Menu");
            System.out.println("4. Take Order");
            System.out.println("5. Print Bill");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            // -------------------- ADD ITEM ----------------------
            if (choice == 1) {
                sc.nextLine(); // to clear buffer

                System.out.print("Enter item name: ");
                String name = sc.nextLine();

                System.out.print("Enter item price: ");
                double price = sc.nextDouble();

                // adding to menu
                menu.put(id, new MenuItem(name, price));
                System.out.println("Item added with ID: " + id);
                id++;
            }

            // -------------------- REMOVE ITEM -------------------
            else if (choice == 2) {
                System.out.print("Enter ID to remove: ");
                int rid = sc.nextInt();

                if (menu.containsKey(rid)) {
                    menu.remove(rid);
                    System.out.println("Item removed!");
                } else {
                    System.out.println("Invalid ID!");
                }
            }

            // -------------------- SHOW MENU ---------------------
            else if (choice == 3) {
                System.out.println("\n--- MENU ---");

                for (int key : menu.keySet()) {
                    MenuItem m = menu.get(key);
                    System.out.println(key + ". " + m.name + " - ₹" + m.price);
                }

                if (menu.isEmpty()) {
                    System.out.println("Menu is empty!");
                }
            }

            // -------------------- TAKE ORDER --------------------
            else if (choice == 4) {

                if (menu.isEmpty()) {
                    System.out.println("Menu is empty, add items first!");
                } else {
                    System.out.print("Enter item ID: ");
                    int oid = sc.nextInt();

                    if (menu.containsKey(oid)) {
                        System.out.print("Enter quantity: ");
                        int q = sc.nextInt();

                        orderItems.add(menu.get(oid));
                        orderQty.add(q);
                        System.out.println("Item added to order!");
                    } else {
                        System.out.println("Invalid ID!");
                    }
                }
            }

            // -------------------- PRINT BILL --------------------
            else if (choice == 5) {

                double subtotal = 0;

                System.out.println("\n===== BILL RECEIPT =====");

                // calculating total for each ordered item
                for (int i = 0; i < orderItems.size(); i++) {
                    MenuItem m = orderItems.get(i);
                    int q = orderQty.get(i);

                    double total = m.price * q;
                    subtotal += total;

                    System.out.println(m.name + " x " + q + " = ₹" + total);
                }

                double gst = subtotal * 0.05;
                double grandTotal = subtotal + gst;

                System.out.println("-------------------------");
                System.out.println("Subtotal: ₹" + subtotal);
                System.out.println("GST (5%): ₹" + gst);
                System.out.println("Total Amount: ₹" + grandTotal);
                System.out.println("=========================");
            }

            // -------------------- EXIT PROGRAM ------------------
            else if (choice == 6) {
                System.out.println("Exiting... Thank you!");
            }

            // -------------------- INVALID INPUT -----------------
            else {
                System.out.println("Invalid option! Try again.");
            }
        }
    }
}
