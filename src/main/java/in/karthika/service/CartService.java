package in.karthika.service;

import in.karthika.dao.CartData;
import in.karthika.dao.PlantData;
import in.karthika.model.Cart;
import in.karthika.model.Plant;

public class CartService {

	private CartService() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used to add the plants to cart
	 * 
	 * @param plantName
	 * @return
	 */
	public static boolean addtoCart(String plantName) {
		boolean isAdd = false;
		boolean exist = false;
		double price = 0;
		for (Plant add : PlantData.getPlants()) {
			if (add.getPlantName().equalsIgnoreCase(plantName.trim())) {
				price = add.getPrice();
				break;
			}
		}
		exist = checkCart(plantName);
		if (!exist) {
			CartData.addCart(plantName, price);
			isAdd = true;
		}
		return isAdd;
	}
	
	/**
	 * This method is used to check whether the plant is already present in the cart or not 
	 * @param plantName
	 * @return
	 */
	public static boolean checkCart(String plantName) {
		boolean check=false;
		for (Cart add : CartData.getCart()) {
			if (add.getPlantName().equalsIgnoreCase(plantName.trim())) {
				check= true;
				break;
			}
		}
		return check;
		
	}

}
