package in.karthika.model;

public class Plant {

	private String plantName;
	private double price;
	private String plantType;
	private String category;

	/**
	 * Constructor 
	 * 
	 * @param name
	 * @param amount
	 * @param type
	 * @param category
	 */
	public Plant(String name, double amount, String type, String category) {
		this.plantName = name;
		this.price = amount;
		this.plantType = type;
		this.category = category;
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
	 * @return the plantType
	 */
	public String getPlantType() {
		return plantType;
	}

	/**
	 * @param plantType the plantType to set
	 */
	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "PlantContainer [plantName=" + plantName + ", price=" + price + ", plantType=" + plantType
				+ ", category=" + category + "]";
	}
}
