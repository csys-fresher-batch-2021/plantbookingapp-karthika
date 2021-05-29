package in.karthika.dao;

import java.util.ArrayList;
import java.util.List;

import in.karthika.model.User;

public class UserData {

	private UserData() {
		/**
		 * constructor
		 */
	}

	/*
	 * Create array list to store all users
	 */
	private static List<User> userList = new ArrayList<>();

	public static void addUser(String userName, long mobileNo, String password) {
		userList.add(new User(userName, mobileNo, password));

	}

	/**
	 * This method is used to return all users
	 * 
	 * @return
	 */
	public static List<User> getUsers() {
		return userList;
	}

}
