package in.karthika.exceptions;

public class CannotDeletePlantException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when String is empty
	 * 
	 * @param message
	 */
	public CannotDeletePlantException(String message) {
		super(message);

	}
}
