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
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public ModifyServlet(){
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		
		String input_email = request.getParameter("input_email");
		String input_name = request.getParameter("input_name");
		String password_check = request.getParameter("password_check");
		String password_new = request.getParameter("password_new");
		String password_new_confirm = request.getParameter("password_new_confirm");

		//변경될 비밀번호가 일치하지 않을 경우 0
		if(!password_new.equals(password_new_confirm)) {
			out.println(0);
			return;
		}
		
		UserManager userM = UserManager.getInstance();
		UserDTO userDTO = userM.getUser(input_email, password_check);
		
		if(userDTO!=null) {  // 아이디와 비밀번호를 찾은 경우: 1
			userDTO.setName(input_name);
			if(password_new.equals("")) { userDTO.setPwd(password_check); }
			else { userDTO.setPwd(password_new); }
			userM.updateUser(userDTO);
			session.setAttribute("userName", userDTO.getName());
			out.println(1);
			System.out.println("userDTO is -> " + userDTO);
		} else {  // 아이디나 비밀번호를 못 찾은 경우: -1

			out.println(-1);
			System.out.println("userDTO is null");
		}
		//request.getRequestDispatcher("profile.jsp").forward(request, response);
	}
}
