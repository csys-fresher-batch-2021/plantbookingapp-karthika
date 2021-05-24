package in.karthika.testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import in.karthika.validate.UserValidate;

public class UserLogin {
	
	@Before
	public void register() {
		UserValidate.validateUser("karthika", "12345", "12345", "9090909090");
	}

	@Test
	public void validTestCase1() {
		boolean isValid = UserValidate.validatetUser("9090909090", "12345");
	    assertTrue(isValid);
	}
	
	@Test
	public void InvalidTestCase1() {
		boolean isValid = UserValidate.validatetUser("9090909090", "  123");
	    assertFalse(isValid);
	}
	
	@Test
	public void InvalidTestCase2() {
		boolean isValid = UserValidate.validatetUser("909090", "12345");
	    assertFalse(isValid);
	}
	
	@Test
	public void InvalidTestCase3() {
		boolean isValid = UserValidate.validatetUser("9090909099", "12345");
	    assertFalse(isValid);
	}

}
