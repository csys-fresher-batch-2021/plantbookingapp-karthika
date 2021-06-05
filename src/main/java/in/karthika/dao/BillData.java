package in.karthika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.karthika.exceptions.CannotAddException;
import in.karthika.model.Bill;
import in.karthika.util.Connectionutil;

public class BillData {

	private BillData() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used to get the bill details from the database
	 * @return
	 * @throws Exception
	 */
	public static List<Bill> billDetails() throws Exception {

		List<Bill> billDetails = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;

		try {
			String url = "select * from billDetails";
			con = Connectionutil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(url);
   
			while (rs.next()) {
				String orderId=rs.getString("Order_Id");
	            String customerName=rs.getString("Customer_Name");
				Long mobileNumber=rs.getLong("Contact_Number");
	            LocalDate orderDate=LocalDate.parse(rs.getString("Order_Date"));
				LocalDate deliveryDate=LocalDate.parse(rs.getString("Delivery_Date"));
				double tbill=rs.getDouble("Bill");
				double gst=rs.getDouble("GST");
				double fbill=rs.getDouble("Final_Bill");
				billDetails.add(new Bill(orderId,customerName,mobileNumber,orderDate,deliveryDate,tbill,gst,fbill));
			}
		}
		

		catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid Plant Details");
		}

		finally {
			Connectionutil.close(pst, con);
		}
		return billDetails;
	}

	/**
	 * This method is used to store all bill details to date base
	 * 
	 * @param plant
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @throws CannotAddException
	 */

	public static boolean save(Bill bill) throws Exception {

		boolean isAdd = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = Connectionutil.getConnection();
			String sql = "INSERT INTO billDetails ( Order_Id, Customer_Name, Contact_Number, Order_Date, Delivery_Date, Bill, GST,Final_Bill) values (?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, bill.getOrderId());
			pst.setString(2, bill.getCustomerName());
			pst.setLong(3, bill.getMobileNumber());
			pst.setObject(4, bill.getOrderData());
			pst.setObject(5, bill.getDeliveryDate());
			pst.setDouble(6, bill.getTotalBill());
			pst.setDouble(7, bill.getGst());
			pst.setDouble(8, bill.getFinalBill());

			int rows = pst.executeUpdate();

			if (rows == 1) {
				isAdd = true;
			} else {
				throw new CannotAddException("Cannot Add");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to add Plant");
		} finally {
			Connectionutil.close(pst, con);
		}

		return isAdd;
	}

}
