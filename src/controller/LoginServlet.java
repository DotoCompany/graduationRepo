package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import DAO.UserDAO;
import DTO.UserDTO;
import model.SessionManager;

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
<<<<<<< HEAD
		
		
		String userAgent = request.getHeader("User-Agent");
		System.out.println(userAgent);
		
		
		
		
		String loginId = request.getParameter("loginId");
		String loginPwd = request.getParameter("loginPwd");
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.searchUserByEmailAndPassword(loginId, loginPwd);
		
		
		
		response.setContentType("application/json;charset=utf-8");
=======
		response.setContentType("application/json;charset=utf-8");
		//System.out.println("로긴 와쪙");
		String loginId = request.getParameter("loginId");
		String loginPwd = request.getParameter("loginPwd");
		
		String userAgent = request.getHeader("User-Agent").split("/")[0];
		
		
		System.out.println(userAgent);
		
		System.out.println("요청온 아이디 : "+loginId);
		System.out.println("요청온 패스워드 : "+loginPwd);
		
		
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.searchUserByEmailAndPassword(loginId, loginPwd);
		
>>>>>>> 78b0f2b14f559ff45cbcbbb99826201f4c83bd22
		
		JSONObject loginJson = new JSONObject();
		/*---------------모바일을 사용하는 경우 --------------------*/
		if ( userAgent.toLowerCase().equals("okhttp")  ) {
			try {
				loginJson.put("resultCode", "1");
				loginJson.put("timestamp", System.currentTimeMillis());
				loginJson.put("uID", userDTO.getuId());
				loginJson.put("name", userDTO.getName());
				loginJson.put("emailId", userDTO.getEmailId());
				
			} catch(NullPointerException npe) {
				npe.printStackTrace();
				loginJson.put("resultCode", "0");
				loginJson.put("errorCode", "");
				loginJson.put("errorDescription", "");
			} finally {
				PrintWriter pw = response.getWriter();
				pw.print(loginJson.toString());
				pw.close();
			}
			return ;
		} // if end.	
		/*------------------------모바일 외의 브라우저를 사용하는 경우 ----------------------*/
		
		
		SessionManager manager=SessionManager.getInstance();
		try {
			HttpSession session = request.getSession();
			System.out.println("--1--");
			session.setAttribute("userCode", userDTO.getuId());
			System.out.println("--2--");
			session.setAttribute("userEmail",userDTO.getEmailId());
			System.out.println("--3--");
			session.setAttribute("userName",userDTO.getName());
			System.out.println(userDTO.getName());
			System.out.println("--4--");
			request.setAttribute("isLogin", "true");
			System.out.println("--5--");

			HttpSession oldSession=manager.insert(userDTO.getuId(), session);
	         if(oldSession!=null && oldSession!=session)
	         {
	            oldSession.invalidate();
	         }
	         request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch(Exception ex) {
			request.setAttribute("isLogin", "false");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
	}
	
}
