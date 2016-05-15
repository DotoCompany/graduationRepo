package model;

import java.io.Serializable;

public class UserDTO implements Serializable{
	private String emailId;
	private String name;
	private String pwd;
	public UserDTO() {
		super();
	}
	public UserDTO(String emailId, String name, String pwd) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.pwd = pwd;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "UserDTO [emailId=" + emailId + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
	
}
