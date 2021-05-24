package in.karthika.model;

public class User {

	private String name;
	private long phoneNumber;
	private String passWord;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param phoneNumber
	 * @param passWord
	 */
	public User(String name, long phoneNumber, String passWord) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.passWord = passWord;
	}

	/**
	 * This methos is used to return the name of the user
	 * 
	 * @return
	 */
	public String getName() {
		return name;
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
