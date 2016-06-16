package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class EditServlet
 */
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath("/");
		String dirName = realPath + File.separator + "uploadFiles";
		File dirR = new File(dirName);
		if (!dirR.exists()) {
		dirR.mkdir();
		}
		System.out.println("dirName: " + dirName);
		
		PrintWriter writer=response.getWriter();
		Part part = request.getPart("file");
		
		String completeImage="";
		if (part.getContentType() != null) {
			String fileName = getFilename(part);
			System.out.println("fileName : "+fileName);
			if (fileName != null && !fileName.isEmpty()) {
				/*part.write(getServletContext().getRealPath("/WEB-INF")
						+ "/"+userCode+"/" + fileName);*/
				String dir=getServletContext().getRealPath("")
						+File.separator+"userImage"+File.separator+fileName;
				
				System.out.println("dir----"+dir);
				part.write(dir);
				writer.print("<br/>"+dir);
				writer.print("<br>업로드한 파일 이름: " + fileName);
				writer.print("<br/>크기: " + part.getSize());
				
					completeImage=File.separator+"graduationRepo"+File.separator+"userImage"+File.separator+fileName;
					
			}
			

		} else {
			String partName = part.getName();
			String fieldValue = new String(request.getParameter(partName)
					.getBytes("iso-8859-1"), "utf-8"); 
		}
		
		
	}

    //파일명 얻기    
	private String getFilename(Part part) {
		String contentDispositionHeader = part.getHeader("content-disposition");
		String name=null;
		String[] elements = contentDispositionHeader.split(";"); 
		for (String element : elements) {
			System.out.println("element : "+element);
			if (element.trim().startsWith("name")) {
				name= element.substring(element.indexOf('=') + 1).trim()
						.replace("\"", "");

			}
			else if (element.trim().startsWith("filename")) {
				return element.substring(element.indexOf('=') + 1).trim()
						.replace("\"", "");

			}
		}
		return null;
	}

}
