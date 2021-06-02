package in.karthika.exceptions;

public class InvalidNumberException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the given number is invalid
	 * 
	 * @param message
	 */
	public InvalidNumberException(String message) {
		super(message);
	}

}
