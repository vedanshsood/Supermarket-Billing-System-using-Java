import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class supermarket {
    private Map<String, product> inventory;
    private ArrayList<product> cart;

    public supermarket() {
        inventory = new HashMap<>();
        cart = new ArrayList<>();
        initializeInventory();
    }
    private void initializeInventory() {
        inventory.put("Apple", new product("Apple", 0.5, 100));
        inventory.put("Banana", new product("Banana", 0.2, 150));
        inventory.put("Milk", new product("Milk", 1.5, 50));
        inventory.put("Bread", new product("Bread", 2.0, 75));
        inventory.put("Eggs", new product("Eggs", 3.0, 200));
        inventory.put("Cheese", new product("Cheese", 4.0, 60));
        inventory.put("Butter", new product("Butter", 2.5, 80));
        inventory.put("Chicken", new product("Chicken", 5.0, 40));
        inventory.put("Beef", new product("Beef", 7.0, 35));
        inventory.put("Fish", new product("Fish", 6.0, 50));
        inventory.put("Rice", new product("Rice", 1.0, 150));
        inventory.put("Pasta", new product("Pasta", 1.2, 120));
        inventory.put("Tomato", new product("Tomato", 0.7, 100));
        inventory.put("Potato", new product("Potato", 0.6, 100));
        inventory.put("Onion", new product("Onion", 0.5, 100));
        inventory.put("Carrot", new product("Carrot", 0.8, 90));
        inventory.put("Broccoli", new product("Broccoli", 1.3, 70));
        inventory.put("Lettuce", new product("Lettuce", 1.0, 50));
        inventory.put("Cucumber", new product("Cucumber", 0.9, 80));
        inventory.put("Bell Pepper", new product("Bell Pepper", 1.5, 60));
        inventory.put("Orange", new product("Orange", 0.8, 120));
        inventory.put("Grapes", new product("Grapes", 2.0, 80));
        inventory.put("Watermelon", new product("Watermelon", 3.0, 30));
        inventory.put("Strawberry", new product("Strawberry", 2.5, 60));
        inventory.put("Blueberry", new product("Blueberry", 3.5, 40));
        inventory.put("Yogurt", new product("Yogurt", 1.0, 100));
        inventory.put("Juice", new product("Juice", 2.0, 70));
        inventory.put("Soda", new product("Soda", 1.5, 90));
        inventory.put("Coffee", new product("Coffee", 4.0, 50));
        inventory.put("Tea", new product("Tea", 3.0, 60));      
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (product product : inventory.values()) {
            System.out.printf("%s - $%.2f (%d in stock)\n", product.getName(), product.getPrice(), product.getQuantity());
        }
    }

    public void addToCart(String productName, int quantity) {
        product product = inventory.get(productName);
        if (product != null && product.getQuantity() >= quantity) {
            cart.add(new product(productName, product.getPrice(), quantity));
            product.setQuantity(product.getQuantity() - quantity);
            System.out.printf("%d %s(s) added to cart.\n", quantity, productName);
        } else {
            System.out.println("Product not available or insufficient stock.");
        }
    }
    public void displayCart() {
        System.out.println("Your Cart:");
        double total = 0.0;
        for (product product : cart) {
            System.out.printf("%s - $%.2f (x%d)\n", product.getName(), product.getPrice(), product.getQuantity());
            total += product.getPrice() * product.getQuantity();
        }
        System.out.printf("Total: $%.2f\n", total);
    }

    public void checkout() {
        displayCart();
        cart.clear();
        System.out.println("Thank you for your purchase!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        supermarket supermarket = new supermarket();

        while (true) {
            System.out.println("1. Display Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    supermarket.displayProducts();
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String productName = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    supermarket.addToCart(productName, quantity);
                    break;
                case 3:
                    supermarket.displayCart();
                    break;
                case 4:
                    supermarket.checkout();
                    break;
                case 5:
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

}
