package DTO;

public class CommentDTO {
	private String cId;
	private String llId;
	private String body;
	private String depth;
	private String time;
	private String partion;
	private String seq;
	public CommentDTO() {
		super();
	}
	public CommentDTO(String cId, String llId, String body, String depth, String time, String partion, String seq) {
		super();
		this.cId = cId;
		this.llId = llId;
		this.body = body;
		this.depth = depth;
		this.time = time;
		this.partion = partion;
		this.seq = seq;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getLlId() {
		return llId;
	}
	public void setLlId(String llId) {
		this.llId = llId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPartion() {
		return partion;
	}
	public void setPartion(String partion) {
		this.partion = partion;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	@Override
	public String toString() {
		return "CommentDTO [cId=" + cId + ", llId=" + llId + ", body=" + body + ", depth=" + depth + ", time=" + time
				+ ", partion=" + partion + ", seq=" + seq + "]";
	}
	
}
