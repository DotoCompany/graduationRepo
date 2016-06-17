package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.LifeLogDAO;
import DAO.LifeLogListDAO;
import DTO.LifeLogBodyDTO;
import DTO.LifeLogDTO;
import DTO.LifeLogPhotoDTO;
import DTO.LifeLogViewDTO;

/**
 * Servlet implementation class EditServlet
 */
@MultipartConfig
public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");

		// ADD
		if (request.getParameter("service").equals("ADD")) {

			final String dirName = this.getServletContext().getRealPath("/")
					+ File.separator + "userImage";

			/*
			 * ServletContext context = this.getServletContext(); String
			 * realPath = context.getRealPath("/"); String dirName = realPath +
			 * File.separator + "userImage";
			 */

			LifeLogDTO ll = null;
			LifeLogBodyDTO llb = null;
			LifeLogPhotoDTO llp = null;

			File dirR = new File(dirName);
			if (!dirR.exists()) {
				dirR.mkdir();
			}
			System.out.println("dirName: " + dirName);

			PrintWriter writer = response.getWriter();
			Part part = request.getPart("file");

			String completeImage = "";
			if (part.getContentType() != null) {
				String fileName = getFilename(part);
				System.out.println("fileName : " + fileName);
				if (fileName != null && !fileName.isEmpty()) {
					/*
					 * part.write(getServletContext().getRealPath("/WEB-INF") +
					 * "/"+userCode+"/" + fileName);
					 */
					/*
					 * String dir=getServletContext().getRealPath("")
					 * +File.separator+"userImage"+File.separator+fileName;
					 */

					String dir = dirName + File.separator + fileName;

					System.out.println("dir----" + dir);
					part.write(dir);
					writer.print("<br/>" + dir);
					writer.print("<br>업로드한 파일 이름: " + fileName);
					writer.print("<br/>크기: " + part.getSize());

					completeImage = File.separator + "graduationRepo"
							+ File.separator + "userImage" + File.separator
							+ fileName;

					String userCode = (String) request.getSession()
							.getAttribute("userCode");
					// String mId = request.getParameter("mId");

					if (userCode != null) {

						ll = new LifeLogDTO("", userCode,
								request.getParameter("mId"), "", "YES");

						llb = new LifeLogBodyDTO("", "",
								request.getParameter("body"), "1");

						llp = new LifeLogPhotoDTO("", "", completeImage);

						System.out.println("Life Log : "
								+ LifeLogDAO.getInstance().insertLifeLog(ll,
										llb, llp));

						RequestDispatcher rd = request
								.getRequestDispatcher("gallery.jsp");
						rd.forward(request, response);

					} else {

						request.setAttribute("isLogin", "false");
						RequestDispatcher rd = request
								.getRequestDispatcher("login.jsp");
						rd.forward(request, response);

					}

				}

			} else {
				String partName = part.getName();
				String fieldValue = new String(request.getParameter(partName)
						.getBytes("iso-8859-1"), "utf-8");
			}
		
			
		// ToMODIFY
		} else if (request.getParameter("service").equals("ToMODIFY")) {

			
			request.setAttribute("llId", request.getParameter("llId"));
			request.setAttribute("lat", request.getParameter("lat"));
			request.setAttribute("lng", request.getParameter("lng"));
			request.setAttribute("url", request.getParameter("url"));
			request.setAttribute("body", request.getParameter("body"));
			request.setAttribute("isPublic", request.getParameter("isPublic"));
			
			RequestDispatcher rd = request
					.getRequestDispatcher("markerModify.jsp");
			rd.forward(request, response);
			
			
		} else if (request.getParameter("service").equals("MODIFY")) {

			
			/***************************************/
			
			
			
			
			final String dirName = this.getServletContext().getRealPath("/")
					+ File.separator + "userImage";

			/*
			 * ServletContext context = this.getServletContext(); String
			 * realPath = context.getRealPath("/"); String dirName = realPath +
			 * File.separator + "userImage";
			 */

			LifeLogDTO ll = null;
			LifeLogBodyDTO llb = null;
			LifeLogPhotoDTO llp = null;

			File dirR = new File(dirName);
			if (!dirR.exists()) {
				dirR.mkdir();
			}
			System.out.println("dirName: " + dirName);

			PrintWriter writer = response.getWriter();
			Part part = request.getPart("file");

			String completeImage = "";
			if (part.getContentType() != null) {
				String fileName = getFilename(part);
				System.out.println("fileName : " + fileName);
				if (fileName != null && !fileName.isEmpty()) {
					/*
					 * part.write(getServletContext().getRealPath("/WEB-INF") +
					 * "/"+userCode+"/" + fileName);
					 */
					/*
					 * String dir=getServletContext().getRealPath("")
					 * +File.separator+"userImage"+File.separator+fileName;
					 */

					String dir = dirName + File.separator + fileName;

					System.out.println("dir----" + dir);
					part.write(dir);
					writer.print("<br/>" + dir);
					writer.print("<br>업로드한 파일 이름: " + fileName);
					writer.print("<br/>크기: " + part.getSize());

					completeImage = File.separator + "graduationRepo"
							+ File.separator + "userImage" + File.separator
							+ fileName;

					String userCode = (String) request.getSession()
							.getAttribute("userCode");
					// String mId = request.getParameter("mId");

					if (userCode != null) {


						LifeLogDAO.getInstance().modifyLifeLog(
								request.getParameter("llId"), "YES", 
								request.getParameter("modifyBody"), completeImage);
						response.sendRedirect("gallery.jsp");

					} else {

						request.setAttribute("isLogin", "false");
						RequestDispatcher rd = request
								.getRequestDispatcher("login.jsp");
						rd.forward(request, response);

					}

				}

			} else {
				String partName = part.getName();
				String fieldValue = new String(request.getParameter(partName)
						.getBytes("iso-8859-1"), "utf-8");
			}
			
		
		// DELETE
		} else if (request.getParameter("service").equals("DELETE")) {
			LifeLogDAO.getInstance().deleteLifeLog(request.getParameter("llId"));
			response.sendRedirect("gallery.jsp");
			
		// GET
		} else if (request.getParameter("service").equals("GET")) {

			LifeLogViewDTO lifeLogViewDTO = LifeLogListDAO.getInstance()
					.searchLifeLogById(request.getParameter("llId"));

			System.out.println(lifeLogViewDTO);
			request.setAttribute("lifeLogViewDTO", lifeLogViewDTO);

			/* response.sendRedirect("/markerView.jsp"); */

			RequestDispatcher rd = request
					.getRequestDispatcher("markerView.jsp");
			rd.forward(request, response);

			return;
		}

	}

	// 파일명 얻기
	private String getFilename(Part part) {
		String contentDispositionHeader = part.getHeader("content-disposition");
		String name = null;
		String[] elements = contentDispositionHeader.split(";");
		for (String element : elements) {
			System.out.println("element : " + element);
			if (element.trim().startsWith("name")) {
				name = element.substring(element.indexOf('=') + 1).trim()
						.replace("\"", "");

			} else if (element.trim().startsWith("filename")) {
				return element.substring(element.indexOf('=') + 1).trim()
						.replace("\"", "");

			}
		}
		return null;
	}

}
