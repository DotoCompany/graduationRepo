package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LifeLogListDAO;
import DTO.LifeLogViewDTO;

/**
 * Servlet implementation class LifeLogListServlet
 */
public class LifeLogListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		
		ArrayList<LifeLogViewDTO> arrayList = LifeLogListDAO.getInstance().searchLifeLog();
		System.out.println("lifelogListServlet arrayList size : "+arrayList.size());
		request.setAttribute("arrayList", arrayList);
		request.getRequestDispatcher("form_gallery.jsp").forward(request, response);
	}

}
