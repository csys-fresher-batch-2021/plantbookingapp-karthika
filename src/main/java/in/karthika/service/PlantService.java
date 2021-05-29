package in.karthika.service;

import java.util.List;

import in.karthika.dao.PlantData;
import in.karthika.model.Plant;

public class PlantService {
	private PlantService() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used to check whether the plant is present or not If it is not
	 * present it will add to the plant stock
	 * 
	 * @param plantname
	 * @param price
	 * @param type
	 * @param category
	 * @return
	 */
	public static boolean checkPlant(String plantname, String price, String type, String category) {
		boolean isAdd = false;
		boolean exist = false;
		double amount = Double.parseDouble(price);
		for (Plant add : PlantData.getPlants()) {
			if (add.getPlantName().equalsIgnoreCase(plantname.trim())) {
				exist = true;
				break;
			}
		}
		if (!exist && amount > 0) {
			isAdd = addPlants(plantname, amount, type, category);
		}
		return isAdd;
	}

	/**
	 * This method is used to add the plant to stock
	 * 
	 * @param plantname
	 * @param price
	 * @param type
	 * @param category
	 * @return
	 */
	private static boolean addPlants(String plantname, double price, String type, String category) {
		if (type.trim().equalsIgnoreCase("others")) {
			PlantData.plantAdd2(plantname, price, category);
		} else {
			PlantData.plantAdd1(plantname, price, type, category);
		}
		return true;
	}

	/**
	 * This method is used to delete the plant from the stock
	 * 
	 * @param plantName
	 * @return
	 */
	public static boolean deletePlant(String plantName) {
		boolean delete = false;
		int i = -1;
		List<Plant> plantList = PlantData.getPlants();
		for (Plant add : PlantData.getPlants()) {
			i++;
			if (add.getPlantName().equalsIgnoreCase(plantName.trim())) {
				plantList.remove(i);
				delete = true;
				break;
			}
		}
		return delete;
	}

	/**
	 * This method used to filter the plants
	 * 
	 * @param filter
	 * @return
	 */
	public static boolean filterPlants(String filter) {
		boolean isAdd = false;
		List<Plant> filterPlant = PlantData.getFilterPlants();
		filterPlant.removeAll(filterPlant);
		for (Plant plant : PlantData.getPlants()) {
			if (plant.getPlantType() != null && plant.getPlantType().equalsIgnoreCase(filter)
					&& !plantExsist(plant.getPlantName())) {
				filterPlant.add(plant);
				isAdd = true;
			} else if (plant.getCategory() != null && plant.getCategory().equalsIgnoreCase(filter)
					&& !plantExsist(plant.getPlantName())) {
				filterPlant.add(plant);
				isAdd = true;
			} else if (filter.trim().equals("1") && plant.getPrice() <= 100 && !plantExsist(plant.getPlantName())) {
				filterPlant.add(plant);
				isAdd = true;
			} else if (filter.trim().equals("2") && plant.getPrice() > 100 && plant.getPrice() <= 200
					&& !plantExsist(plant.getPlantName())) {
				filterPlant.add(plant);
				isAdd = true;
			}
		}

		return isAdd;
	}

	
	public static boolean plantExsist(String plantName) {
		boolean isExsist = false;
		for (Plant plant : PlantData.getFilterPlants()) {
			if (plant.getPlantName().equalsIgnoreCase(plantName)) {
				isExsist = true;
			}
		}
		return isExsist;
	}
}
