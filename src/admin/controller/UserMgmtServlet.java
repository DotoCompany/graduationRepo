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
import admin.dao.AdminUserDAO;
import admin.dto.AdminUser;
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
				
				UserMgmtManager userMgmt = null;
				List<UserDTO> userList = null;
				String service = "";
				service = request.getParameter("service");
				if(service==null || service.equals("")) {
					
					userMgmt = UserMgmtManager.getInstance();
					userList = userMgmt.getAllUsers();
					
					//System.out.println("test : " + userList.get(10));
					
					request.setAttribute("userList", userList);
					RequestDispatcher rd = request.getRequestDispatcher("admin/userMgmt.jsp");
					rd.forward(request, response);
					
				} else {
					
					if(service.equals("ADD")) {
						
						System.out.println(service + " " + request.getParameter("adminId"));
						AdminUserDAO.getInstance().insertUser(new AdminUser("", request.getParameter("adminId"), request.getParameter("adminPwd"),"Daesub Kim", "010-9998-2666", "","ADMIN"));
						
					} else if(service.equals("DELETE")) {
						
						String deleteUser = request.getParameter("deleteId");
						userMgmt = UserMgmtManager.getInstance();
						userMgmt.deleteUserById(deleteUser);
						response.sendRedirect("userMgmt.do");
					}
					
				}
				
				
				
				
				
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
