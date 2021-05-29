package in.karthika.model;

import java.time.LocalDate;
import java.util.List;

public class Bill {

	private String orderId;
	private String customerName;
	private long mobileNumber;
	private LocalDate orderData;
	private LocalDate deliveryDate;
	private double totalBill;
	private List<Cart> orderedPlantDetails;

	/**
	 * Default Constructor
	 */
	public Bill() {
		/**
		 * Constructor
		 */
	}

	/**
	 * Constructor
	 * 
	 * @param orderId
	 * @param customerName
	 * @param mobileNumber
	 * @param todayDate
	 * @param deliveryDate2
	 * @param totalBill
	 * @param orderedPlantDetails
	 */

	public Bill(String orderId, String customerName, long mobileNumber, LocalDate todayDate, LocalDate deliveryDate2,
			double totalBill, List<Cart> orderedPlantDetails) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.orderData = todayDate;
		this.deliveryDate = deliveryDate2;
		this.totalBill = totalBill;
		this.orderedPlantDetails = orderedPlantDetails;
	}

	/**
	 * This method is used to return orderId
	 * 
	 * @return
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * This method is used to Customer's name
	 * 
	 * @return
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * This method is used to return customer's mobile number
	 * 
	 * @return
	 */
	public long getMobileNumber() {
		return mobileNumber;

	}

	/**
	 * This method is used to return order date
	 * 
	 * @return
	 */
	public LocalDate getOrderDate() {
		return orderData;

	}

	/**
	 * This method is used to get the delivery date
	 * 
	 * @return
	 */
	public LocalDate getDeliveryDate() {
		return deliveryDate;

	}

	/**
	 * This method is used to get the bill
	 * 
	 * @return
	 */

	public double getBill() {
		return totalBill;

	}

	/**
	 * This method is used to return all items which is ordered by the user
	 * 
	 * @return
	 */
	public List<Cart> getOrderPlants() {
		return orderedPlantDetails;

	}

	@Override
	public String toString() {
		return "Bill [orderId=" + orderId + ", customerName=" + customerName + ", mobileNumber=" + mobileNumber
				+ ", orderData=" + orderData + ", deliveryDate=" + deliveryDate + ", totalBill=" + totalBill
				+ ", orderedPlantDetails=" + orderedPlantDetails + "]";
	}

}
