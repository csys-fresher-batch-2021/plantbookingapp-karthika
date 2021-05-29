package in.karthika.service;

import java.time.LocalDate;
import java.util.List;

import in.karthika.dao.BillData;
import in.karthika.dao.CartData;
import in.karthika.model.Cart;

public class BillService {

	/**
	 * This method is used to generate the bill details
	 * 
	 * @param phoneNumber
	 * @param userName
	 * @return
	 */
	public static boolean storeBillDetails(String phoneNumber, String userName) {
		System.out.println(userName);
		long mobileNumber = Long.parseLong(phoneNumber);
		System.out.println(mobileNumber);
		LocalDate todayDate = LocalDate.now();
		System.out.println(todayDate);
		LocalDate deliveryDate = todayDate.plusDays(3);
		System.out.println(deliveryDate);
		String orderId = getOrderId(userName, phoneNumber);
		System.out.println(orderId);
		List<Cart> cartDetails = CartData.getCart();
		for (Cart cart : cartDetails) {
			System.out.println(cart.getPlantName());
			System.out.println(cart.getPrice());
			System.out.println(cart.getQuantity());
		}
		double totalBill = generateBill(cartDetails);
		System.out.println(totalBill);
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
		String orderId = phoneNumber + userName;
		return orderId;
	}

}
