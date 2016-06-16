package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.SessionManager;

/**
 * Servlet implementation class AdminLogoutServlet
 */
public class AdminLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
	      String userCode=(String)session.getAttribute("adminCode");
	      SessionManager manager=SessionManager.getInstance();
	      manager.insert(userCode, null);
	      session.invalidate();
	      response.sendRedirect("admin/jsp/login.jsp");
	}
}
