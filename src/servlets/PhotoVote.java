package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modules.PhotoVoteModule;

import pages.MainPage;

import sun.util.resources.TimeZoneNames;

import com.hartcode.PhotoADay.*;

/**
 * Servlet implementation class PhotoVote
 */
public class PhotoVote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoVote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie MyCookie = null;
		Integer UserID = null;
		Cookie[] cookies = request.getCookies();
		Calendar mycal = Calendar.getInstance();
		mycal.setTimeZone(TimeZone.getTimeZone("UTC"));
		mycal.add(Calendar.DATE, 1);
		Date thedate = mycal.getTime();
		PrintWriter pw = response.getWriter();
		for( int i =0; i < cookies.length; i++)
		{
	
			if (cookies[i].getName().equals("photos"))
			{
				MyCookie = cookies[i];
			}
		}
		String ip  = request.getHeader("X-FORWARDED-FOR");  
        if(ip == null)  
        {  
        	ip = request.getRemoteAddr();  
        }  

		if (MyCookie == null)
		{
			String cookievalue = null;
			
			MessageDigest md = null;
	    	byte[] digest = null;
	    	try {
				md = MessageDigest.getInstance("SHA-512");
				String hashstring = ip + thedate.toString() + "Salt";
				md.update(hashstring.getBytes("UTF-8"));
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			StringBuffer hexString = new StringBuffer();
			digest = md.digest();
	    	for (int i=0;i<digest.length;i++) {
	    		String hex=Integer.toHexString(0xff & digest[i]);
	   	     	if(hex.length()==1) hexString.append('0');
	   	     	hexString.append(hex);
	    	}
	    	cookievalue = hexString.toString();
			
			try {
				UserID = VoteDAO.NewUser(ip, cookievalue);
			} catch (Exception e) {
				
				pw.write(e.getMessage());
				pw.write(e.getStackTrace().toString());

			}
			MyCookie = new Cookie("photos", cookievalue);
			MyCookie.setDomain(".hartcode.com");
			MyCookie.setMaxAge(31536000);
			response.addCookie(MyCookie);
		}else
		{
			try {
				UserID = VoteDAO.GetUserID(MyCookie.getValue());

			} catch (Exception e) {
			}
			if (UserID == null)
			{try {
				UserID = VoteDAO.NewUser(ip, MyCookie.getValue());
			} catch (Exception e) {
			}
			}
		}
		
		if (UserID != null)
		{
			Boolean hasvoted = false;
			try {
				hasvoted = VoteDAO.hasUserVotedToday(thedate, UserID);
			} catch (Exception e) {
				
				pw.write(e.getMessage());
				pw.write(e.getStackTrace().toString());
				
			}
			if (hasvoted)
			{
				
				pw.write("true");
				
				
			}else
			{
				Integer[] photoIDs = null;
				try {
					photoIDs = VoteDAO.GetVoteOptions(thedate);
				} catch (Exception e) {
					
					pw.write(e.getMessage());
					pw.write(e.getStackTrace().toString());
					
				}
				
				if (photoIDs == null)
				{
					try {
						photoIDs = VoteDAO.CreateVoteOptions(thedate);
					} catch (Exception e) {
						pw.write(e.getMessage());
						pw.write(e.getStackTrace().toString());
					
					}
				}
				if (photoIDs != null)
				{
					response.addHeader("Content-Type", "text/html");
					MainPage mp = new MainPage(new PhotoVoteModule(photoIDs),"Photo Vote","Vote for Tomorrows Photo!","Vote");
					pw.write(mp.toString());
				}		
				
			}

		}
		
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
