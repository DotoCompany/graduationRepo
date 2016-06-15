package DTO;

import java.io.Serializable;

public class Marker implements Serializable{
	private String lat;
	private String lon;
	private String m_time;
	private String event;
	
	public Marker() {
		super();
	}

	public Marker(String lat, String lon, String m_time, String event) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.m_time = m_time;
		this.event = event;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getM_time() {
		return m_time;
	}

	public void setM_time(String m_time) {
		this.m_time = m_time;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Marker [lat=" + lat + ", lon=" + lon + ", m_time=" + m_time + ", event=" + event + "]";
	}
	
}
/*
private double lat;
private double lng;
private long m_time;
public Marker() {
	super();
}
public Marker(double lat, double lng, long m_time) {
	super();
	this.lat = lat;
	this.lng = lng;
	this.m_time = m_time;
}
public double getLat() {
	return lat;
}
public void setLat(double lat) {
	this.lat = lat;
}
public double getLng() {
	return lng;
}
public void setLng(double lng) {
	this.lng = lng;
}
public long getM_time() {
	return m_time;
}
public void setM_time(long m_time) {
	this.m_time = m_time;
}
@Override
public String toString() {
	return "Marker [lat=" + lat + ", lng=" + lng + ", m_time=" + m_time + "]";
}
*/