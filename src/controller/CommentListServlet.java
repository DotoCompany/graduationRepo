package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CommentDAO;
import DTO.CommentViewDTO;

/**
 * Servlet implementation class CommentListServlet
 */
public class CommentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String lifeLogCode = request.getParameter("lifeLogCode");
		ArrayList<CommentViewDTO> arrayList = CommentDAO.getInstance().getComment(lifeLogCode);
		request.setAttribute("arrayList", arrayList);
		request.setAttribute("lifeLogCode", lifeLogCode);
		request.getRequestDispatcher("form_comment.jsp").forward(request, response);
	}

}
