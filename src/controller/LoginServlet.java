package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.SessionManager;
import manager.UserManager;

import org.json.simple.JSONObject;

import DTO.UserDTO;

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

		response.setContentType("application/json;charset=utf-8");
		
		String loginId = request.getParameter("loginId");
		String loginPwd = request.getParameter("loginPwd");
		
		String userAgent = request.getHeader("User-Agent").split("/")[0];
		
		System.out.println(userAgent);
		System.out.println("��û�� ���̵� : "+loginId);
		System.out.println("��û�� �н����� : "+loginPwd);
		
		UserManager userM = UserManager.getInstance();
		UserDTO userDTO = userM.getUser(loginId, loginPwd);
		
		System.out.println(" userDTO : " + userDTO);

 		if(userDTO==null) {  // �α��� ���н�
 			response.getWriter().println(-1);
 		} else {  // �α��� ������
 			response.getWriter().println(1);
 		}
			
		
		JSONObject loginJson = new JSONObject();
		/*---------------������� ����ϴ� ��� --------------------*/
		if ( userAgent.toLowerCase().equals("okhttp")  ) {
			try {
				loginJson.put("resultCode", "1");
				loginJson.put("timestamp", System.currentTimeMillis());
				loginJson.put("uId", userDTO.getuId());
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
		/*------------------------����� ���� �������� ����ϴ� ��� ----------------------*/
		
		
		SessionManager manager=SessionManager.getInstance();
		try {
			HttpSession session = request.getSession();
			
			session.setAttribute("userCode", userDTO.getuId());
			session.setAttribute("userEmail",userDTO.getEmailId());
			session.setAttribute("userName",userDTO.getName());
			request.setAttribute("isLogin", "true");
			

			HttpSession oldSession=manager.insert(userDTO.getuId(), session);
	         if(oldSession!=null && oldSession!=session)
	         {
	            oldSession.invalidate();
	         }
	         request.getRequestDispatcher("main.jsp").forward(request, response);
	         //request.getRequestDispatcher("markerMap.jsp").forward(request, response);
		} catch(Exception ex) {
			request.setAttribute("isLogin", "false");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
}
