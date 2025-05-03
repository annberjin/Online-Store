import java.util.ArrayList;
import java.util.List;

public class UserShoppingCart implements ShoppingCart {
    private String userId;
    private List<Product> cart;

    public UserShoppingCart(String userId) {
        this.userId = userId;
        this.cart = new ArrayList<>();
    }

    // Overloaded method to handle adding ElectronicsProduct
    public void addToCart(ElectronicsProduct electronicsProduct) {
      cart.add(electronicsProduct);
      System.out.println(electronicsProduct.getName() + " has been added to " + userId + "'s cart.");
  }

  // Overloaded method to handle adding ClothingProduct
  public void addToCart(ClothingProduct clothingProduct) {
      cart.add(clothingProduct);
      System.out.println(clothingProduct.getName() + " has been added to " + userId + "'s cart.");
  }

  // Generic method to handle adding any Product (Base Class)
  public void addToCart(Product product) {
      cart.add(product);
      System.out.println(product.getName() + " has been added to " + userId + "'s cart.");
  }

    // Checkout method to calculate total price and display items
    //OVERRIDING USED HERE
    @Override
    public void checkout() {
        double totalPrice = 0.0;
        System.out.println(userId + "'s Shopping Cart:");
        for (Product product : cart) {
            System.out.println(product.toString());
            totalPrice += product.getPrice();
        }
        System.out.println("Total Price: $" + totalPrice);
    }

    // Getter for userId
    public String getUserId() {
        return userId;
    }
}