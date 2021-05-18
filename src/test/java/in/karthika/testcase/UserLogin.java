package in.karthika.testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import in.karthika.validate.UserValidate;

public class UserLogin {

	@Test
	public void validTestCase() {
		UserValidate.validateUser("karthika", "12345", "12345", "9090909090");
		boolean isValid = UserValidate.validatetUser("9090909090", "12345");
	    assertTrue(isValid);
	}

}
