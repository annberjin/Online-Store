import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();

        // Load products from file
        loadProducts(store);

        // Create products (polymorphism used)
        Product laptop = new ElectronicsProduct("152334", "Laptop", "High performance laptop", 1200.00, "Dell", "XPS 13", 24);
        Product jeans = new ClothingProduct("487945", "Jeans", "Comfortable jeans", 40.00, "M", "Cotton", Arrays.asList("Blue", "Black"));

        // Register users
        UserShoppingCart user1Cart = new UserShoppingCart("user1");
        UserShoppingCart user2Cart = new UserShoppingCart("user2");
        store.registerUser(user1Cart);
        store.registerUser(user2Cart);

        // Display available products
        store.displayProducts();

        // Add products to user1's cart using the overloaded addToCart method
        Product product1 = store.findProductById("152334"); // Laptop ID (Electronics)
        if (product1 != null) {
            user1Cart.addToCart((ElectronicsProduct) product1); // Add ElectronicsProduct 
        }

        Product product2 = store.findProductById("487945"); // Jeans ID (Clothing)
        if (product2 != null) {
            user1Cart.addToCart((ClothingProduct) product2); // Add ClothingProduct 
        }

        user1Cart.addToCart(laptop);  // Polymorphically treated as a Product
        user1Cart.addToCart(jeans);

        // Checkout user1's cart
        store.checkout(user1Cart);
    }

    // Load products from the file
    //Static method
    public static void loadProducts(OnlineStore store) {
        try {
            Scanner scanner = new Scanner(new File("data.txt"));
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Skip the header
            }

            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");

                if (data.length < 8) {
                    continue; // Skip  lines that mess with the index
                }

                String type = data[0].trim();
                String id = data[1].trim();
                String name = data[2].trim();
                String description = data[3].trim();
                double price = Double.parseDouble(data[4].trim());

                switch (type) {
                    case "electric":
                        String brand = data[5].trim();
                        String model = data[6].trim();
                        int warranty = Integer.parseInt(data[7].trim());
                        ElectronicsProduct ep = new ElectronicsProduct(id, name, description, price, brand, model, warranty);
                        store.addProduct(ep);
                        break;

                    case "clothing":
                        String size = data[5].trim();
                        String material = data[6].trim();
                        String[] colors = data[7].trim().split(";");
                        ClothingProduct cp = new ClothingProduct(id, name, description, price, size, material, Arrays.asList(colors));
                        store.addProduct(cp);
                        break;

                    default:
                        System.out.println("Unknown product type: " + type);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}