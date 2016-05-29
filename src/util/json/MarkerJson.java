package util.json;

import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import DTO.MarkerDTO;;

public class MarkerJson {
	
	public static final MarkerJson instance;
	static {
		instance = new MarkerJson();
	}
	
	private MarkerJson() {
		// TODO Auto-generated constructor stub
	}
	
	public static MarkerJson getInstance() {
		return instance;
	}
	
	public JSONObject createJson(List<MarkerDTO> markerList, String uId) {
		
		JSONObject json = null;
		
		if(markerList != null) {
			
			JSONObject markerJson = null;
			JSONObject markerWrap = null;
			JSONArray markerArr = null;
			
			try {
				// Marker 정상처리 Json
				json = new JSONObject();
				markerArr = new JSONArray();
				
				json.put("resultCode", "1");
				json.put("timestamp", System.currentTimeMillis());
				json.put("uID", uId);
				
				for(MarkerDTO marker : markerList) {
					
					markerJson = new JSONObject();
					markerJson.put("m_id", marker.getmId());
					markerJson.put("address", marker.getAddress());
					markerJson.put("lat", marker.getLat());
					markerJson.put("lng", marker.getLng());
					markerJson.put("m_time", marker.getM_time());
					
					markerWrap = new JSONObject();
					markerWrap.put("marker", markerJson);
					
					markerArr.add(markerWrap);
				}
				json.put("markers", markerArr);
				
				return json;
			} catch (NullPointerException npe) {
				npe.printStackTrace();
				// error Json
				json.put("resultCode", "0");
				json.put("errorCode", "");
				json.put("errorDescription", "");
				
				return json;
			} catch (Exception e) {
				e.printStackTrace();
				// error Json
				json.put("resultCode", "0");
				json.put("errorCode", "");
				json.put("errorDescription", "");
				
				return json;
			}
		}
		
		// error Json
		json.put("resultCode", "0");
		json.put("errorCode", "");
		json.put("errorDescription", "");
		
		return json;
		
	}
	
	

}
