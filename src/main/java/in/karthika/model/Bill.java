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
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the mobileNumber
	 */
	public long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the orderData
	 */
	public LocalDate getOrderData() {
		return orderData;
	}

	/**
	 * @param orderData the orderData to set
	 */
	public void setOrderData(LocalDate orderData) {
		this.orderData = orderData;
	}

	/**
	 * @return the deliveryDate
	 */
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return the totalBill
	 */
	public double getTotalBill() {
		return totalBill;
	}

	/**
	 * @param totalBill the totalBill to set
	 */
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	/**
	 * @return the orderedPlantDetails
	 */
	public List<Cart> getOrderedPlantDetails() {
		return orderedPlantDetails;
	}

	/**
	 * @param orderedPlantDetails the orderedPlantDetails to set
	 */
	public void setOrderedPlantDetails(List<Cart> orderedPlantDetails) {
		this.orderedPlantDetails = orderedPlantDetails;
	}

	@Override
	public String toString() {
		return "Bill [orderId=" + orderId + ", customerName=" + customerName + ", mobileNumber=" + mobileNumber
				+ ", orderData=" + orderData + ", deliveryDate=" + deliveryDate + ", totalBill=" + totalBill
				+ ", orderedPlantDetails=" + orderedPlantDetails + "]";
	}

}
