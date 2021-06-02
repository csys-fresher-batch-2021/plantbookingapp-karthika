package in.karthika.service;

import java.time.LocalDate;
import java.util.List;

import in.karthika.dao.BillData;
import in.karthika.dao.CartData;
import in.karthika.model.Cart;

public class BillService {
	
	private BillService() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used to generate the bill details
	 * 
	 * @param phoneNumber
	 * @param userName
	 * @return
	 */
	public static boolean storeBillDetails(String phoneNumber, String userName) {
		long mobileNumber = Long.parseLong(phoneNumber);
		LocalDate todayDate = LocalDate.now();
		LocalDate deliveryDate = todayDate.plusDays(3);
		String orderId = getOrderId(userName, phoneNumber);
		List<Cart> cartDetails = CartData.getCart();
		double totalBill = generateBill(cartDetails);
		BillData.addCart(orderId, userName, mobileNumber, todayDate, deliveryDate, totalBill, cartDetails);
		return true;
	}

	/**
	 * This method is used to get generate the total bill
	 * 
	 * @param cartDetails
	 * @return
	 */
	private static double generateBill(List<Cart> cartDetails) {
		double total = 0;
		for (Cart cart : cartDetails) {
			total = total + (cart.getQuantity() * cart.getPrice());
		}
		return total;
	}

	/**
	 * This method is used to get the order id
	 * 
	 * @param userName
	 * @param phoneNumber
	 * @return
	 */
	private static String getOrderId(String userName, String phoneNumber) {
		String name = userName.substring(0, 4);
		return name + phoneNumber;
	}

}
