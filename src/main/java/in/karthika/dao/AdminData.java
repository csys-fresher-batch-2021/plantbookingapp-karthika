package in.karthika.dao;

import java.util.ArrayList;
import java.util.List;

import in.karthika.model.Admin;

public class AdminData {

	private AdminData() {
		/**
		 * constructor
		 */
	}

	/*
	 * Create array list to store all admins
	 */
	private static List<Admin> adminList = new ArrayList<>();

	static {
		adminList.add(new Admin("Karthika", 9080246689l, "k1727"));
		adminList.add(new Admin("Aruna", 9443145867l, "a1727"));
	}

	/**
	 * This method is used to return admins
	 * 
	 * @return
	 */
	public static List<Admin> getAdmin() {
		return adminList;
	}

}
