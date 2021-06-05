package in.karthika.exceptions;

public class PlantNotExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the user is already exist
	 * 
	 * @param message
	 */
	public PlantNotExistException(String message) {
		super(message);
	}
}
