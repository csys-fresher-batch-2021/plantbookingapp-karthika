package in.karthika.model;

public class Cart {

	private String plantName;
	private double price;
	private int quantity = 0;
	private double amountForAplant = 0;

	/**
	 * Constructor with 4 parameter
	 * 
	 * @param name
	 * @param amount
	 * @param quantity
	 * @param amountForAplant
	 */
	public Cart(String name, double amount, int quantity, double amountForAplant) {
		this.plantName = name;
		this.price = amount;
		this.quantity = quantity;
		this.amountForAplant = amountForAplant;
	}

	/**
	 * Constructor with 2 parameter
	 * 
	 * @param name
	 * @param amount
	 */
	public Cart(String name, double amount) {
		this.plantName = name;
		this.price = amount;
	}

	/**
	 * @return the plantName
	 */
	public String getPlantName() {
		return plantName;
	}

	/**
	 * @param plantName the plantName to set
	 */
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the amountForAplant
	 */
	public double getAmountForAplant() {
		return amountForAplant;
	}

	/**
	 * @param amountForAplant the amountForAplant to set
	 */
	public void setAmountForAplant(double amountForAplant) {
		this.amountForAplant = amountForAplant;
	}

	@Override
	public String toString() {
		return "Cart [plantName=" + plantName + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
