package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MarkerManager;

import org.json.simple.JSONObject;

import util.json.MarkerJson;

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

		// DB에서 유저별로 Marker를 가져와
		// json으로 변환
		JSONObject json = MarkerJson.getInstance()
							.createJson(MarkerManager.getInstance().getMarkerByUser(uId), uId);

		
		PrintWriter pw = response.getWriter();
		pw.print(json.toString());
		pw.close();
		
		return ;
	}

}
