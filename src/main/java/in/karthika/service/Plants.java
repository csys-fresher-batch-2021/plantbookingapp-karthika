package in.karthika.service;
import java.util.ArrayList;
import java.util.List;

public class Plants {
	private Plants() {
		/**
		 * constructor
		 */
	}
	private static final String Fruit = "Fruit";
	private static final String Tree = "Tree";
	private static final String Flower = "Flower";
	private static final String Plant = "Plant";
	private static final String Vegetable = "Vegetable";

	private static List<PlantContainer> plantList = new ArrayList<PlantContainer>();

    static {
    	
    	plantList.add(new PlantContainer("Neem Tree",60,Tree,null));
    	plantList.add(new PlantContainer("Mango Tree",40,Tree,Fruit));
    	plantList.add(new PlantContainer("Pappaya Tree",45,Tree,Fruit));
    	plantList.add(new PlantContainer("Guava Tree",70,Tree,Fruit));
    	plantList.add(new PlantContainer("Apple Tree",100,Tree,Fruit));
    	plantList.add(new PlantContainer("Lemon Tree",40,Tree,Fruit));
    	plantList.add(new PlantContainer("Coocnut Tree",50,Tree,Vegetable));
    	plantList.add(new PlantContainer("Rose",100,Plant,Flower));
    	plantList.add(new PlantContainer("Tulip",120,Plant,Flower));
    	plantList.add(new PlantContainer("Lily",130,Plant,Flower));
    	plantList.add(new PlantContainer("Jasmine",140,Plant,Flower));
    	plantList.add(new PlantContainer("Sunflower",100,Plant,Flower));
    	plantList.add(new PlantContainer("Lotus",90,Plant,Flower));
    	plantList.add(new PlantContainer("Daisy",80,Plant,Flower));
    	plantList.add(new PlantContainer("Onion",60,Plant,Vegetable));
    	plantList.add(new PlantContainer("Tomato",30,Plant,Vegetable));
    	plantList.add(new PlantContainer("Carrot",40,Plant,Vegetable));
    	plantList.add(new PlantContainer("Pea",50,Plant,Vegetable));
    	plantList.add(new PlantContainer("Potato",70,Plant,Vegetable));
    	plantList.add(new PlantContainer("Radish",40,Plant,Vegetable));
    	plantList.add(new PlantContainer("Mushroom",130,null,Vegetable));
    	plantList.add(new PlantContainer("Capcicum",100,Plant,Vegetable));
    	plantList.add(new PlantContainer("Pepper",30,Plant,Vegetable));
    	
    }
    
    public static List<PlantContainer> getPlants() {
    	return plantList;
    }

}
