package in.karthika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.karthika.model.Cart;
import in.karthika.util.ConnectionUtil;

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

	public static final String CUSTOMERID = "Customer_Id";
	public static final String ORDERDATE = "Order_Date";
	public static final String PLANTNAME = "Plant_Name";
	public static final String PRICE = "Price";
	public static final String QUANTITY = "Quantity";
	public static final String PRICEPERPLANT = "Price_Per_Plant";

	/**
	 * This method used to save the ordered plants to the database
	 */

	public static void save(Cart cartItems) throws ClassNotFoundException {

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getConnection();

			String sql = "insert into cartData(Customer_Id,Order_Date,Plant_Name,Price,Quantity,Price_Per_Plant) values ( ?,?,?,?,?,? )";

			pst = con.prepareStatement(sql);
			pst.setString(1, cartItems.getOrderId());
			pst.setObject(2, cartItems.getOrderDate());
			pst.setString(3, cartItems.getPlantName());
			pst.setDouble(4, cartItems.getPrice());
			pst.setInt(5, cartItems.getQuantity());
			pst.setDouble(6, cartItems.getAmountForAplant());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to add the details");
		} finally {
			ConnectionUtil.close(pst, con);
		}

	}

	/**
	 * This method is used to get the ordered plant by customer id
	 * 
	 * @param customerId
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static List<Cart> getOrderDetailsByOrderId(String customerId) throws ClassNotFoundException {
		
		List<Cart> orderItems = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "select Customer_Id,Order_Date,Plant_Name,Price,Quantity,Price_Per_Plant from cartData where Customer_Id = ?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, customerId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String orderId = rs.getString(CUSTOMERID);
				LocalDate orderDate = LocalDate.parse(rs.getString(ORDERDATE));
				String plantName = rs.getString(PLANTNAME);
				double price = rs.getDouble(PRICE);
				int quantity = rs.getInt(QUANTITY);
				double pricePerPlant = rs.getDouble(PRICEPERPLANT);
				orderItems.add(new Cart(orderId, plantName, orderDate, price, quantity, pricePerPlant));
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot get the user details");
		}

		finally {
			ConnectionUtil.close(pst, connection);
		}

		return orderItems;

	}
}
