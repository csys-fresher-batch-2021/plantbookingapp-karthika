package in.karthika.service;

import in.karthika.dao.PlantData;
import in.karthika.model.Plant;

public class PlantService {
	private PlantService() {
		/**
		 * Constructor
		 */
	}
	

	/**
	 * This method is used to check whether the plant is present or not
	 * If it is not present it will add to the plant stock 
	 * @param plantname
	 * @param price
	 * @param type
	 * @param category
	 * @return
	 */
	public static boolean checkPlant(String plantname, String price, String type, String category) {
		boolean isAdd = false;
		boolean exist=false;
		for (Plant add : PlantData.getPlants()) {
			if (add.getPlantName().equalsIgnoreCase(plantname.trim())) {
				exist =true;
				break;
			}
		}
		if(!exist) {
			isAdd= addPlants(plantname, price, type, category);
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
	private static boolean addPlants(String plantname, String price, String type, String category) {
		double amount=Double.parseDouble(price);
		if(type.trim().equalsIgnoreCase("others")) {
			PlantData.plantAdd2(plantname,amount,category);
		}
		else {
			PlantData.plantAdd1(plantname,amount,type,category);
		}
		return true;
	}

}

