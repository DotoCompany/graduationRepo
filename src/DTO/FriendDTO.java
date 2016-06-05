package DTO;

import java.io.Serializable;

public class FriendDTO implements Serializable{
	private String friendCode;
	private String image;
	private String friendName;
	private String friendEmail;
	public FriendDTO(String friendCode, String image, String friendName, String friendEmail) {
		super();
		this.friendCode = friendCode;
		this.image = image;
		this.friendName = friendName;
		this.friendEmail = friendEmail;
	}
	public FriendDTO() {
		super();
	}
	public String getFriendCode() {
		return friendCode;
	}
	public void setFriendCode(String friendCode) {
		this.friendCode = friendCode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getFriendEmail() {
		return friendEmail;
	}
	public void setFriendEmail(String friendEmail) {
		this.friendEmail = friendEmail;
	}
	@Override
	public String toString() {
		return "FriendDTO [friendCode=" + friendCode + ", image=" + image + ", friendName=" + friendName
				+ ", friendEmail=" + friendEmail + "]";
	}
	
	
	
	
}
