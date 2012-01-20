package servlets;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hartcode.PhotoADay.PhotoAdder2;

/**
 * Servlet implementation class photoserver
 */
public class photoserver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(photoserver.class);
	static int MIN_WIDTH = 240;
	static int MIN_HEIGHT = 200;
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
		logger.debug("Get Photoserver");
		logger.debug("param id: " + strphotoid);
		logger.debug("param width: "+  strphotowidth);
		logger.debug("param height: " + strphotoheight);
		
		Integer photoid = Integer.valueOf(strphotoid);
		String filename = null;
		try {
			PhotoAdder2 pa2 = new PhotoAdder2();
			if (strphotowidth != null)
			{
				Integer photowidth = Integer.valueOf(strphotowidth);
				Integer photoheight = Integer.valueOf(strphotoheight);
				if (photowidth < MIN_WIDTH)
				{
					logger.warn("Width ("+strphotowidth+") is less than min. Changing to be equal to Minimum  (" + MIN_WIDTH +")");
					photowidth = MIN_WIDTH;
				}
				if (photoheight < MIN_HEIGHT)
				{
					logger.warn("Height ("+strphotoheight+") is less than min. Changing to be equal to Minimum  (" + MIN_HEIGHT +")");
					photoheight = MIN_HEIGHT;
				}
				filename = pa2.GetPhotoFileName(photoid,photoheight,photowidth);
			}
			else 
			{
				filename = pa2.GetPhotoFileName(photoid);	
			}
			logger.debug("Begin Closing Connection");
			pa2.closeConnections();
			logger.debug("Closed Connection");
		} catch (Exception e) {
			logger.error("There was an error getting the photo filename.",e);
			logger.error("param id: " + strphotoid);
			logger.error("param width: "+  strphotowidth);
			logger.error("param height: " + strphotoheight);
		}
		if (filename != null)
		{
			logger.debug("Found Image filename: " + filename);
			response.setContentType("image/jpeg");
			
			logger.debug("Opening Image File");
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
			logger.debug("Finished Opening Image File");
		}else
		{
			logger.error("Couldn't find FileName. Should have had a FileName by now.");
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
