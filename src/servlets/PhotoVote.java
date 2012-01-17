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
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import modules.PhotoVoteModule;

import pages.MainPage;


import com.hartcode.PhotoADay.*;
import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;

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
		VoteDAO2 va2 = null;
		try {
			va2 = new VoteDAO2();
		} catch (NullArgumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InvalidPortException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ParserConfigurationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SAXException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (cookies != null)
		{
		for( int i =0; i < cookies.length; i++)
		{
			if (cookies[i].getName().equals("photos"))
			{
				MyCookie = cookies[i];
			}
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
				UserID = va2.NewUser(ip, cookievalue);
			} catch (Exception e) {
				
				pw.write(e.getMessage());
				pw.write(e.getStackTrace().toString());

			}
			MyCookie = new Cookie("photos", cookievalue);
			MyCookie.setMaxAge(31536000);
			response.addCookie(MyCookie);
		}else
		{
			try {
				UserID = va2.GetUserID(MyCookie.getValue());

			} catch (Exception e) {
			}
			if (UserID == null)
			{try {
				UserID = va2.NewUser(ip, MyCookie.getValue());
			} catch (Exception e) {
			}
			}
		}
		
		if (UserID != null)
		{
			String strCandidateID = request.getParameter("cid");
			if (strCandidateID != null)
			{
				Integer CandidateID = Integer.valueOf(strCandidateID);
				try {
					va2.Vote(UserID,CandidateID,thedate);
					//response.sendRedirect("/photos/Vote");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			Boolean hasvoted = false;
			try {
				//Date starttime = mycal.getTime();
				hasvoted = va2.hasUserVotedToday(thedate, UserID);
				//Date endtime = mycal.getTime();
				//pw.write(endtime.getDate() - starttime.getDate());
				//pw.write(endtime);
			} catch (Exception e) {
				
				pw.write(e.getMessage());
				pw.write(e.getStackTrace().toString());
				
			}
			if (hasvoted)
			{
				va2.closeConnections();
				response.sendRedirect("/VoteResults");
				
			}else
			{
				
				Integer[] photoIDs = null;
				Integer[] CandidateIDs = null;
				try {
					photoIDs = va2.GetVoteOptions(thedate);
					CandidateIDs = va2.GetVoteCandidateIDOptions(thedate);
				} catch (Exception e) {
					
					pw.write(e.getMessage());
					pw.write(e.getStackTrace().toString());
					
				}
				
				if (photoIDs == null)
				{
					try {
						photoIDs = va2.CreateVoteOptions(thedate);
						CandidateIDs = va2.GetVoteCandidateIDOptions(thedate);
					} catch (Exception e) {
						pw.write(e.getMessage());
						pw.write(e.getStackTrace().toString());
					
					}
				}
				if (photoIDs != null)
				{
					response.addHeader("Content-Type", "text/html");
					MainPage mp = new MainPage(new PhotoVoteModule(photoIDs,CandidateIDs, UserID),"Vote - HartCode Technology Solutions","Vote for Tomorrows Photo!","vote");
					pw.write(mp.toString());
				}		
				
			}

		}
		va2.closeConnections();
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
