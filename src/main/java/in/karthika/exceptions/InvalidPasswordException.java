package in.karthika.exceptions;

public class InvalidPasswordException extends Exception{
	
	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the password is in invalid format
	 * @param message
	 */
	public InvalidPasswordException(String message) {
		super(message);
	}

}
