package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import DTO.Marker;
import manager.MarkerManager;
import util.json.MarkerJson;
/**
 * Servlet implementation class MarkerServlet
 */
public class MarkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * http://huskdoll.tistory.com/6
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("application/json;charset=utf-8");
		//String userAgent = request.getHeader("User-Agent").split("/")[0];
		
		String service =request.getParameter("service");
		String uId = request.getParameter("uId");
		System.out.println("uId : "+uId);	
		
		if(service!=null) {
			System.out.println("MarkerServlet - service start");
			insert(request,uId);
		}
		else{
			// DB에서 유저별로 Marker를 가져와
			// json으로 변환
			JSONObject json = MarkerJson.getInstance().createJson(MarkerManager.getInstance().getMarkerByUser(uId), uId);

			
			PrintWriter pw = response.getWriter();
			System.out.println(json);
			pw.print(json.toString());
			pw.close();	
		}
	
	}
	private void insert(HttpServletRequest request,String uId){
		//merkers String값 받아옴.
		String markers = request.getParameter("markers");
		
		//
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject= null;
		JSONArray markersArray = null;
		ArrayList<Marker> arrayList = new ArrayList<Marker>();
		try {
			jsonObject = (JSONObject)jsonParser.parse(markers);
			markersArray = (JSONArray) jsonObject.get("markers"); 
		} catch(Exception e) {
			e.printStackTrace();
		}
		for(int i=0;i<markersArray.size();i++) {
			jsonObject = (JSONObject)markersArray.get(i);
			arrayList.add(new Marker((String)jsonObject.get("lat"),(String)jsonObject.get("lng") , (String)jsonObject.get("m_time") ,(String)jsonObject.get("event") ));
		}
		MarkerManager.getInstance().insertMarker(uId,arrayList);
	}

}
