package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MessageManager;

/**
 * Servlet implementation class MessageSendServlet
 */
public class MessageSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String msg = request.getParameter("msg");
		String friendCode = request.getParameter("friendCode");
		String uId = (String)request.getSession().getAttribute("userCode");
		int result = MessageManager.getInstance().sendMsg(uId, friendCode, msg);
		PrintWriter out = response.getWriter();
		if(result==1) {
			out.write(msg);
		}
		else
			out.write("0");
		
		
	}

}
