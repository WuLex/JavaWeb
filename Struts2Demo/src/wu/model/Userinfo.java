package wu.model;

import java.util.Date;

public class Userinfo {
	private Date birthday;
	private String suser;
	private int usersex;
	private String address;
	private String truename;
	private String[] likes;
	private String postcode;
	private String password;
	private String phoneno;
	
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSuser() {
		return suser;
	}
	public void setSuser(String suser) {
		this.suser = suser;
	}
	public int getUsersex() {
		return usersex;
	}
	public void setUsersex(int usersex) {
		this.usersex = usersex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String[] getLikes() {
		return likes;
	}
	public void setLikes(String[] likes) {
		this.likes = likes;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	
}
