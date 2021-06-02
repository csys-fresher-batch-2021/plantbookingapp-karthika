package in.karthika.exceptions;

public class InvalidDetailsException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the details are invalid
	 * 
	 * @param message
	 */
	public InvalidDetailsException(String message) {
		super(message);
	}

}
