package in.karthika.util;

import in.karthika.exceptions.EmptyStringException;
import in.karthika.exceptions.InvalidPhoneNumberException;

public class PhoneNumberValidate {

	private PhoneNumberValidate() {
		/*
		 * Constructor
		 */
	}
	
	/**
	 * This method is used to find the password field is empty or not
	 * 
	 * @param phoneNumber
	 * @return
	 * @throws EmptyStringException
	 * @throws InvalidPhoneNumberException
	 */

	public static boolean validatePhoneNumber(String phoneNumber)
			throws EmptyStringException, InvalidPhoneNumberException {
		boolean isValid = false;
		if (!phoneNumber.trim().isEmpty()) {
			isValid = checkPhoneNumber(phoneNumber);
		} else {
			throw new EmptyStringException("Phone number field is empty");
		}
		return isValid;
	}

	/**
	 * This method is used to check the phone number
	 * 
	 * @param phoneNumber
	 * @return
	 * @throws InvalidPhoneNumberException
	 */

	public static boolean checkPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
		boolean valid = false;
		long mobileNo = Long.parseLong(phoneNumber);
		if (phoneNumber.length() == 10 && mobileNo % 1000000000 != 0) {
			valid = true;
		} else {
			throw new InvalidPhoneNumberException("Phone number is invalid");
		}
		return valid;

	}
}
