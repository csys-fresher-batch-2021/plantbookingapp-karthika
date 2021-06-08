package in.karthika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.karthika.exceptions.CannotAddException;
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

	public static void save(Cart cartItems) throws ClassNotFoundException, CannotAddException {

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

	public static List<Cart> getOrderDetailsByOrderId(String customerId) throws ClassNotFoundException {
		
		List<Cart> orderItems = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		
		try {
			connection = ConnectionUtil.getConnection();

			String url = "select * from cartData where Order_Id = ?";
			pst = connection.prepareStatement(url);
			pst.setString(1, customerId);
			
			ResultSet rs = pst.executeQuery(url);
			
			
			while (rs.next()) {
				String orderId=rs.getString("Customer_Id");
				LocalDate orderDate=LocalDate.parse(rs.getString("Order_Date"));
	            String plantName=rs.getString("Plant_Name");
				double price=rs.getDouble("Price");
				int quantity=rs.getInt("Quantity");
				double pricePerPlant=rs.getDouble("Price_Per_Plant");
				orderItems.add(new Cart(orderId,plantName,orderDate,price,quantity,pricePerPlant));
			}
		}
		

		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid Plant Details");
		}

		finally {
			ConnectionUtil.close(pst, connection);
		}
		
		return orderItems;

	}
}
