package in.karthika.validate;

public class PlantValidate {

	private PlantValidate() {
		/**
		 * Constructor
		 */
	}

	/**
	 * This method is used to check whether the quantity is greater than 0
	 * 
	 * @param qnty
	 * @return
	 */
	public static boolean checkQuantity(int qnty) {
		boolean check = false;
		if (qnty > 0) {
			check = true;
		}
		return check;
	}

	/**
	 * This method is used to check whether the price is greater than 0
	 * 
	 * @param price
	 * @return
	 */
	public static boolean chackPrice(double price) {
		boolean check = false;
		if (price > 0) {
			check = true;
		}
		return check;
	}

}
