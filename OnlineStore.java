import java.util.ArrayList;
import java.util.List;

public class OnlineStore {
    // Aggregation used here.
    //OnlineStore has product and a user shopping cart
    private List<Product> inventory;
    private List<UserShoppingCart> userCarts;

    public OnlineStore() {
        inventory = new ArrayList<>();
        userCarts = new ArrayList<>();
    }

    // Add products to the store's inventory
    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println(product.getName() + " has been added to the store.");
    }

    // Register users and assign shopping carts
    public void registerUser(UserShoppingCart cart) {
        userCarts.add(cart);
        System.out.println("A new user has been registered.");
    }

    // Display available products
    public void displayProducts() {
        System.out.println("Available Products:");
        for (Product product : inventory) {
            System.out.println(product.toString());
        }
    }

    // Find product by ID
    public Product findProductById(String productId) {
        for (Product product : inventory) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null; // Return null if product is not found
    }

    // Add product to user's cart
    public void addProductToCart(UserShoppingCart cart, Product product) {
        cart.addToCart(product);
    }

    // Checkout method
    public void checkout(UserShoppingCart cart) {
        cart.checkout();
    }

    public List<Product> getInventory() {
        return inventory;
    }
}