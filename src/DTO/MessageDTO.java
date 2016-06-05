package DTO;

import java.io.Serializable;

public class MessageDTO implements Serializable{
	private String msgId;
	private String body;
	private String time;
	private String toName;
	private String fromName;
	public MessageDTO(String msgId, String body, String time, String toName, String fromName) {
		super();
		this.msgId = msgId;
		this.body = body;
		this.time = time;
		this.toName = toName;
		this.fromName = fromName;
	}
	public MessageDTO() {
		super();
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	@Override
	public String toString() {
		return "MessageDTO [msgId=" + msgId + ", body=" + body + ", time=" + time + ", toName=" + toName + ", fromName="
				+ fromName + "]";
	}
	
}
