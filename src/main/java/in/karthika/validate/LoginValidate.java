package in.karthika.validate;

import in.karthika.exceptions.EmptyStringException;
import in.karthika.exceptions.InvalidDetailsException;
import in.karthika.exceptions.InvalidPasswordException;
import in.karthika.exceptions.InvalidPhoneNumberException;
import in.karthika.util.PasswordValidate;
import in.karthika.util.PhoneNumberValidate;

public class LoginValidate {
	
	private LoginValidate() {
		/*
		 * Constructor
		 */
	}

	/**
	 * This method is used to validate the login details
	 * 
	 * @param phoneNumber
	 * @param password
	 * @return
	 * @throws InvalidPhoneNumberException
	 * @throws EmptyStringException
	 * @throws InvalidPasswordException
	 * @throws InvalidDetailsException
	 */
	public static boolean checkLogin(String phoneNumber, String password) throws InvalidPhoneNumberException,
			EmptyStringException, InvalidPasswordException, InvalidDetailsException {
		boolean isValid = false;
		if (PhoneNumberValidate.validatePhoneNumber(phoneNumber) && PasswordValidate.validatePassword(password)) {
			isValid = true;
		} else {
			throw new InvalidDetailsException("Invalid login Credentials");
		}
		return isValid;
	}

}
