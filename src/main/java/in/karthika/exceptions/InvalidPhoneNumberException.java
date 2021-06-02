package in.karthika.exceptions;

public class InvalidPhoneNumberException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the phone number is invalid
	 * 
	 * @param message
	 */
	public InvalidPhoneNumberException(String message) {
		super(message);
	}

}
