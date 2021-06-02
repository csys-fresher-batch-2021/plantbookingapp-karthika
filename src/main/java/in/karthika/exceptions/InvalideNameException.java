package in.karthika.exceptions;

public class InvalideNameException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the name in invalid format
	 * 
	 * @param message
	 */
	public InvalideNameException(String message) {
		super(message);
	}
}
