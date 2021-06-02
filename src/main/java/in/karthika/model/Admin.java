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
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}



	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}



	/**
	 * @return the adminPhoneNumber
	 */
	public long getAdminPhoneNumber() {
		return adminPhoneNumber;
	}



	/**
	 * @param adminPhoneNumber the adminPhoneNumber to set
	 */
	public void setAdminPhoneNumber(long adminPhoneNumber) {
		this.adminPhoneNumber = adminPhoneNumber;
	}



	/**
	 * @return the adminPassWord
	 */
	public String getAdminPassWord() {
		return adminPassWord;
	}



	/**
	 * @param adminPassWord the adminPassWord to set
	 */
	public void setAdminPassWord(String adminPassWord) {
		this.adminPassWord = adminPassWord;
	}


	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminPhoneNumber=" + adminPhoneNumber + ", adminPassWord="
				+ adminPassWord + "]";
	}

}
