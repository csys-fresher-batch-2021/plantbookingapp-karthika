package in.karthika.service;

import java.util.ArrayList;

public class Plants {

	private static ArrayList<PlantContainer> plantList = new ArrayList<PlantContainer>();
	public static void addProduct(PlantContainer ...plant) {
		for(PlantContainer addplant:plant) {
			plantList.add(addplant);
		}
		
	}

    static {
    	
    	PlantContainer plant1 = new PlantContainer();
		plant1.plantName = "Neem Tree";
		plant1.price = 60 ;
		plant1.plantType="Tree";
		
		PlantContainer plant2 = new PlantContainer();
		plant2.plantName = "Mango Tree";
		plant2.price = 40 ;
		plant2.plantType="Tree";
		plant2.category="Fruit";
		
		PlantContainer plant3 = new PlantContainer();
		plant3.plantName = "Pappaya Tree";
		plant3.price = 45 ;
		plant3.plantType="Tree";
		plant3.category="Fruit";
		
		PlantContainer plant4 = new PlantContainer();
		plant4.plantName = "Guava Tree";
		plant4.price = 70 ;
		plant4.plantType="Tree";
		plant4.category="Fruit";
		
		PlantContainer plant5 = new PlantContainer();
		plant5.plantName = "Apple Tree";
		plant5.price = 100 ;
		plant5.plantType="Tree";
		plant5.category="Fruit";
		
		PlantContainer plant6 = new PlantContainer();
		plant6.plantName = "Lemon Tree";
		plant6.price = 40 ;
		plant6.plantType="Tree";
		plant6.category="Fruit";
		
		PlantContainer plant7 = new PlantContainer();
		plant7.plantName = "Coconut Tree";
		plant7.price = 50 ;
		plant7.plantType="Tree";
		plant7.category="Vegetable";
		
		PlantContainer plant8 = new PlantContainer();
		plant8.plantName = "Rose";
		plant8.price = 100 ;
		plant8.plantType="plant";
		plant8.category="Flower";
		
		PlantContainer plant9 = new PlantContainer();
		plant9.plantName = "Tulip";
		plant9.price = 120 ;
		plant9.plantType="plant";
		plant9.category="Flower";
		
		
		PlantContainer plant10 = new PlantContainer();
		plant10.plantName = "Lily";
		plant10.price = 130 ;
		plant10.plantType="plant";
		plant10.category="Flower";
		
		PlantContainer plant11 = new PlantContainer();
		plant11.plantName = "Jasmine";
		plant11.price = 140 ;
		plant11.plantType="plant";
		plant11.category="Flower";
		
		PlantContainer plant12 = new PlantContainer();
		plant12.plantName = "Sunflower";
		plant12.price = 100 ;
		plant12.plantType="plant";
		plant12.category="Flower";
		
		PlantContainer plant13 = new PlantContainer();
		plant13.plantName = "Lotus";
		plant13.price = 90 ;
		plant13.plantType="plant";
		plant13.category="Flower";
		
		PlantContainer plant14 = new PlantContainer();
		plant14.plantName = "Daisy";
		plant14.price = 80 ;
		plant14.plantType="plant";
		plant14.category="Flower";
		
		PlantContainer plant15 = new PlantContainer();
		plant15.plantName = "Onion";
		plant15.price = 60 ;
		plant15.plantType="plant";
		plant15.category="Vegetable";
		
		PlantContainer plant16 = new PlantContainer();
		plant16.plantName = "Tomato";
		plant16.price = 30 ;
		plant16.plantType="plant";
		plant16.category="Vegetable";
		
		PlantContainer plant17 = new PlantContainer();
		plant17.plantName = "carrot";
		plant17.price = 40 ;
		plant17.plantType="plant";
		plant17.category="Vegetable";
		
		PlantContainer plant18 = new PlantContainer();
		plant18.plantName = "Pea";
		plant18.price = 50 ;
		plant18.plantType="plant";
		plant18.category="Vegetable";
		
		PlantContainer plant19 = new PlantContainer();
		plant19.plantName = "Potato";
		plant19.price = 70 ;
		plant19.plantType="plant";
		plant19.category="Vegetable";
		
		PlantContainer plant20 = new PlantContainer();
		plant20.plantName = "Radish";
		plant20.price = 40 ;
		plant20.plantType="plant";
		plant20.category="Vegetable";
		
		PlantContainer plant21 = new PlantContainer();
		plant21.plantName = "Mushroom";
		plant21.price = 120 ;
		plant21.category="Vegetable";
		
		PlantContainer plant22 = new PlantContainer();
		plant22.plantName = "Capcicum";
		plant22.price = 100 ;
		plant22.plantType="plant";
		plant22.category="Vegetable";
		
		PlantContainer plant23 = new PlantContainer();
		plant23.plantName = "Pepper";
		plant23.price = 30 ;
		plant23.plantType="plant";
		plant23.category="Vegetable";
		
		Plants.addProduct(plant1, plant2, plant3, plant4, plant5, plant6, plant7, plant8, plant9, plant10, plant11, plant12, plant13, plant14, plant15, plant16, plant17, plant18, plant19, plant20, plant21, plant22, plant23);
	}
    
    public static ArrayList<PlantContainer> getPlants() {
    	return plantList;
    }

}
