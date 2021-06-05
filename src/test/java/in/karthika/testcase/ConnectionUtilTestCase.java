package in.karthika.testcase;

import in.karthika.util.ConnectionUtil;

public class ConnectionUtilTestCase {

	public static void main(String[] args) {
		try {
			ConnectionUtil.getConnection();
			System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
