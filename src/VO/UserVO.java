package VO;

import java.io.Serializable;

public class UserVO implements Serializable{
	private String email;
	private String name;
	private String password;
	private String reg_date;
	
	public UserVO() {
		super();
	}
	public UserVO(String email, String name, String password, String reg_date) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.reg_date = reg_date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "UserVO [email=" + email + ", name=" + name + ", password=" + password + ", reg_date=" + reg_date + "]";
	}
}
