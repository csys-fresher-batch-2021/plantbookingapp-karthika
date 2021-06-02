package in.karthika.model;

public class User {

	private String userId;
	private String name;
	private long phoneNumber;
	private String passWord;

	/**
	 * Constructor
	 * 
	 * @param userId
	 * @param name
	 * @param phoneNumber
	 * @param passWord
	 */
	public User(String userId, String name, long phoneNumber, String passWord) {
		this.userId = userId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.passWord = passWord;
	}

	/**
	 * This method is used to store the userId
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * This method is used to return the user Id
	 * 
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method is used to store the user's name
	 * 
	 * @return
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method is used to return the name of the user
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method is used to store the phone number
	 * 
	 * @param phoneNumber
	 */

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * This method is used to return the phone number of the user
	 * 
	 * @return
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * This method is used to store the password
	 * 
	 * @param passWord
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * This method is used to return the password
	 * 
	 * @return
	 */
	public String getPassWord() {
		return passWord;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", phoneNumber=" + phoneNumber + ", passWord=" + passWord + "]";
	}

}
