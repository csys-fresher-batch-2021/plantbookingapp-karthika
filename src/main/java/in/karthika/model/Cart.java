package in.karthika.model;

public class Cart {

	private String plantName;
	private double price;
	private int quantity = 0;

	/**
	 * Constructor with 3 parameters
	 * 
	 * @param name
	 * @param amount
	 * @param quantity
	 */
	public Cart(String name, double amount, int quantity) {
		this.plantName = name;
		this.price = amount;
		this.quantity = quantity;
	}

	/**
	 * Constructor with 2 parameters
	 * 
	 * @param name
	 * @param amount
	 */

	public Cart(String name, double amount) {
		this.plantName = name;
		this.price = amount;
	}

	/**
	 * This method is used to return plant's name
	 * 
	 * @return
	 */
	public String getPlantName() {
		return plantName;
	}

	/**
	 * This method is used to return plant's price
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * This method is used to return Quantity
	 * 
	 * @return
	 */

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Cart [plantName=" + plantName + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
