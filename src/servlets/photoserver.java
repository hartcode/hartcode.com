package servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hartcode.PhotoADay.PhotoAdder;

/**
 * Servlet implementation class photoserver
 */
public class photoserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public photoserver() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strphotoid = request.getParameter("id");
		String strphotowidth = request.getParameter("width");
		String strphotoheight = request.getParameter("height");
		
		
		
		Integer photoid = Integer.valueOf(strphotoid);
		String filename = null;
		try {
			if (strphotowidth != null)
			{
			Integer photowidth = Integer.valueOf(strphotowidth);
			Integer photoheight = Integer.valueOf(strphotoheight);
			if (photowidth < 240)
			{
				photowidth = 240;
			}
			if (photoheight < 200)
			{
				photoheight = 200;
			}
			filename = PhotoAdder.GetPhotoFileName(photoid,photoheight,photowidth);
			}
			else {
				filename = PhotoAdder.GetPhotoFileName(photoid);	
			}
			
		} catch (Exception e) {
			PrintWriter pw = response.getWriter();
			pw.write(e.getMessage());
			pw.write(e.getStackTrace().toString());
			pw.close();
		}
		if (filename != null)
		{
			response.setContentType("image/jpeg");
			ServletOutputStream os = response.getOutputStream();
			//	FileInputStream is = new FileInputStream("/usr/java/tomcat-5.5/hartcode/ROOT/images/photos/1.jpg");
			FileInputStream is = new FileInputStream(filename);
			int b = is.read();
			while(b!= -1)
			{
				os.write(b);
				b = is.read();
			}
			is.close();
			os.close();
		}else
		{
			//response.setStatus(404);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
