package in.karthika.validate;

import in.karthika.service.UserService;

public class UserValidate {

	/**
	 * This method is used check the password and confirm password is equal or not
	 * 
	 * @param password1
	 * @param password2
	 * @param phonenumber
	 * @return
	 */
	public static boolean validateUser(String userName, String password1, String password2, String phonenumber) {
		boolean isValid = false;
		if (!userName.trim().isEmpty() && !password1.trim().isEmpty() && !password2.trim().isEmpty() && !phonenumber.trim().isEmpty()) {
			if (password1.equals(password2)) {
				isValid = UserService.insertUser(userName, phonenumber, password1);
			}
		}

		return isValid;
	}


	public static boolean validatetUser(String phoneNumber, String password) {
		long mobileNo = Long.parseLong(phoneNumber);
		boolean isValid = false;
		if (phoneNumber.length() == 10 && mobileNo % 1000000000 != 0 && password.trim().length() == 5) {
			isValid = UserService.checkUser(phoneNumber, password);
		}
		return isValid;

	}

}
