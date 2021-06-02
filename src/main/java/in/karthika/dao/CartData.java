package in.karthika.dao;

import java.util.ArrayList;
import java.util.List;

import in.karthika.model.Cart;

public class CartData {

	private CartData() {
		/**
		 * constructor
		 */
	}

	/*
	 * Create array list to store all Cart details
	 */
	private static List<Cart> cartPlants = new ArrayList<>();

	/**
	 * This method is used to store plants which is in user cart
	 * 
	 * @param plantName
	 * @param price
	 * @param priceOfAplan
	 * @param quantity
	 */

	public static void addCart(String plantName, double price) {
		cartPlants.add(new Cart(plantName, price));
	}

	/**
	 * This method is used to store the plants which is in user cart with quantity
	 * 
	 * @param plantName
	 * @param price
	 * @param quantity
	 */
	public static void addCart(String plantName, double price, int quantity, double priceOfAplan) {
		cartPlants.add(new Cart(plantName, price, quantity, priceOfAplan));

	}

	/**
	 * This method is used to return cart details
	 * 
	 * @return
	 */
	public static List<Cart> getCart() {
		return cartPlants;
	}

}
