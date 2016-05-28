package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MarkerManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import DTO.MarkerDTO;

/**
 * Servlet implementation class MarkerServlet
 */
public class MarkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json;charset=utf-8");
		//String userAgent = request.getHeader("User-Agent").split("/")[0];
		
		String uId = request.getParameter("uId");
		
		JSONObject json = null;//new JSONObject();
		JSONObject markerJson = null;
		JSONObject markerWrap = null;
		JSONArray markerArr = null;//new JSONArray();
		
		List<MarkerDTO> markerList = null;//MarkerManager.getInstance().getMarkerByUser(loginId);
		
		try {
			json = new JSONObject();
			markerArr = new JSONArray();
			markerList = MarkerManager.getInstance().getMarkerByUser(uId);
			
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
			
		} catch(NullPointerException npe) {
			npe.printStackTrace();
			json.put("resultCode", "0");
			json.put("errorCode", "");
			json.put("errorDescription", "");
			
		} finally {
			PrintWriter pw = response.getWriter();
			pw.print(json.toString());
			pw.close();
		}
		return ;
	}

}
