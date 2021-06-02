package in.karthika.validate;

import in.karthika.exceptions.EmptyStringException;
import in.karthika.exceptions.InvalidDetailsException;
import in.karthika.exceptions.InvalidPasswordException;
import in.karthika.exceptions.InvalidPhoneNumberException;
import in.karthika.exceptions.InvalideNameException;
import in.karthika.util.NameValidate;
import in.karthika.util.PasswordValidate;
import in.karthika.util.PhoneNumberValidate;

public class UserValidate {

	private UserValidate() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used check whether the given details correct or not
	 * 
	 * @param password1
	 * @param password2
	 * @param phonenumber
	 * @return
	 * @throws InvalidPhoneNumberException
	 * @throws InvalidPasswordException
	 * @throws InvalideNameException
	 * @throws InvalidDetailsException
	 */
	public static boolean ValidaterRegisterUser(String userName, String password1, String password2, String phonenumber)
			throws EmptyStringException, InvalideNameException, InvalidPasswordException, InvalidPhoneNumberException,
			InvalidDetailsException {
		boolean isValid = false;
		if (NameValidate.validateName(userName) && PasswordValidate.validatePassword(password1)
				&& PasswordValidate.validatePassword(password1)
				&& PhoneNumberValidate.validatePhoneNumber(phonenumber)) {
			isValid = true;
		} else {
			throw new InvalidDetailsException("Invalid login Credentials");
		}
		return isValid;
	}

}
