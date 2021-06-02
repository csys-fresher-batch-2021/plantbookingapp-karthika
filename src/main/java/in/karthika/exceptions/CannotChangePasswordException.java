package in.karthika.exceptions;

public class CannotChangePasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the password can be change by the user
	 * @param message
	 */
	
	public CannotChangePasswordException(String message) {
		super(message);
	}

}
