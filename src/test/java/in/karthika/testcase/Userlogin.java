package in.karthika.testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import in.karthika.validate.UserValidate;

public class Userlogin {

	@Test
	public void validTestCase1() {
		UserValidate.validateUser("karthika", "12345", "12345", "9090909090");
		boolean isValid = UserValidate.validatetUser("9090909090", "12345");
	    assertTrue(isValid);
	}
	
	@Test
	public void InvalidTestCase1() {
		UserValidate.validateUser("karthika", "12345", "12345", "9090909090");
		boolean isValid = UserValidate.validatetUser("9090909090", "  12345");
	    assertFalse(isValid);
	}
	
	@Test
	public void InvalidTestCase2() {
		UserValidate.validateUser("karthika", "12345", "12345", "9090909090");
		boolean isValid = UserValidate.validatetUser("909090", "12345");
	    assertFalse(isValid);
	}
	
	@Test
	public void InvalidTestCase3() {
		UserValidate.validateUser("karthika", "12345", "12345", "9090909090");
		boolean isValid = UserValidate.validatetUser("9090909099", "12345");
	    assertFalse(isValid);
	}

}
