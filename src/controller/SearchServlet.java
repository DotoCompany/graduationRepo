package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UserDTO;
import manager.UserManager;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/utf-8");
		String searchBox = request.getParameter("searchBox");
		
		/*System.out.println("searchBox : "+searchBox);*/
		
		ArrayList<UserDTO> arrayList = UserManager.getInstance().searchUser(searchBox);
		
		/*System.out.println("search friend size : "+arrayList.size());
		for(int i=0;i<arrayList.size();i++) {
			System.out.println("name - "+arrayList.get(i).getName());
		}*/
		
		request.setAttribute("friends", arrayList);
		request.getRequestDispatcher("form_search.jsp").forward(request, response);
	}

}
