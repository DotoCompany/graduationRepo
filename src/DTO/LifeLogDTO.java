package DTO;

public class LifeLogDTO {
	
	private String llId;
	private String uIdFk;
	private String mIdFk;
	private String uploadDate;
	private String isPublic;
	
	public LifeLogDTO() {
		// TODO Auto-generated constructor stub
	}

	public LifeLogDTO(String llId, String uIdFk, String mIdFk,
			String uploadDate, String isPublic) {
		super();
		this.llId = llId;
		this.uIdFk = uIdFk;
		this.mIdFk = mIdFk;
		this.uploadDate = uploadDate;
		this.isPublic = isPublic;
	}

	public String getLlId() {
		return llId;
	}

	public void setLlId(String llId) {
		this.llId = llId;
	}

	public String getuIdFk() {
		return uIdFk;
	}

	public void setuIdFk(String uIdFk) {
		this.uIdFk = uIdFk;
	}

	public String getmIdFk() {
		return mIdFk;
	}

	public void setmIdFk(String mIdFk) {
		this.mIdFk = mIdFk;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	@Override
	public String toString() {
		return "LifeLogDTO [llId=" + llId + ", uIdFk=" + uIdFk + ", mIdFk="
				+ mIdFk + ", uploadDate=" + uploadDate + ", isPublic="
				+ isPublic + "]";
	}
}
