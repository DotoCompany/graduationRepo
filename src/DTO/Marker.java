package DTO;

public class Marker {
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
	
}
