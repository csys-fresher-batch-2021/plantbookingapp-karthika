package in.karthika.exceptions;

public class UserAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * This exception will be raise when the user is already exist
	 * 
	 * @param message
	 */
	public UserAlreadyExistException(String message) {
		super(message);
	}

}
