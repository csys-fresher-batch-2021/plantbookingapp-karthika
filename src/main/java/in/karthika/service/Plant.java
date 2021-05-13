package in.karthika.service;

public class Plant {
	
	private String plantName;
	private double price;
	private String plantType;
	private String category;
	
	public Plant(String name,double amount,String type,String category){
		this.plantName=name;
		this.price=amount;
		this.plantType=type;
		this.category=category;
	}
	
	public Plant(String name,double amount,String category){
		this.plantName=name;
		this.price=amount;
		this.category=category;
	}
	
	
	public String getPlantName() {
		return plantName;
	}
	public double getPrice() {
		return price;
	}
	public String getPlantType() {
		return plantType;
	}
	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "PlantContainer [plantName=" + plantName + ", price=" + price + ", plantType=" + plantType
				+ ", category=" + category + "]";
	}
}
