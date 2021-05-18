package in.karthika.model;

public class Admin {

	private String adminName;
	private long adminPhoneNumber;
	private String adminPassWord;
	
	public Admin(String name,long phoneNumber,String passWord){
		this.adminName=name;
		this.adminPhoneNumber=phoneNumber;
		this.adminPassWord=passWord;
	}
	
	public String getName() {
		return adminName;
	}

	public long getPhoneNumber() {
		return adminPhoneNumber;
	}
	public String getPassWord() {
		return adminPassWord;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminPhoneNumber=" + adminPhoneNumber + ", adminPassWord="
				+ adminPassWord + "]";
	}

}
