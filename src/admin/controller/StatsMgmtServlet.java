package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.manager.StatsMgmtManager;
import admin.dto.UserStatsDTO;

/**
 * Servlet implementation class StatsMgmtServlet
 */
public class StatsMgmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			HttpSession session = request.getSession();
			/*if(session.getAttribute("adminAuth").equals("ADMIN")){*/
			
			
			
			List<UserStatsDTO> userStats = StatsMgmtManager.getInstance().getUserStats();
			for(UserStatsDTO qua : userStats) {
				request.setAttribute("qua"+qua.getQuarter(), qua.getUserCnt());
			}
			
			for(int i=1; i<=4; i++) {
				if(request.getAttribute("qua"+i)==null) {
					request.setAttribute("qua"+i, "0");
				}
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("admin/userQuarterStats.jsp");
			rd.forward(request, response);
			
			/*}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
