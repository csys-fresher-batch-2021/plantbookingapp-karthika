package in.karthika.util;

import in.karthika.exceptions.EmptyStringException;
import in.karthika.exceptions.InvalidPasswordException;

public class PasswordValidate {

	private PasswordValidate() {
		/*
		 * Constructor
		 */
	}
	
	/**
	 * This method is used to check the password field is empty or not
	 * 
	 * @param password
	 * @return
	 * @throws EmptyStringException
	 * @throws InvalidPasswordException
	 */
	public static boolean validatePassword(String password) throws EmptyStringException, InvalidPasswordException {
		boolean isValid = false;
		if (!password.trim().isEmpty()) {
			isValid = checkPhoneNumber(password);
		} else {
			throw new EmptyStringException("Password field is empty");
		}
		return isValid;
	}

	/**
	 * This method is used to find the password length is8 or not
	 * 
	 * @param password
	 * @return
	 * @throws InvalidPasswordException
	 */
	public static boolean checkPhoneNumber(String password) throws InvalidPasswordException {
		boolean valid = false;
		if (password.trim().length() == 8) {
			valid = true;
		} else {
			throw new InvalidPasswordException("Invalid");
		}
		return valid;

	}
}
