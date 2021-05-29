package in.karthika.model;

public class Cart {

	private String plantName;
	private double price;
	private int quantity=0;

	public Cart(String name, double amount,int quantity) {
		this.plantName = name;
		this.price = amount;
		this.quantity = quantity;
	}


	public Cart(String name, double amount) {
		this.plantName = name;
		this.price = amount;
	}


	public String getPlantName() {
		return plantName;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Cart [plantName=" + plantName + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
