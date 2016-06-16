package DTO;
/**
 * 여기의 url은 image의 url을 말하는거임..
 * 뷰 만들때 설명을 못적으니 뭐..ㅋ
 * @author kwongyo
 *
 */
public class LifeLogViewDTO {
	private String uId;
	private String llId;
	private String uploadDate;
	private String isPublic;
	private String url;
	private String body;
	private String seq;
	private String lat;
	private String lng;
	public LifeLogViewDTO() {
		super();
	}
	public LifeLogViewDTO(String uId, String llId, String uploadDate, String isPublic, String url, String body,
			String seq, String lat, String lng) {
		super();
		this.uId = uId;
		this.llId = llId;
		this.uploadDate = uploadDate;
		this.isPublic = isPublic;
		this.url = url;
		this.body = body;
		this.seq = seq;
		this.lat = lat;
		this.lng = lng;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getLlId() {
		return llId;
	}
	public void setLlId(String llId) {
		this.llId = llId;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "LifeLogViewDTO [uId=" + uId + ", llId=" + llId + ", uploadDate=" + uploadDate + ", isPublic=" + isPublic
				+ ", url=" + url + ", body=" + body + ", seq=" + seq + ", lat=" + lat + ", lng=" + lng + "]";
	}
	
}
