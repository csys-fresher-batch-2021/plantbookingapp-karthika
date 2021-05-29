package in.karthika.model;

public class Plant {

	private String plantName;
	private double price;
	private String plantType;
	private String category;

	/**
	 * Constructor with 4 parameters
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
	 * Constructor with 3 parameters
	 * 
	 * @param name
	 * @param amount
	 * @param category
	 */
	public Plant(String name, double amount, String category) {
		this.plantName = name;
		this.price = amount;
		this.category = category;
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
	 * This method is used to return plant's type
	 * 
	 * @return
	 */
	public String getPlantType() {
		return plantType;
	}

	/**
	 * This method is used to return plant's category
	 * 
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "PlantContainer [plantName=" + plantName + ", price=" + price + ", plantType=" + plantType
				+ ", category=" + category + "]";
	}
}
