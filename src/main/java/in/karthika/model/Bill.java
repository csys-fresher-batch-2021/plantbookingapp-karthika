package in.karthika.model;

import java.time.LocalDate;

public class Bill {

	private String orderId;
	private String customerName;
	private long mobileNumber;
	private LocalDate orderData;
	private LocalDate deliveryDate;
	private double totalBill;
	private double gst;
	private double finalBill;
	/**
	 * @param orderId
	 * @param customerName
	 * @param mobileNumber
	 * @param orderData
	 * @param deliveryDate
	 * @param totalBill
	 * @param gst
	 * @param finalBill
	 */
	public Bill(String orderId, String customerName, long mobileNumber, LocalDate orderData, LocalDate deliveryDate,
			double totalBill, double gst, double finalBill) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.orderData = orderData;
		this.deliveryDate = deliveryDate;
		this.totalBill = totalBill;
		this.gst = gst;
		this.finalBill = finalBill;
	}
	public Bill() {
		// TODO Auto-generated constructor stub
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
	 * @return the gst
	 */
	public double getGst() {
		return gst;
	}
	/**
	 * @param gst the gst to set
	 */
	public void setGst(double gst) {
		this.gst = gst;
	}
	/**
	 * @return the finalBill
	 */
	public double getFinalBill() {
		return finalBill;
	}
	/**
	 * @param finalBill the finalBill to set
	 */
	public void setFinalBill(double finalBill) {
		this.finalBill = finalBill;
	}
	
	@Override
	public String toString() {
		return "Bill [orderId=" + orderId + ", customerName=" + customerName + ", mobileNumber=" + mobileNumber
				+ ", orderData=" + orderData + ", deliveryDate=" + deliveryDate + ", totalBill=" + totalBill + ", gst="
				+ gst + ", finalBill=" + finalBill + "]";
	}

	
}
