package in.karthika.service;

import in.karthika.dao.UserData;
import in.karthika.exceptions.InvalidDetailsException;
import in.karthika.exceptions.PasswordMismatchException;
import in.karthika.model.User;
import in.karthika.util.PasswordValidate;
import in.karthika.validate.LoginValidate;
import in.karthika.validate.UserValidate;

public class UserService {

	private UserService() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used to validate and insert the user
	 * 
	 * @param userName
	 * @param phoneNumber
	 * @param password1
	 * @param password2
	 * @return
	 * @throws Exception
	 */
	public static boolean insertUser(String userName, String phoneNumber, String password1, String password2)
			throws Exception {
		boolean isValid = UserValidate.ValidaterRegisterUser(userName, password1, password2, phoneNumber);
		boolean isMatch = isEqual(password1, password2);
		boolean isAdd = false;
		long mobileNo = Long.parseLong(phoneNumber);
		String userId = generateUserId(phoneNumber, userName);
		boolean exist = isExist(mobileNo);
		if (!exist && isValid && isMatch) {
			isAdd = addUser(userId, userName, mobileNo, password1);
		} else {
			throw new InvalidDetailsException("Invalid Details");
		}
		return isAdd;
	}

	/**
	 * This method is used to add the user
	 * 
	 * @param userId
	 * @param userName
	 * @param mobileNo
	 * @param password
	 * @return
	 * @throws Exception
	 */

	public static boolean addUser(String userId, String userName, long mobileNo, String password) throws Exception {
		User user = new User(userId, userName, mobileNo, password);
		boolean isAdd = UserData.save(user);
		return isAdd;
	}

	/**
	 * This method is used to find the password and confirm password is equal or not
	 * 
	 * @param password1
	 * @param password2
	 * @return
	 * @throws PasswordMismatchException
	 */
	public static boolean isEqual(String password1, String password2) throws PasswordMismatchException {
		boolean isMatch = false;
		if (password1.equals(password2)) {
			isMatch = true;
		} else {
			throw new PasswordMismatchException("Confirm password is not matched");
		}
		return isMatch;
	}

	/**
	 * This method is used generate the user Id
	 * 
	 * @param phoneNumber
	 * @param userName
	 * @return
	 */

	public static String generateUserId(String phoneNumber, String userName) {
		String name = userName.substring(0, 4);
		return name + phoneNumber;
	}

	/**
	 * This method is used to find the mobile number is already exist or not
	 * 
	 * @param mobileNumber
	 * @return
	 * @throws Exception
	 */
	public static boolean isExist(long mobileNumber) throws Exception {
		boolean exist = false;
		for (User add : UserData.userDetails()) {
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
	 * @throws Exception
	 */
	public static boolean checkUser(String userId, String password) throws Exception {
		boolean isValid = false;
		long mobileNo = Long.parseLong(userId);
		boolean validate = LoginValidate.checkLogin(userId, password);
		for (User user : UserData.userDetails()) {
			if (user.getPhoneNumber() == mobileNo && validate) {
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
	 * @throws Exception
	 */

	public static String getUserName(String phoneNumber) throws Exception {
		String name = null;
		long mobileNo = Long.parseLong(phoneNumber);
		for (User user : UserData.userDetails()) {
			if (user.getPhoneNumber() == mobileNo) {
				name = user.getName();
				break;
			}
		}
		return name;
	}

	/**
	 * This method is used to change the password
	 * 
	 * @param phoneNumber
	 * @param password1
	 * @param password2
	 * @return
	 * @throws Exception
	 */

	public static boolean changepassword(String phoneNumber, String password1, String password2) throws Exception {
		long mobileNo = Long.parseLong(phoneNumber);
		boolean change = false;
		if (isEqual(password1, password2) && PasswordValidate.validatePassword(password1) && isExist(mobileNo)) {
			change = UserData.changePassword(mobileNo, password1);

		} else {
			throw new InvalidDetailsException("Invalid Detailsss");
		}
		return change;
	}

}
