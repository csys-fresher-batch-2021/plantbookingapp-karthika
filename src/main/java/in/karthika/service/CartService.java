package in.karthika.service;

import java.sql.SQLException;
import java.util.List;

import in.karthika.dao.CartData;
import in.karthika.dao.PlantData;
import in.karthika.exceptions.InvalidNumberException;
import in.karthika.exceptions.NumberCannotBeNegativeException;
import in.karthika.model.Cart;
import in.karthika.model.Plant;
import in.karthika.util.NumberValidate;

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
	 * @throws Exception
	 * @throws SQLException
	 */
	public static boolean addtoCart(String plantName) throws Exception {
		boolean isAdd = false;
		boolean exist = false;
		double price = 0;
		for (Plant add : PlantData.plantDetails()) {
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
	 * @throws InvalidNumberException
	 * @throws NumberCannotBeNegativeException
	 */
	public static boolean addQauantity(String qnty, String plantName) throws NumberCannotBeNegativeException {
		int quantity = Integer.parseInt(qnty);
		List<Cart> cartPlant = CartData.getCart();
		boolean isAdded = false;
		boolean check = NumberValidate.positiveNumberValidate(qnty);
		for (Cart cart : CartData.getCart()) {
			if (cart.getPlantName().equalsIgnoreCase(plantName.trim()) && check) {
				double price = cart.getPrice();
				cartPlant.remove(cart);
				double priceOfAplan = price * quantity;
				CartData.addCart(plantName, price, quantity, priceOfAplan);
				isAdded = true;
				break;
			}
		}
		return isAdded;
	}

	/**
	 * This method is used to delete the plant in the cart
	 * 
	 * @param plantName
	 * @return
	 */

	public static boolean deletePlant(String plantName) {
		boolean delete = false;
		int i = -1;
		List<Cart> cartList = CartData.getCart();
		for (Cart plant : CartData.getCart()) {
			i++;
			if (plant.getPlantName().equalsIgnoreCase(plantName.trim())) {
				cartList.remove(i);
				delete = true;
				break;
			}
		}
		return delete;
	}

}
