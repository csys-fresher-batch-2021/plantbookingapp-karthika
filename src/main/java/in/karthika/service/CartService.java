package in.karthika.service;

import in.karthika.dao.CartData;
import in.karthika.model.Cart;

public class CartService {

	public static boolean addtoCart(String plantName) {
		boolean isAdd = false;
		boolean exist = false;
		double price = 0;
		for (Cart add : CartData.getCart()) {
			if (add.getPlantName().equalsIgnoreCase(plantName.trim())) {
				price = add.getPrice();
				exist = true;
				break;
			}
		}
		if (!exist) {
			CartData.addCart(plantName, price);
			isAdd = true;
		}
		return isAdd;
	}

}
