package in.karthika.validate;

import in.karthika.exceptions.EmptyStringException;
import in.karthika.exceptions.InvalidDetailsException;
import in.karthika.exceptions.InvalidNumberException;
import in.karthika.exceptions.InvalideNameException;
import in.karthika.exceptions.NumberCannotBeNegativeException;
import in.karthika.util.NameValidate;
import in.karthika.util.NumberValidate;

public class PlantDetailsValidate {

	private PlantDetailsValidate() {
		/*
		 * Constructor
		 */
	}

	/**
	 * This method is used to check the plant details are valid or not
	 * 
	 * @param plantname
	 * @param price
	 * @return
	 * @throws InvalidDetailsException
	 * @throws EmptyStringException
	 * @throws InvalideNameException
	 * @throws NumberCannotBeNegativeException
	 * @throws InvalidNumberException
	 */
	public static boolean checkPlant(String plantname, String price) throws InvalidDetailsException,
			EmptyStringException, InvalideNameException, NumberCannotBeNegativeException {
		boolean isValid = false;
		boolean isNameValid = NameValidate.validateName(plantname);
		boolean isPositive = NumberValidate.positiveNumberValidate(price);
		if (isNameValid && isPositive ) {
			isValid = true;
		} else {
			throw new InvalidDetailsException("Invalid plant details");
		}
		return isValid;
	}

}
