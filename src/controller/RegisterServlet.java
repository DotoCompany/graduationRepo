package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;

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
		String email = request.getParameter("muEmailId");
		String name = request.getParameter("muNickname");
		String password = request.getParameter("muPasswordForm");
		UserDAO userDAO = UserDAO.getInstance();
		int resultCode = userDAO.insertUser(email,name,password);
		if(resultCode==1)
			System.out.println("insert ¼º°ø");
		else
			System.out.println("insert fail");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
