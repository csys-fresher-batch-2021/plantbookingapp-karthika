package in.karthika.service;

import in.karthika.dao.PlantData;
import in.karthika.model.Plant;

public class PlantService {

	public static boolean checkPlant(String plantname, String price, String type, String category) {
		boolean isAdd = false;
		boolean exist=false;
		for (Plant add : PlantData.getPlants()) {
			if (add.getPlantName().equalsIgnoreCase(plantname.trim())) {
				exist =true;
				break;
			}
		}
		if(exist==false) {
			isAdd= addPlants(plantname, price, type, category);
		}
		return isAdd;
	}
	
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

