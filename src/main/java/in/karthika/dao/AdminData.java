package in.karthika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.karthika.model.Admin;
import in.karthika.util.Connectionutil;

public class AdminData {

	private AdminData() {
		/**
		 * constructor
		 */
	}

	/**
	 * This method is used to get the admin details from the database
	 * 
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public static List<Admin> adminDetails() throws Exception {

		List<Admin> adminList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;

		try {
			String url = "select * from adminlist";
			con = Connectionutil.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(url);
			
			while (rs.next()) {
				String userName = rs.getString("Admin_Name");
				long contactNumber = rs.getLong("Contact_Number");
				String password = rs.getString("Password");
				
				adminList.add(new Admin(userName, contactNumber, password));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid User");
		} finally {
			Connectionutil.close(pst, con);
		}

		return adminList;
	}

}
