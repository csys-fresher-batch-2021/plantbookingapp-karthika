package in.karthika.service;

import java.util.List;

import in.karthika.dao.UserData;
import in.karthika.model.User;
import in.karthika.validate.Validate;

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
		boolean exist = false;
		exist = isExist(mobileNo);
		if (!exist) {
			UserData.addUser(userName, mobileNo, password);
			isAdd = true;
		}
		return isAdd;
	}

	/**
	 * This method is used to find the mobile number is already exist or not
	 * 
	 * @param mobileNumber
	 * @return
	 */
	public static boolean isExist(long mobileNumber) {
		boolean exist = false;
		for (User add : UserData.getUsers()) {
			if (add.getPhoneNumber() == mobileNumber) {
				exist = true;
				break;
			}
		}
		return exist;
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

	/**
	 * This method is used check the user who want to change the password is already
	 * exist or not
	 * 
	 * @param phoneNumber
	 * @param password1
	 * @param password2
	 * @return
	 */

	public static boolean changepassword(String phoneNumber, String password1, String password2) {
		long mobileNo = Long.parseLong(phoneNumber);
		boolean change = false;
		if (password1.equals(password2) && Validate.passwordValidate(password1) && isExist(mobileNo)) {
			change = change(mobileNo, password1);

		}
		return change;
	}

	/**
	 * This method is used to change the user's password
	 * 
	 * @param mobileNo
	 * @param password1
	 * @return
	 */
	public static boolean change(long mobileNo, String password1) {
		List<User> userList = UserData.getUsers();
		boolean change = false;
		for (User user : UserData.getUsers()) {
			if (user.getPhoneNumber() == mobileNo) {
				String name = user.getName();
				userList.remove(user);
				UserData.addUser(name, mobileNo, password1);
				change = true;
				break;
			}
		}
		return change;
	}

}
