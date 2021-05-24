package in.karthika.validate;

import in.karthika.service.AdminService;

public class AdminValidate {

	private AdminValidate() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used to validate the admin
	 * 
	 * @param phoneNumber
	 * @param password
	 * @return
	 */

	public static boolean validatetAdmin(String phoneNumber, String password) {
		boolean isValid = false;
		if (Validate.phonenumberValidate(phoneNumber) && Validate.passwordValidate(password)) {
			isValid = AdminService.checkAdmin(phoneNumber, password);
		}
		return isValid;

	}

}
