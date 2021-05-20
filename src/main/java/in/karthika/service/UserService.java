package in.karthika.service;

import in.karthika.dao.UserData;
import in.karthika.model.User;

public class UserService {

	private UserService() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used to store all user details
	 * 
	 * @param mobileNo
	 * @param password
	 */
	public static boolean insertUser(String userName, String phoneNumber, String password) {
		long mobileNo = Long.parseLong(phoneNumber);
		boolean isAdd = false;
		boolean exist=false;
		for (User add : UserData.getUsers()) {
			if (add.getPhoneNumber()==mobileNo) {
				exist =true;
				break;
			}
		}
		if(exist==false) {
			UserData.addUser(userName, mobileNo, password);
			isAdd = true;
		}
		return isAdd;
	}

	/**
	 * This method is used to check the user is already registered If the user is
	 * already registered, It will return true
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public static boolean checkUser(String userId, String password) {
		boolean isValid = false;
		long mobileNo = Long.parseLong(userId);
		for (User user : UserData.getUsers()) {
			if (user.getPhoneNumber() == mobileNo) {
				if (user.getPassWord().equals(password)) {
					isValid = true;
				}
				break;
			}
		}
		return isValid;
	}

	/**
	 * This method is used to get the name of the user
	 * 
	 * @param userId
	 * @return
	 */
	public static String getUserName(String userId) {
		String name = null;
		long mobileNo = Long.parseLong(userId);
		for (User user : UserData.getUsers()) {
			if (user.getPhoneNumber() == mobileNo) {
				name = user.getName();
				break;
			}
		}
		return name;
	}

}
