package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.UserDTO;
import admin.manager.UserMgmtManager;

/**
 * Servlet implementation class UserMgmtServlet
 */
public class UserMgmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			HttpSession session = request.getSession();
			/*if(session.getAttribute("userAuth").equals("ADMIN")){*/
				
				UserMgmtManager userMgmt = UserMgmtManager.getInstance();
				List<UserDTO> userList = userMgmt.getAllUsers();
				
				request.setAttribute("userList", userList);
				RequestDispatcher rd = request.getRequestDispatcher("admin/userMgmt.jsp");
				rd.forward(request, response);
				
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
