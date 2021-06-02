package in.karthika.util;

import in.karthika.exceptions.EmptyStringException;
import in.karthika.exceptions.InvalideNameException;

public class NameValidate {
	
	private NameValidate() {
		/*
		 * Constructor
		 */
	}

	/**
	 * This method is used to check the name field is empty or not
	 * 
	 * @param Name
	 * @return
	 * @throws EmptyStringException
	 * @throws InvalideNameException
	 */
	public static boolean validateName(String name) throws EmptyStringException, InvalideNameException {
		boolean isValid = false;
		if (!name.trim().isEmpty()) {
			isValid = checkName(name);
		} else {
			throw new EmptyStringException("Name field is empty");
		}

		return isValid;
	}

	/**
	 * This method is used to check the name contains only alphabets
	 * 
	 * @param name
	 * @return
	 * @throws InvalideNameException
	 */
	public static boolean checkName(String name) throws InvalideNameException {
		boolean valid = false;
		String regex = "[a-zA-Z ]+\\.?";
		if (name.matches(regex) && name.length() <= 20) {
			valid = true;
		} else {
			throw new InvalideNameException("Invalid name");
		}
		return valid;

	}

}
