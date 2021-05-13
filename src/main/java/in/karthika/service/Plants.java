package in.karthika.service;
import java.util.ArrayList;
import java.util.List;

public class Plants {
	private Plants() {
		/**
		 * constructor
		 */
	}
	private static final String FRUIT = "Fruit";
	private static final String TREE = "Tree";
	private static final String FLOWER = "Flower";
	private static final String PLANT = "Plant";
	private static final String VEGETABLE = "Vegetable";

	private static List<PlantContainer> plantList = new ArrayList<>();

    static {
    	
    	plantList.add(new PlantContainer("Neem Tree",60,TREE,null));
    	plantList.add(new PlantContainer("Mango Tree",40,TREE,FRUIT));
    	plantList.add(new PlantContainer("Pappaya Tree",45,TREE,FRUIT));
    	plantList.add(new PlantContainer("Guava Tree",70,TREE,FRUIT));
    	plantList.add(new PlantContainer("Apple Tree",100,TREE,FRUIT));
    	plantList.add(new PlantContainer("Lemon Tree",40,TREE,FRUIT));
    	plantList.add(new PlantContainer("Coocnut Tree",50,TREE,VEGETABLE));
    	plantList.add(new PlantContainer("Rose",100,PLANT,FLOWER));
    	plantList.add(new PlantContainer("Tulip",120,PLANT,FLOWER));
    	plantList.add(new PlantContainer("Lily",130,PLANT,FLOWER));
    	plantList.add(new PlantContainer("Jasmine",140,PLANT,FLOWER));
    	plantList.add(new PlantContainer("Sunflower",100,PLANT,FLOWER));
    	plantList.add(new PlantContainer("Lotus",90,PLANT,FLOWER));
    	plantList.add(new PlantContainer("Daisy",80,PLANT,FLOWER));
    	plantList.add(new PlantContainer("Onion",60,PLANT,VEGETABLE));
    	plantList.add(new PlantContainer("Tomato",30,PLANT,VEGETABLE));
    	plantList.add(new PlantContainer("Carrot",40,PLANT,VEGETABLE));
    	plantList.add(new PlantContainer("Pea",50,PLANT,VEGETABLE));
    	plantList.add(new PlantContainer("Potato",70,PLANT,VEGETABLE));
    	plantList.add(new PlantContainer("Radish",40,PLANT,VEGETABLE));
    	plantList.add(new PlantContainer("Mushroom",130,null,VEGETABLE));
    	plantList.add(new PlantContainer("Capcicum",100,PLANT,VEGETABLE));
    	plantList.add(new PlantContainer("Pepper",30,PLANT,VEGETABLE));
    	
    }
    
    public static List<PlantContainer> getPlants() {
    	return plantList;
    }

}
