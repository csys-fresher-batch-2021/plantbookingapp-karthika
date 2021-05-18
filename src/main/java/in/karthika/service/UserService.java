package in.karthika.service;

import in.karthika.dao.UserData;
import in.karthika.model.User;

public class UserService {
	
	/**
	 * This method is used to store all user details
	 * 
	 * @param mobileNo
	 * @param password
	 */
	public static boolean insertUser(String userName, String phoneNumber, String password) {
		long mobileNo = Long.parseLong(phoneNumber);
		boolean isValid = false;
		if (phoneNumber.length() == 10 && mobileNo % 1000000000 != 0 && password.trim().length() == 5) {
			UserData.addUser(userName, mobileNo, password);
			isValid = true;
		}
		return isValid;
	}
	
	public static boolean checkUser(String userId, String password) {
		boolean isValid = false;
		long mobileNo = Long.parseLong(userId);
		for (User user : UserData.getUsers()) {
			if(user.getPhoneNumber()==mobileNo) {
				if(user.getPassWord().equals(password)) {
					isValid=true;
				}
				break;
			}
		}
		return isValid;
	}
	
	public static String getUserName(String userId) {
		String name = null;
		long mobileNo = Long.parseLong(userId);
		for (User user : UserData.getUsers()) {
			if(user.getPhoneNumber()==mobileNo) {
				name= user.getName();
				break;
			}
		}
		return name;
	}

}
