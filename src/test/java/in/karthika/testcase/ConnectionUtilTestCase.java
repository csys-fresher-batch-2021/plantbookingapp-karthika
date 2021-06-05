package in.karthika.testcase;

import in.karthika.util.Connectionutil;

public class ConnectionUtilTestCase {

	public static void main(String[] args) {
		try {
			Connectionutil.getConnection();
			System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
