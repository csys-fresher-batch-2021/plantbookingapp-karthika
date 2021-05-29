package in.karthika.service;

import java.util.List;

import in.karthika.dao.CartData;
import in.karthika.dao.PlantData;
import in.karthika.model.Cart;
import in.karthika.model.Plant;
import in.karthika.validate.PlantValidate;

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
	 * This method is used to check whether the plant is already present in the cart
	 * or not
	 * 
	 * @param plantName
	 * @return
	 */
	public static boolean checkCart(String plantName) {
		boolean check = false;
		for (Cart add : CartData.getCart()) {
			if (add.getPlantName().equalsIgnoreCase(plantName.trim())) {
				check = true;
				break;
			}
		}
		return check;

	}

	/**
	 * This method is used to add the quantity to cart
	 * 
	 * @param qnty
	 * @param plantName
	 * @return
	 */
	public static boolean addQauantity(String qnty, String plantName) {
		int quantity = Integer.parseInt(qnty);
		List<Cart> cartPlant = CartData.getCart();
		boolean isAdded = false;
		boolean check = PlantValidate.checkQuantity(quantity);
		for (Cart cart : CartData.getCart()) {
			if (cart.getPlantName().equalsIgnoreCase(plantName.trim()) && check) {
				double price = cart.getPrice();
				cartPlant.remove(cart);
				CartData.addCart(plantName, price, quantity);
				isAdded = true;
				break;
			}
		}
		return isAdded;
	}

}
