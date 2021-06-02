package in.karthika.exceptions;

public class CannotGetCredentialException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the details cannot be accessed by the
	 * method
	 * 
	 * @param message
	 */
	public CannotGetCredentialException(String message) {
		super(message);
	}

}
