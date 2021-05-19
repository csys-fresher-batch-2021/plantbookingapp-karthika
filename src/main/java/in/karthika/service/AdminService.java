package in.karthika.service;

import in.karthika.dao.AdminData;
import in.karthika.model.Admin;

public class AdminService {

	private AdminService() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used to find the admin id is already registered If it is
	 * already registered, it will return true else it will return false
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */

	public static boolean checkAdmin(String userId, String password) {
		boolean isValid = false;
		long mobileNo = Long.parseLong(userId);
		for (Admin admin : AdminData.getAdmin()) {
			if (admin.getPhoneNumber() == mobileNo) {
				if (admin.getPassWord().equals(password)) {
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
	 */
	public static String getAdminName(String userId) {
		String name = null;
		long mobileNo = Long.parseLong(userId);
		for (Admin admin : AdminData.getAdmin()) {
			if (admin.getPhoneNumber() == mobileNo) {
				name = admin.getName();
				break;
			}
		}
		return name;
	}

}
