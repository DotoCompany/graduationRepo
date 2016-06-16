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
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public LeaveServlet(){
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i = -1;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String input_email = request.getParameter("input_email");
		String password_check2 = request.getParameter("password_check2");

		UserManager userM = UserManager.getInstance();

		i = userM.deleteUser(input_email, password_check2);
		if(i==1) { // È¸¿øÅ»Åð ¼º°ø
			HttpSession session = request.getSession();
			session.invalidate();
		} else if(i==0) { // È¸¿øÅ»Åð ½ÇÆÐ
			//¹»...ÇØ¾ßÇÏÁö?
		}
		out.println(i); // È¸¿øÅ»Åð ¼º°ø½Ã 1 / ½ÇÆÐ½Ã 0
	}
}