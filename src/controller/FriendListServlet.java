package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.FriendDTO;
import manager.FriendManager;

/**
 * Servlet implementation class FriendListServlet
 */
public class FriendListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/utf-8");
		
		HttpSession session = request.getSession();
		String userCode = (String) session.getAttribute("userCode");
		ArrayList<FriendDTO> arrayList = FriendManager.getInstance().getFriends(userCode);
		for(int i=0;i<arrayList.size();i++) {
			System.out.println(arrayList.get(i).toString());
		}
		
		
		request.setAttribute("friends", arrayList);
		
		request.getRequestDispatcher("form_friend.jsp").forward(request, response);
		
		
	}

}
