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

	public static void addCart(String plantName, double price) {
		cartPlants.add(new Cart(plantName,price));
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
