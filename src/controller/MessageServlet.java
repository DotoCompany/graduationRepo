package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.MessageDTO;
import manager.MessageManager;

/**
 * Servlet implementation class MessageServlet
 */
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/utf-8");
		
		String friendCode = request.getParameter("friendCode");
		String friendImage = request.getParameter("friendImage");
		HttpSession session = request.getSession();
		String userCode = (String) session.getAttribute("userCode");
		
		ArrayList<MessageDTO> arrayList = MessageManager.getInstance().getMessage(userCode, friendCode);
		
		for(int i=0;i<arrayList.size();i++) {
			System.out.println(arrayList.get(i).getBody());
		}
		request.setAttribute("arrayList", arrayList);
		request.setAttribute("friendImage",friendImage);
		request.setAttribute("friendCode", friendCode);
		request.getRequestDispatcher("form_message.jsp").forward(request, response);
		
		
	}

}
