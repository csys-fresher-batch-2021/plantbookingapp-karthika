package in.karthika.exceptions;

public class EmptyStringException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when String is empty
	 * 
	 * @param message
	 */
	public EmptyStringException(String message) {
		super(message);

	}

}
