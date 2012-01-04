package servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
			Calendar mycal = Calendar.getInstance();
			java.util.Date thedate = Date.valueOf(strdate);
			java.util.Date startdate = Date.valueOf("2012-01-01");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			mycal.add(Calendar.DATE, 1);
			java.util.Date stopdate = mycal.getTime();
			String strdate2 = sdf.format(stopdate);
			stopdate = Date.valueOf(strdate2);
		
			if (thedate.after(startdate) || thedate.equals(startdate))
			{
				if (thedate.before(stopdate) || thedate.equals(stopdate))
				{
					Integer PhotoID = null;
					String filename = null;
					try {
						PhotoID = PhotoAdder.GetPhotoDay(thedate);
						filename = PhotoAdder.GetPhotoFileName(PhotoID);
					} catch (Exception e) {
					}
					if (filename != null)
					{
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
						response.setStatus(404);
					}
				}
				else
				{
					response.setStatus(404);
					
				}
			}
			else
			{
				response.setStatus(404);
			}
		}
		else
		{
			response.setStatus(404);
		}
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

    
    


}
