package in.karthika.service;
import java.util.ArrayList;
import java.util.List;

public class PlantService {
	
	private PlantService() {
		/**
		 * constructor
		 */
	}
	
	/**
	 * Create constant 
	 */
	private static final String FRUIT = "Fruit";
	private static final String TREE = "Tree";
	private static final String FLOWER = "Flower";
	private static final String PLANT = "Plant";
	private static final String VEGETABLE = "Vegetable";
	private static final String MEDICINAL = "Medicinal";

	/*
	 * Create array list to store all plats
	 */
	private static List<Plant> plantList = new ArrayList<>();

    static {
    	
    	plantList.add(new Plant("Neem Tree",60,TREE,MEDICINAL));
    	plantList.add(new Plant("Mango Tree",40,TREE,FRUIT));
    	plantList.add(new Plant("Pappaya Tree",45,TREE,FRUIT));
    	plantList.add(new Plant("Guava Tree",70,TREE,FRUIT));
    	plantList.add(new Plant("Apple Tree",100,TREE,FRUIT));
    	plantList.add(new Plant("Lemon Tree",40,TREE,FRUIT));
    	plantList.add(new Plant("Coocnut Tree",50,TREE,VEGETABLE));
    	plantList.add(new Plant("Rose",100,PLANT,FLOWER));
    	plantList.add(new Plant("Tulip",120,PLANT,FLOWER));
    	plantList.add(new Plant("Lily",130,PLANT,FLOWER));
    	plantList.add(new Plant("Jasmine",140,PLANT,FLOWER));
    	plantList.add(new Plant("Sunflower",100,PLANT,FLOWER));
    	plantList.add(new Plant("Lotus",90,PLANT,FLOWER));
    	plantList.add(new Plant("Daisy",80,PLANT,FLOWER));
    	plantList.add(new Plant("Onion",60,PLANT,VEGETABLE));
    	plantList.add(new Plant("Tomato",30,PLANT,VEGETABLE));
    	plantList.add(new Plant("Carrot",40,PLANT,VEGETABLE));
    	plantList.add(new Plant("Pea",50,PLANT,VEGETABLE));
    	plantList.add(new Plant("Potato",70,PLANT,VEGETABLE));
    	plantList.add(new Plant("Radish",40,PLANT,VEGETABLE));
    	plantList.add(new Plant("Mushroom",130,VEGETABLE));
    	plantList.add(new Plant("Capcicum",100,PLANT,VEGETABLE));
    	plantList.add(new Plant("Tulsi",50,PLANT,MEDICINAL));
    	plantList.add(new Plant("Pepper",30,PLANT,VEGETABLE));
    	
    }
    /**
     * This method is used to return plants
     * @return
     */
    public static List<Plant> getPlants() {
    	return plantList;
    }

}
