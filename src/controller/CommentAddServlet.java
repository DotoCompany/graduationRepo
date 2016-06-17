package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CommentDAO;

/**
 * Servlet implementation class CommentAddServlet
 */
public class CommentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/utf-8");
		String commentText = request.getParameter("commentText");
		System.out.println("comment - "+commentText);
		String llId = request.getParameter("llId");
		System.out.println(llId);
		HttpSession session = request.getSession();
		int uId = Integer.parseInt((String)session.getAttribute("userCode"));
		
		CommentDAO.getInstance().insertComment(Integer.parseInt(llId), commentText, 0, 0, 0,uId);
		request.getRequestDispatcher("").forward(request, response);
		PrintWriter out = response.getWriter();
		out.write("1");
	}

}