package in.karthika.model;

public class Admin {

	private String adminName;
	private long adminPhoneNumber;
	private String adminPassWord;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param phoneNumber
	 * @param passWord
	 */

	public Admin(String name, long phoneNumber, String passWord) {
		this.adminName = name;
		this.adminPhoneNumber = phoneNumber;
		this.adminPassWord = passWord;
	}

	/**
	 * This method is used to return the name of the Admin
	 * 
	 * @return
	 */
	public String getName() {
		return adminName;
	}

	/**
	 * This method is used to return the contact number of the Admin
	 * 
	 * @return
	 */
	public long getPhoneNumber() {
		return adminPhoneNumber;
	}

	/**
	 * This method is used to return the password
	 * 
	 * @return
	 */
	public String getPassWord() {
		return adminPassWord;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminPhoneNumber=" + adminPhoneNumber + ", adminPassWord="
				+ adminPassWord + "]";
	}

}
