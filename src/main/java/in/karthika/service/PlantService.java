package in.karthika.service;

import java.sql.SQLException;
import java.util.List;

import in.karthika.dao.PlantData;
import in.karthika.model.Plant;
import in.karthika.validate.PlantDetailsValidate;

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
	 * @throws Exception
	 * @throws SQLException
	 */
	public static boolean addPlant(String plantname, String price, String type, String category) throws Exception {
		boolean isValid = PlantDetailsValidate.checkPlant(plantname, price);
		boolean isAdd = false;
		boolean exist = isPlantExist(plantname);
		double cost = Double.parseDouble(price);
		if (!exist && isValid) {
			Plant plant = new Plant(plantname, cost, type, category);
			isAdd = PlantData.save(plant);
		}
		return isAdd;
	}

	/**
	 * This method is used to check whether the plant is exist in the list or not
	 * 
	 * @param plantName
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */

	public static boolean isPlantExist(String plantName) throws Exception {
		boolean exist = false;
		for (Plant add : PlantData.plantDetails()) {
			if (add.getPlantName().equalsIgnoreCase(plantName.trim())) {
				exist = true;
				break;
			}
		}
		return exist;
	}

	/**
	 * This method is used to delete the plant from the stock
	 * 
	 * @param plantName
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public static boolean deletePlant(String plantName) throws Exception {
		return PlantData.deletePlant(plantName.trim());

	}

	/**
	 * This method used to filter the plants
	 * 
	 * @param filter
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */

	public static boolean filterPlants(String filter) throws Exception {
		boolean isAdd = false;
		List<Plant> filterPlant = PlantData.getFilterPlants();
		filterPlant.removeAll(filterPlant);
		for (Plant plant : PlantData.plantDetails()) {
			if (plant.getPlantType() != null && plant.getPlantType().equalsIgnoreCase(filter)) {
				filterPlant.add(plant);
				isAdd = true;
			} else if (plant.getCategory() != null && plant.getCategory().equalsIgnoreCase(filter)) {
				filterPlant.add(plant);
				isAdd = true;
			} else if (filter.trim().equals("1") && plant.getPrice() <= 100) {
				filterPlant.add(plant);
				isAdd = true;
			} else if (filter.trim().equals("2") && plant.getPrice() > 100 && plant.getPrice() <= 200) {
				filterPlant.add(plant);
				isAdd = true;
			}
		}

		return isAdd;
	}

}
