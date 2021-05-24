package in.karthika.validate;

import in.karthika.service.UserService;

public class UserValidate {

	private UserValidate() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used check whether the user gave all details or not
	 * 
	 * @param password1
	 * @param password2
	 * @param phonenumber
	 * @return
	 */
	public static boolean validateUser(String userName, String password1, String password2, String phonenumber) {
		boolean isValid = false;
		if (!userName.trim().isEmpty() && !password1.trim().isEmpty() && !password2.trim().isEmpty()
				&& !phonenumber.trim().isEmpty()) {
			isValid = validtedetails(userName, password1, password2, phonenumber);

		}

		return isValid;
	}

	/**
	 * This method is to validate the user details
	 * 
	 * @param userName
	 * @param password1
	 * @param password2
	 * @param phonenumber
	 * @return
	 */
	public static boolean validtedetails(String userName, String password1, String password2, String phonenumber) {
		boolean isValid = false;
		if (Validate.nameValidate(userName) && password1.equals(password2) && Validate.passwordValidate(password1)
				&& Validate.phonenumberValidate(phonenumber)) {
			isValid = UserService.insertUser(userName, phonenumber, password1);
		}
		return isValid;
	}

	/**
	 * This method is used to Check the user is present or not
	 * 
	 * @param phoneNumber
	 * @param password
	 * @return
	 */
	public static boolean validatetUser(String phoneNumber, String password) {
		boolean isValid = false;
		if (Validate.passwordValidate(password) && Validate.phonenumberValidate(phoneNumber)) {
			isValid = UserService.checkUser(phoneNumber, password);
		}
		return isValid;

	}

}
