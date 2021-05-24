package in.karthika.model;

public class Cart {

	private String plantName;
	private double price;
	private double quantity;

	public Cart(String name, double amount) {
		this.plantName = name;
		this.price = amount;
	}

	public Cart(double quantity) {
		this.quantity = quantity;
	}

	public String getPlantName() {
		return plantName;
	}

	public double getPrice() {
		return price;
	}

	public double getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Cart [plantName=" + plantName + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
