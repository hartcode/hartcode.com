package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hartcode.PhotoADay.PhotoAdder2;

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
			mycal.setTimeZone(TimeZone.getTimeZone("UTC"));
			java.util.Date thedate = Date.valueOf(strdate);
			java.util.Date startdate = Date.valueOf("2012-01-01");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date stopdate = mycal.getTime();
			String strdate2 = sdf.format(stopdate);
			stopdate = Date.valueOf(strdate2);
			PhotoAdder2 pa2 = null;
			if (thedate.after(startdate) || thedate.equals(startdate))
			{
				if (thedate.before(stopdate) || sdf.format(thedate).equals(sdf.format(stopdate)))
				{
					Integer PhotoID = null;
					
					try {
						pa2 = new PhotoAdder2();
						PhotoID = pa2.GetPhotoDay(thedate);
						pa2.closeConnections();
					} catch (Exception e) {
					}finally
					{
						if (pa2 != null)
							{
								pa2.closeConnections();
							}
							
					}
					if (PhotoID != null)
					{
						 RequestDispatcher rd = request.getRequestDispatcher("/photoserver?id=" + PhotoID.toString());
						  rd.forward(request, response);
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
