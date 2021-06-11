package in.karthika.service;

import java.time.LocalDate;
import java.util.List;

import in.karthika.dao.CartData;
import in.karthika.dao.PlantData;
import in.karthika.exceptions.CannotDeletePlantException;
import in.karthika.exceptions.InvalidNumberException;
import in.karthika.exceptions.NumberCannotBeNegativeException;
import in.karthika.exceptions.PlantNotExistException;
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
	 */
	public static boolean addtoCart(String plantName) throws Exception {
		boolean isAdd = false;
		boolean exist = checkCart(plantName);
		double price = 0;
		for (Plant add : PlantData.plantDetails()) {
			if (add.getPlantName().equalsIgnoreCase(plantName.trim())) {
				price = add.getPrice();
				break;
			}
		}
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
	 * @throws PlantNotExistException
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
	 * @throws PlantNotExistException
	 */
	public static boolean addQauantity(String qnty, String plantName)
			throws NumberCannotBeNegativeException, InvalidNumberException {
		boolean isPositive = NumberValidate.positiveNumberValidate(qnty);
		int quantity = Integer.parseInt(qnty);
		List<Cart> cartPlant = CartData.getCart();
		boolean isAdded = false;
		for (Cart cart : CartData.getCart()) {
			if (cart.getPlantName().equalsIgnoreCase(plantName.trim()) && isPositive) {
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
	 * @throws CannotDeletePlantException
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

	/**
	 * This method is used to store all the purchased plant details
	 * 
	 * @param phoneNumber
	 * @throws Exception
	 */
	public static void storeAllOrderPlants(String phoneNumber) throws Exception {
		String customerId = UserService.getUserId(phoneNumber);
		LocalDate orderDate = LocalDate.now();
		List<Cart> orderItems = CartData.getCart();
		for (Cart cart : orderItems) {
			String plantName = cart.getPlantName();
			double cost = cart.getPrice();
			int quantity = cart.getQuantity();
			double priceOfaPlant = cart.getAmountForAplant();
			Cart cartItems = new Cart(customerId, plantName, orderDate, cost, quantity, priceOfaPlant);
			CartData.save(cartItems);
		}

	}

	/**
	 * This method is used to delete all plants in cart
	 */
	public static void clearCart() {
		List<Cart> cartList = CartData.getCart();
		cartList.removeAll(cartList);

	}

	/**
	 * This method id used to get the ordered items
	 * 
	 * @param mobileNumber
	 * @return
	 * @throws Exception
	 */
	public static List<Cart> getOrderItems(String mobileNumber) throws Exception {
		String customerId = UserService.getUserId(mobileNumber);
		return CartData.getOrderDetailsByOrderId(customerId);

	}

}
