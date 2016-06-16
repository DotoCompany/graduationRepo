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
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public RegisterServlet(){
		super();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String isCheck = request.getParameter("isCheck");
		int resultCode = -1;
		
		UserManager userM = UserManager.getInstance();
		if(isCheck.equals("true")) {
			resultCode = userM.insertUser(email,name,password);
			resultCode = 1;
		}
		response.getWriter().println(resultCode);
		
		String userAgent = request.getHeader("User-Agent").split("/")[0];
		
		/*---------------¸ð¹ÙÀÏ ¾Û --------------------*/
		if(userAgent.equals("okhttp")) {
			JSONObject registerJson = new JSONObject();
			if(resultCode==1)
				registerJson.put("resultCode", "1");
			else
				registerJson.put("resultCode","0");
			return ;
		}
	}
}