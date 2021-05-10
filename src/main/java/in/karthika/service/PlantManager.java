package in.karthika.service;


public class PlantManager {
	
	public static void displayAllPlants() {
		System.out.println("PLANTS IN STOCK");
		for (PlantContainer plant : Plants.getPlants()) {
			System.out.println(plant.plantName + "   Rs." + plant.price);
	    }
	}

}
