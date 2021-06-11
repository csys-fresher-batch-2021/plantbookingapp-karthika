package in.karthika.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.karthika.exceptions.CannotAddException;
import in.karthika.exceptions.CannotChangePasswordException;
import in.karthika.exceptions.CannotGetCredentialException;
import in.karthika.model.User;
import in.karthika.util.ConnectionUtil;

public class UserData {

	private UserData() {
		/**
		 * constructor
		 */
	}


	public static final String USERID = "User_Id";
	public static final String USERNAME = "User_Name";
	public static final String CONTACTNUMBER = "Contact_Number";
	public static final String PASSWORD = "Password";

	/**
	 * This method is used to store all user details insert the table userList
	 * 
	 * @param user
	 * @throws Exception
	 */
	
	public static boolean save(User user) throws Exception {

		boolean isAdd = false;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getConnection();

			String sql = "insert into userlist(User_Id,User_Name,Contact_Number,Password) values ( ?,?,?,? )";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getUserId());
			pst.setString(2, user.getName());
			pst.setLong(3, user.getPhoneNumber());
			pst.setString(4, user.getPassWord());

			int rows = pst.executeUpdate();

			if (rows == 1) {
				isAdd = true;
			} else {
				throw new CannotAddException("Cannot Add Details");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to add user");
		} finally {
			ConnectionUtil.close(pst, con);
		}

		return isAdd;
	}

	/**
	 * This method returns all the values in the table userList
	 * 
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public static List<User> userDetails() throws Exception {

		List<User> userList = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getConnection();

			String url = "select User_Id, User_Name, Contact_Number, Password  from userList";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(url);

			while (rs.next()) {
				String userId = rs.getString(USERID);
				String userName = rs.getString(USERNAME);
				long contactNumber = rs.getLong(CONTACTNUMBER);
				String password = rs.getString(PASSWORD);
				userList.add(new User(userId, userName, contactNumber, password));
			}
		} catch (SQLException e) {
			throw new CannotGetCredentialException(e.getMessage());
		} finally {
			ConnectionUtil.close(pst, con);
		}

		return userList;
	}

	/**
	 * This method is used to change the password of the user
	 * 
	 * @param phoneNumber
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */

	public static boolean changePassword(long phoneNumber, String newPassword) throws Exception {

		boolean isChanged = false;
		Connection connection = null;
		PreparedStatement pst = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "update userList set Password=? where Contact_Number=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, newPassword);
			pst.setLong(2, phoneNumber);

			int rs = pst.executeUpdate();

			if (rs == 1) {
				isChanged = true;
			} else {
				throw new CannotChangePasswordException("Cannot Change the password");
			}
		} catch (SQLException e) {
			throw new CannotGetCredentialException(e.getMessage());
		} finally {
			ConnectionUtil.close(pst, connection);
		}

		return isChanged;

	}

}
