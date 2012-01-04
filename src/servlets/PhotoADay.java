package servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hartcode.PhotoADay.PhotoAdder;

/**
 * Servlet implementation class PhotoADay
 */
public class PhotoADay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoADay() {
       	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strdate = request.getParameter("date");
		if (strdate != null && strdate != "")
		{
			
		
		Date thedate = Date.valueOf(strdate);
		Integer PhotoID = null;
		String filename = null;
		try {
			PhotoID = PhotoAdder.GetPhotoDay(thedate);
			filename = PhotoAdder.GetPhotoFileName(PhotoID);
		} catch (Exception e) {
			PrintWriter pw = response.getWriter();
			//pw.write(thedate.toString());
			//pw.write(PhotoID);
			pw.write("exception: " + e.getMessage());
			pw.close(); 
		}
		if (filename != null)
		{
		ServletOutputStream os = response.getOutputStream();
		//FileInputStream is = new FileInputStream("/usr/java/tomcat-5.5/hartcode/ROOT/images/photos/1.jpg");
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
			PrintWriter pw = response.getWriter();
			pw.write("filename was not found");
			pw.close();
		}
		}
		else
		{
			PrintWriter pw = response.getWriter();
			pw.write("strdate was not found");
			pw.close();
		}
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

    
    


}
