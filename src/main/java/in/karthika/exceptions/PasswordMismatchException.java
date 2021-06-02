package in.karthika.exceptions;

public class PasswordMismatchException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the password and the confirm password is
	 * not matched
	 * 
	 * @param message
	 */
	public PasswordMismatchException(String message) {
		super(message);
	}

}
