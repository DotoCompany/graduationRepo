package DTO;

import java.io.Serializable;

public class UserDTO implements Serializable{
	private String uId;
	private String image;
	private String emailId;
	private String name;
	private String pwd;
	private String reg_date;
	
	public UserDTO(String uId, String image, String emailId, String name, String reg_date) {
		super();
		this.uId = uId;
		this.image = image;
		this.emailId = emailId;
		this.name = name;
		this.reg_date = reg_date;
	}

	public UserDTO(String uId, String image, String emailId, String name, String pwd, String reg_date) {
		super();
		this.uId = uId;
		this.image = image;
		this.emailId = emailId;
		this.name = name;
		this.pwd = pwd;
		this.reg_date = reg_date;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "UserDTO [uId=" + uId + ", image=" + image + ", emailId=" + emailId + ", name=" + name + ", pwd=" + pwd
				+ ", reg_date=" + reg_date + "]";
	}
	
	
}
