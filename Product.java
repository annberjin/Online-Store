public class Product {
  // SUPERCLASS
  private String productId;
  private String name;
  private String description;
  private double price;

  // Default constructor
  public Product() {
    productId = "";
    name = "";
    description = "";
    price = 0.0;
  }

  public Product(String productId, String name, String description, double price) {
    this.productId = productId;
    this.name = name;
    this.description = description;
    this.price = price;
  }

  // Getter methods
  public String getProductId() {
    return productId;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  // Setter methods
  public void setProductId(String productId) {
    this.productId = productId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String toString() {
    return "Product ID: " + productId + "\n"
         + "Name: " + name + "\n"
         + "Description: " + description + "\n"
         + "Price: $" + price;
  }
}