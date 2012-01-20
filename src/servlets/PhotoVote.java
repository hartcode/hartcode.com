package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
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
	static Logger logger = Logger.getLogger(PhotoVote.class);
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
		if (logger.isDebugEnabled())
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strdate = sdf.format(thedate);
			logger.debug("Voting Date is: " + strdate);
		}
		
		VoteDAO2 va2 = null;
		try {
			logger.debug("Creating VoteDAO2 object.");
			va2 = new VoteDAO2();
			logger.debug("Finished Creating VoteDAO2 object.");
		} catch (NullArgumentException e2) {
			// TODO Auto-generated catch block
			logger.error(e2);
		} catch (InvalidPortException e2) {
			// TODO Auto-generated catch block
			logger.error(e2);
		} catch (ParserConfigurationException e2) {
			// TODO Auto-generated catch block
			logger.error(e2);
		} catch (SAXException e2) {
			// TODO Auto-generated catch block
			logger.error(e2);
		}
		if (cookies != null)
		{
			logger.debug("We got Cookies!");
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
        logger.debug("User IP is: " + ip);
		if (MyCookie == null)
		{
			logger.warn("Couldn't Find User Cookie. Creating new user.");
			String cookievalue = null;
			
			logger.debug("Creating cookie hash");
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
	    	logger.debug("Finished Creating cookie hash: " + cookievalue);
	    	
			try {
				logger.debug("Creating new user in db.");
				UserID = va2.NewUser(ip, cookievalue);
				logger.debug("Finished Creating new user in db: " + UserID);
			} catch (Exception e) {
				
				logger.error(e);
			}
			MyCookie = new Cookie("photos", cookievalue);
			MyCookie.setMaxAge(31536000);
			response.addCookie(MyCookie);
			logger.debug("Created cookie");
		}else
		{
			logger.info("Found User Cookie. Getting user data from db.");
			try 
			{
				logger.debug("Getting user from db.");
				UserID = va2.GetUserID(MyCookie.getValue());
				logger.debug("Finished Getting user from db: " + UserID);
			}
			catch (Exception e) 
			{
				logger.error(e);
			}
			if (UserID == null)
			{
				logger.warn("Couldn't find user in db. Now we have to create a new one in db.");
				try 
				{
					logger.debug("Creating new user in db.");
					UserID = va2.NewUser(ip, MyCookie.getValue());
					logger.debug("Finished Creating new user in db: " + UserID);
				} 
				catch (Exception e) 
				{
					logger.error(e);
				}
			}
		}
		
		if (UserID != null)
		{
			
			String strCandidateID = request.getParameter("cid");
			if (strCandidateID != null)
			{
				logger.info("User is Voting!");
				logger.info("for cid: " + strCandidateID);
				Integer CandidateID = Integer.valueOf(strCandidateID);
				try {
					va2.Vote(UserID,CandidateID,thedate);
					//response.sendRedirect("/photos/Vote");
				} catch (Exception e) {
					logger.error(e);
				}
			}
			
			Boolean hasvoted = false;
			try {
				
				hasvoted = va2.hasUserVotedToday(thedate, UserID);
			} catch (Exception e) {
				logger.error(e);
			}
			if (hasvoted)
			{
				logger.info("User has already voted today!");
				va2.closeConnections();
				response.sendRedirect("VoteResults");
				
			}else
			{
				logger.info("User has NOT voted yet");
				Integer[] photoIDs = null;
				Integer[] CandidateIDs = null;
				
				try {
					logger.debug("Getting Vote Options");
					photoIDs = va2.GetVoteOptions(thedate);
					CandidateIDs = va2.GetVoteCandidateIDOptions(thedate);
					logger.debug("Finished Getting Vote Options");
				} catch (Exception e) 
				{
					logger.error(e);
				}
				
				
				if (photoIDs == null)
				{
					logger.warn("Couldn't find any Vote options. Attempting to create.");
					
					try {
						logger.debug("Creating Vote Options");
						photoIDs = va2.CreateVoteOptions(thedate);
						CandidateIDs = va2.GetVoteCandidateIDOptions(thedate);
						logger.debug("Finished Creating Vote Options");
					} catch (Exception e) 
					{
						logger.error(e);					
					}
				}
				if (photoIDs != null)
				{
					response.addHeader("Content-Type", "text/html");
					PrintWriter pw = response.getWriter();
					MainPage mp = new MainPage(new PhotoVoteModule(photoIDs,CandidateIDs, UserID),"Vote - HartCode Technology Solutions","Vote for Tomorrows Photo!","vote");
					pw.write(mp.toString());
					pw.close();
				}else 
				{
					logger.error("Couldn't find any vote options! Should have had vote Options by now!");
					response.setStatus(404);
				}
				
			}

		}else
		{
			logger.error("No user.  Should have UserID by now.");
			response.setStatus(404);
		}
		va2.closeConnections();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
