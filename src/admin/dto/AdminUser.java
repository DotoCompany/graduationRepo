package admin.dto;

public class AdminUser {
	
	private String aId;
	private String emailId;
	private String pwd;
	private String name;
	private String contact;
	private String reg_date;
	private String status;
	
	public AdminUser() {
		// TODO Auto-generated constructor stub
	}

	public AdminUser(String aId, String emailId, String pwd, String name,
			String contact, String reg_date, String status) {
		super();
		this.aId = aId;
		this.emailId = emailId;
		this.pwd = pwd;
		this.name = name;
		this.contact = contact;
		this.reg_date = reg_date;
		this.status = status;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AdminUser [aId=" + aId + ", emailId=" + emailId + ", pwd="
				+ pwd + ", name=" + name + ", contact=" + contact
				+ ", reg_date=" + reg_date + ", status=" + status + "]";
	}
}
