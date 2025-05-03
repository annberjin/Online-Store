import java.util.List;
// SUBCLASS
public class ClothingProduct extends Product {
  private String size;
  private String material;
  private List<String> avalColors;

  public ClothingProduct() {
    super();
    this.size = "";
    this.material = "";
    this.avalColors = List.of();
  }

  public ClothingProduct(String productId, String name, String description, double price, 
                         String size, String material, List<String> avalColors) {
    super(productId, name, description, price);
    this.size = size;
    this.material = material;
    this.avalColors = avalColors;
  }

  // Getter methods
  public String getSize() {
    return size;
  }

  public String getMaterial() {
    return material;
  }

  public List<String> getAvalColors() {
    return avalColors;
  }

  // Setter methods
  public void setSize(String size) {
    this.size = size;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public void setAvalColors(List<String> avalColors) {
    this.avalColors = avalColors;
  }

  // OVERRIDING method
  @Override
  public String toString() {
    return super.toString() + "\n"
           + "Size: " + size + "\n"
           + "Material: " + material + "\n"
           + "Available Colors: " + String.join(", ", avalColors);
  }
}