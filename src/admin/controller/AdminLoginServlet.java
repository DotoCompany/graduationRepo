package admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.SessionManager;
import admin.dao.AdminUserDAO;
import admin.dto.AdminUser;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		/*AdminUserDAO.getInstance().insertUser(new AdminUser("", "daesub0515@gmail.com", "1234","Daesub Kim", "010-9998-2666", "","ADMIN"));*/
		
		String loginId = request.getParameter("adminId");
		String loginPwd = request.getParameter("adminPwd");
		
		System.out.println(loginId +" " + loginPwd);
		
		AdminUser admin = AdminUserDAO.getInstance().getUser(loginId, loginPwd);
		
		SessionManager manager=SessionManager.getInstance();
		try {
			HttpSession session = request.getSession();
			
			session.setAttribute("adminCode", admin.getaId());
			session.setAttribute("adminName",admin.getName());
			request.setAttribute("adminAuth", "ADMIN");
			

			HttpSession oldSession=manager.insert(admin.getaId(), session);
	         if(oldSession!=null && oldSession!=session)
	         {
	            oldSession.invalidate();
	         }
	         request.getRequestDispatcher("userMgmt.do").forward(request, response);
	         //request.getRequestDispatcher("markerMap.jsp").forward(request, response);
		} catch(Exception ex) {
			RequestDispatcher rd=request.getRequestDispatcher("admin/jsp/login.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
