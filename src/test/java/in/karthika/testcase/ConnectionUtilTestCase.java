package in.karthika.testcase;

import static org.junit.Assert.*;

import in.karthika.util.Connectionutil;

public class ConnectionUtilTestCase {

	public static void main(String[] args) {
		try {
			Connectionutil.getConnection();
		} catch (Exception e) {
			fail();
		}
	}

}
