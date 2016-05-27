package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDTO;

import org.json.simple.JSONObject;

import DAO.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		
		String userAgent = request.getHeader("User-Agent");
		System.out.println(userAgent);
		
		
		
		
		String loginId = request.getParameter("loginId");
		String loginPwd = request.getParameter("loginPwd");
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.searchUserByEmailAndPassword(loginId, loginPwd);
		
		
		
		response.setContentType("application/json;charset=utf-8");
		
		if (userDTO != null) {
			// 로그인 회원이 존재할 경우 (정상 처리)
			// resultCode : 0
			JSONObject loginJson = new JSONObject();
			loginJson.put("resultCode", "0");
			loginJson.put("timestamp", System.currentTimeMillis());
			loginJson.put("uID", userDTO.getuId());
			loginJson.put("name", userDTO.getName());
			loginJson.put("emailId", userDTO.getEmailId());

			PrintWriter pw = response.getWriter();
			pw.print(loginJson.toString());
			pw.close();

		} else {
			// 로그인 회원이 존재하지 않을 경우(비정상 처리)
			// resultCode : -1
			JSONObject loginJson = new JSONObject();
			loginJson.put("resultCode", "-1");
			loginJson.put("timestamp", System.currentTimeMillis());
			loginJson.put("errorCode", "");
			loginJson.put("errorDescription", "");

			PrintWriter pw = response.getWriter();
			pw.print(loginJson.toString());
			pw.close();

		}
		
	}
}
