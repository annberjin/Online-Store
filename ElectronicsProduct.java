public class ElectronicsProduct extends Product {
  // SUBCLASS
  private String brand;
  private String model;
  private int warranty;

  public ElectronicsProduct() {
    super();
    brand = "";
    model = "";
    warranty = 0;
  }

  public ElectronicsProduct(String productId, String name, String description, double price, String brand, 
                            String model, int warranty) {
    super(productId, name, description, price); 
    this.brand = brand;
    this.model = model;
    this.warranty = warranty;
  }

  // Getter methods
  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public int getWarranty() {
    return warranty;
  }

  // Setter methods
  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setWarranty(int warranty) {
    this.warranty = warranty;
  }

  @Override
  public String toString() {
    return super.toString() + "\n"
           + "Brand: " + brand + "\n"
           + "Model: " + model + "\n"
           + "Warranty Period: " + warranty + " months";
  }
}