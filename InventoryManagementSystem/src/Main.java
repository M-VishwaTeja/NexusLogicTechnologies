import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Display Specific Product");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Product
                    System.out.println("Enter product name:");
                    String name = scanner.next();
                    System.out.println("Enter product price:");
                    double price = scanner.nextDouble();
                    System.out.println("Enter product quantity:");
                    int quantity = scanner.nextInt();
                    inventory.addProduct(new Product(0, name, price, quantity));
                    break;
                case 2:
                    // Update Product
                    System.out.println("Enter product id:");
                    int id = scanner.nextInt();
                    System.out.println("Enter new price:");
                    double newPrice = scanner.nextDouble();
                    System.out.println("Enter new quantity:");
                    int newQuantity = scanner.nextInt();
                    inventory.updateProduct(new Product(id, "", newPrice, newQuantity));
                    break;
                case 3:
                    // Delete Product
                    System.out.println("Enter product id:");
                    id = scanner.nextInt();
                    inventory.deleteProduct(id);
                    break;
                case 4:
                    // Display All Products
                    inventory.getAllProducts();
                    break;
                case 5:
                    // Display Specific Product
                    System.out.println("Enter product id:");
                    id = scanner.nextInt();
                    inventory.getProduct(id);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
