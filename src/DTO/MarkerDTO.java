package DTO;

import java.io.Serializable;

public class MarkerDTO implements Serializable{

	private String mId;
	private String uId;
	private String address;
	private String lat;
	private String lng;
	private String m_time;
	
	public MarkerDTO() {
		// TODO Auto-generated constructor stub
	}

	public MarkerDTO(String mId, String uId, String address, String lat,
			String lng, String m_time) {
		super();
		this.mId = mId;
		this.uId = uId;
		this.address = address;
		this.lat = lat;
		this.lng = lng;
		this.m_time = m_time;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getM_time() {
		return m_time;
	}

	public void setM_time(String m_time) {
		this.m_time = m_time;
	}

	@Override
	public String toString() {
		return "MarkerDTO [mId=" + mId + ", uId=" + uId + ", address="
				+ address + ", lat=" + lat + ", lng=" + lng + ", m_time="
				+ m_time + "]";
	}
}
