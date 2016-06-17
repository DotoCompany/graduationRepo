package DTO;

import java.sql.Timestamp;

public class CommentViewDTO {
	private int uId;
	private String emailId;
	private String name;
	private String image;
	private int cId;
	private int llId;
	private String text;
	private int depth;
	private Timestamp time;
	private int partion;
	private int seq;
	public CommentViewDTO() {
		super();
	}
	public CommentViewDTO(int uId, String emailId, String name, String image, int cId, int llId, String text, int depth,
			Timestamp time, int partion, int seq) {
		super();
		this.uId = uId;
		this.emailId = emailId;
		this.name = name;
		this.image = image;
		this.cId = cId;
		this.llId = llId;
		this.text = text;
		this.depth = depth;
		this.time = time;
		this.partion = partion;
		this.seq = seq;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getLlId() {
		return llId;
	}
	public void setLlId(int llId) {
		this.llId = llId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getPartion() {
		return partion;
	}
	public void setPartion(int partion) {
		this.partion = partion;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	@Override
	public String toString() {
		return "CommentViewDTO [uId=" + uId + ", emailId=" + emailId + ", name=" + name + ", image=" + image + ", cId="
				+ cId + ", llId=" + llId + ", text=" + text + ", depth=" + depth + ", time=" + time + ", partion="
				+ partion + ", seq=" + seq + "]";
	}
	
}
