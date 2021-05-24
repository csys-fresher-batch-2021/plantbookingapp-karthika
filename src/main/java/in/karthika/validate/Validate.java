package in.karthika.validate;

public class Validate {
	
	private Validate() {
		/**
		 * constructor
		 */
	}

	/**
	 * This method is used to check the given phone number is valid or not
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static boolean phonenumberValidate(String phoneNumber) {
		boolean valid = false;
		long mobileNo = Long.parseLong(phoneNumber);
		String regex = "[0-9_ ]+\\.?";
		if (phoneNumber.matches(regex) && phoneNumber.length() == 10 && mobileNo % 1000000000 != 0) {
			valid = true;
		}
		return valid;

	}

	/**
	 * This method is used to check the given password is valid or not
	 * 
	 * @param password
	 * @return
	 */
	public static boolean passwordValidate(String password) {
		boolean valid = false;
		if (password.trim().length() == 5) {
			valid = true;
		}
		return valid;

	}

	/**
	 * This method is used to validate the user name
	 * 
	 * @param name
	 * @return
	 */
	public static boolean nameValidate(String name) {
		boolean valid = false;
		String regex = "[a-zA-Z_ ]+\\.?";
		if (name.matches(regex) && name.length() <= 20) {
			valid = true;
		}
		return valid;

	}
}
