package in.karthika.service;

import java.sql.SQLException;

import in.karthika.dao.AdminData;
import in.karthika.model.Admin;
import in.karthika.validate.LoginValidate;

public class AdminService {

	private AdminService() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used to check the admin details
	 * 
	 * @param userId
	 * @param password
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */

	public static boolean checkAdmin(String userId, String password) throws  Exception {
		boolean isValid = false;
		long mobileNo = Long.parseLong(userId);
		boolean validate = LoginValidate.checkLogin(userId, password);
		for (Admin admin : AdminData.adminDetails()) {
			if (admin.getAdminPhoneNumber() == mobileNo && validate) {
				if (admin.getAdminPassWord().equals(password)) {
					isValid = true;
				}
				break;
			}
		}
		return isValid;
	}

	/**
	 * This method is used to get the name of the admin
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public static String getAdminName(String userId) throws  Exception {
		String name = null;
		long mobileNo = Long.parseLong(userId);
		for (Admin admin : AdminData.adminDetails()) {
			if (admin.getAdminPhoneNumber() == mobileNo) {
				name = admin.getAdminName();
				break;
			}
		}
		return name;
	}

}
