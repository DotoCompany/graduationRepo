package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.UserManager;

import org.json.simple.JSONObject;

import DAO.UserDAO;
import DTO.UserDTO;

/**
 * Servlet implementation class RegisterServlet
 */
public class CheckIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public CheckIDServlet(){
		super();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		
		
		String email = request.getParameter("email");
		
		if(email.equals("")) {
			response.getWriter().println(-1);
			return;
		}
		
		UserManager userM = UserManager.getInstance();
		int resultCode = userM.getUser(email); // 1이면 아이디 있는거  / 0 이면 아이디 없는거
		
		response.getWriter().println(resultCode);
	}
}
