package in.karthika.testcase;

import org.junit.Test;

import in.karthika.service.PlantManager;

public class PlantStock {

	/**
	 * This method is used to display all plants in the stock
	 */
	@Test
	public void test() {
		PlantManager.displayAllPlants();
	}
}
