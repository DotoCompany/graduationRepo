package DTO;

public class LifeLogPhotoDTO {

	private String llpId;
	private String llIdFk;
	private String url;
	
	public LifeLogPhotoDTO() {
		// TODO Auto-generated constructor stub
	}

	public LifeLogPhotoDTO(String llpId, String llIdFk, String url) {
		super();
		this.llpId = llpId;
		this.llIdFk = llIdFk;
		this.url = url;
	}

	public String getLlpId() {
		return llpId;
	}

	public void setLlpId(String llpId) {
		this.llpId = llpId;
	}

	public String getLlIdFk() {
		return llIdFk;
	}

	public void setLlIdFk(String llIdFk) {
		this.llIdFk = llIdFk;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "LifeLogPhotoDTO [llpId=" + llpId + ", llIdFk=" + llIdFk
				+ ", url=" + url + "]";
	}
}
