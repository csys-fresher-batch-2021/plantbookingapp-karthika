package in.karthika.testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import in.karthika.validate.UserValidate;

public class UserRegistration {

	@Test
	public void validTestCase1() {
		String username = "Karthika";
		String password1 = "12345";
		String password2 = "12345";
		String mobilenumber = "9090909090";
		boolean insert = UserValidate.validateUser(username, password1, password2, mobilenumber);
		assertTrue(insert);
	}
	
	@Test
	public void validTestCase2() {
		String username = "Karthika";
		String password1 = "abcde";
		String password2 = "abcde";
		String mobilenumber = "8889998889";
		boolean insert = UserValidate.validateUser(username, password1, password2, mobilenumber);
		assertTrue(insert);
	}
	
	@Test
	public void inValidTestCase1() {
		String username = "    ";
		String password1 = "12345";
		String password2 = "12345";
		String mobilenumber = "9090909090";
		boolean insert = UserValidate.validateUser(username, password1, password2, mobilenumber);
		assertFalse(insert);
	}
	
	@Test
	public void inValidTestCase2() {
		String username = "Karthika";
		String password1 = " ";
		String password2 = " ";
		String mobilenumber = "9090909090";
		boolean insert = UserValidate.validateUser(username, password1, password2, mobilenumber);
		assertFalse(insert);
	}
	
	@Test
	public void inValidTestCase3() {
		String username = "Karthika";
		String password1 = "12345";
		String password2 = "12345";
		String mobilenumber = "90909";
		boolean insert = UserValidate.validateUser(username, password1, password2, mobilenumber);
		assertFalse(insert);
	}
	
	@Test
	public void inValidTestCase4() {
		String username = "Karthika";
		String password1 = "k1727";
		String password2 = "12345";
		String mobilenumber = "9090909090";
		boolean insert = UserValidate.validateUser(username, password1, password2, mobilenumber);
		assertFalse(insert);
	}
	
	@Test
	public void inValidTestCase5() {
		String username = "Karthika";
		String password1 = "k1727";
		String password2 = "   ";
		String mobilenumber = "9090909090";
		boolean insert = UserValidate.validateUser(username, password1, password2, mobilenumber);
		assertFalse(insert);
	}
	
	@Test
	public void inValidTestCase6() {
		String username = "Karthika";
		String password1 = "k1727";
		String password2 = "k1727";
		String mobilenumber = "  ";
		boolean insert = UserValidate.validateUser(username, password1, password2, mobilenumber);
		assertFalse(insert);
	}


}
