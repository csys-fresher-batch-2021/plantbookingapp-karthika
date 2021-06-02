package in.karthika.util;

import in.karthika.exceptions.NumberCannotBeNegativeException;

public class NumberValidate {
	
	private NumberValidate() {
		/*
		 * Constructor
		 */
	}

	/**
	 * This method used to find the number is positive or not
	 * 
	 * @param number
	 * @return
	 * @throws NumberCannotBeNegativeException
	 */
	public static boolean positiveNumberValidate(String number) throws NumberCannotBeNegativeException {
		boolean isValid = false;
		long value = Long.parseLong(number);
		if (value > 0) {
			isValid = true;
		} else {
			throw new NumberCannotBeNegativeException("Negative Number");
		}
		return isValid;
	}

}
