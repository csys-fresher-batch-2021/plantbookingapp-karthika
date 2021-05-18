package in.karthika.validate;

import in.karthika.service.AdminService;

public class AdminValidate {
	
	private AdminValidate() {
		/**
		 * Constructor
		 */
	}
	
	public static boolean validatetAdmin(String phoneNumber, String password) {
		long mobileNo = Long.parseLong(phoneNumber);
		boolean isValid = false;
		if (phoneNumber.length() == 10 && mobileNo % 1000000000 != 0 && password.trim().length() == 5) {
			isValid = AdminService.checkAdmin(phoneNumber, password);
		}
		return isValid;

	}

}
