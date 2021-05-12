package in.karthika.service;

import java.util.HashMap;

public class UserManager {
	
		public static HashMap<Long, String> userDetails = new HashMap<Long, String>();

		/**
		 * This method is used to store all user details
		 * 
		 * @param mobileNo
		 * @param password
		 */
		public static boolean addUser(String mobileNo, String password) {
			long phoneNumber=Long.parseLong(mobileNo);
			if (mobileNo.length() == 10 && phoneNumber % 1000000000 != 0 && password.trim().length() == 5) {
				userDetails.put(phoneNumber, password);
				return true;
			} else {
				return false;
			}

		}

		/**
		 * This Method is used to display all User Details
		 */
		public static void displayAllUsers() {
			for (Long mobileNo : userDetails.keySet()) {
				String password = userDetails.get(mobileNo);
				System.out.println("Username:" + mobileNo + ", password = " + password);

			}
		}

		/**
		 * This method is used to validate the login details
		 * 
		 * @param userId
		 * @param password
		 * @return
		 */
		public static boolean login(String userId, String password) {
			boolean exists=false;
			boolean checkLogin=false;
			long phoneNumber=Long.parseLong(userId); 
			if (userId.length() == 10 && phoneNumber % 1000000000 != 0 && password.trim().length() == 5) {
				 exists = userDetails.containsKey(phoneNumber);
				 checkLogin=check(exists, phoneNumber, password);
			}
			return checkLogin;
		}
		
		/**
		 * This method is used to check the user id and password
		 * @param exists
		 * @param userId
		 * @param password
		 * @return
		 */
		public static boolean check(boolean exists,long userId, String password) {
			if (exists) {
				String checkPSW = userDetails.get(userId);
				if (password.equals(checkPSW)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
			
		}





}
