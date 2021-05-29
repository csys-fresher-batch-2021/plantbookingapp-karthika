package in.karthika.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.karthika.model.Bill;
import in.karthika.model.Cart;

public class BillData {

	private BillData() {
		/**
		 * Constructor
		 */
	}

	/*
	 * Array list to store all customers bill details
	 */

	private static List<Bill> billDetails = new ArrayList<>();

	/**
	 * This method used to add all customers bill details
	 * 
	 * @param orderId
	 * @param customerName
	 * @param mobileNumber
	 * @param todayDate
	 * @param deliveryDate
	 * @param totalBill
	 * @param orderedPlantDetails
	 */

	public static void addCart(String orderId, String customerName, long mobileNumber, LocalDate todayDate,
			LocalDate deliveryDate, double totalBill, List<Cart> orderedPlantDetails) {
		billDetails.add(
				new Bill(orderId, customerName, mobileNumber, todayDate, deliveryDate, totalBill, orderedPlantDetails));
	}

	/**
	 * This method is used to return all customers bill details
	 * 
	 * @return
	 */
	public static List<Bill> getBill() {
		return billDetails;
	}

}
