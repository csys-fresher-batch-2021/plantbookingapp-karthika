package in.karthika.exceptions;

public class NumberCannotBeNegativeException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the number is negative
	 * 
	 * @param message
	 */
	public NumberCannotBeNegativeException(String message) {
		super(message);
	}

}
