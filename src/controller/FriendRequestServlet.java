package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.FriendManager;

/**
 * Servlet implementation class FriendRequestServlet
 */
public class FriendRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/utf-8");
		response.setCharacterEncoding("utf-8");
		String toUserCode = request.getParameter("toUserCode");
		HttpSession session = request.getSession();
		String uId = (String) session.getAttribute("userCode");
		int result = FriendManager.getInstance().requestFriend(uId, toUserCode);
		PrintWriter out = response.getWriter();
		if(result == 1) {
			out.write("친구요청을 보냈습니다.");
		} else {
			out.write("친구요청에 실패했습니다.");
		}
	}

}
