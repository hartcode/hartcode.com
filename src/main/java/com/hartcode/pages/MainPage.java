package com.hartcode.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.hartcode.Facebook.FacebookAPI;
import com.hartcode.Facebook.Objects.UserData;
import com.hartcode.PhotoADay.VoteDAO2;
import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;
import com.hartcode.modules.*;


public class MainPage {
	static Logger logger = Logger.getLogger(MainPage.class);
	
	protected String m_Main;
	protected String m_Title;
	protected String m_NavID;
	protected String m_Description;
	protected IMainModule m_MainModule;
	protected Boolean m_UseADS = false;
	protected HttpServletRequest m_request = null;
	
	public MainPage(IMainModule MainModule, String title, String desc, String navid,HttpServletRequest request)
	{
		m_MainModule = MainModule;
		SetTitle(title);
		SetDescription(desc);
		SetNavID(navid);
		m_UseADS = true;
		m_request = request;
	}
	public MainPage(IMainModule MainModule, String title, String desc, String navid, Boolean useads,HttpServletRequest request)
	{
		m_MainModule = MainModule;
		SetTitle(title);
		SetDescription(desc);
		SetNavID(navid);
		m_UseADS = useads;
		m_request = request;
	}
	
	public String toString()
	{
		String retval = "";
		StringBuilder sb = new StringBuilder();
		logger.debug("Start Main Page");
		VoteDAO2 va2 = null;
		String FBUserName = null;
		String FBID = null;
		UserData ud = null;
		HttpSession session = m_request.getSession(true);
		String ip  = m_request.getHeader("X-FORWARDED-FOR");  
        if(ip == null)  
        {  
        	ip = m_request.getRemoteAddr();  
        }
		Integer myuserid = null;
		myuserid = (Integer)session.getAttribute("myuserid");
		if (myuserid != null)
		{
			logger.debug("We have a hartcode userid: " + myuserid);
		try {
			logger.debug("Creating VoteDAO2 object.");
			va2 = new VoteDAO2();
			ud = va2.GetUserData(myuserid);
			va2.closeConnections();
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ud != null)
		{
			FBUserName = ud.First_Name + " " + ud.Last_Name;
			FBID = ud.ID;
		}
		else
		{
			logger.debug("No UserData pulled back");
		
		}
			
		}
		sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">");
		sb.append("<head>");
		sb.append("<title>");
		sb.append(GetTitle());
		sb.append("</title>");
		sb.append("<meta name=\"description\" content=\"");
		sb.append(GetDescription());
		sb.append("\"/>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" />");
		sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		sb.append("<link href=\"/style.1.4.2.css\" rel=\"stylesheet\" type=\"text/css\" />");
		
		sb.append("<!--[if lte IE 7]><link href=\"/style_ie7.1.0.0.css\" rel=\"stylesheet\" type=\"text/css\" /><![endif]-->");
		sb.append("<link rel=\"alternate\" type=\"application/rss+xml\" title=\"HartCode News\" href=\"http://www.hartcode.com/rss.xml\" />");
		sb.append("<script type=\"text/javascript\" src=\"/hartcode.1.0.js\"></script>");
		sb.append("<script type=\"text/javascript\" src=\"/ga.1.0.0.js\"></script>");
		sb.append("</head>");
		sb.append("<body id=\"");
		sb.append(GetNavID());
		sb.append("\">");
		sb.append("<div id=\"HeadOuter\">");
		sb.append("<div id=\"HeadInner2\"></div>");
		sb.append("<div id=\"HeadInner\"></div>");
		sb.append("<h1>HartCode</h1>");
		sb.append("</div>");
		sb.append("<div id=\"total\">");
		sb.append("<div id=\"sidebar\">");
		sb.append("<ul id=\"menu\">");
		sb.append("<li><a id=\"homeli\" href=\"/\">Home</a></li>");
		sb.append("<li><a id=\"newsli\" href=\"/news\">News</a></li>");
		sb.append("<li><a id=\"walltopli\" href=\"/wallpaper\">Wallpaper</a></li>");
		sb.append("<li class=\"indent\"><a id=\"voteli\" href=\"/wallpaper/vote\">Vote</a></li>");
		sb.append("<li><a id=\"yeastli\" href=\"/yeaststrains\">Yeast</a></li>");
		sb.append("</ul>");
		//sb.append("<div id=\"fbdiv\">");
		//if (FBID != null)
		//{
		//	sb.append("<div id=\"user-info\">");
		//	sb.append("<img src=\"https://graph.facebook.com/" + FBID + "/picture\">");
		//	sb.append(FBUserName);
		//	sb.append("</div>");
		//	sb.append("<a href=\"/Logout\" ><p id=\"fb-auth\">Logout</p></a></div>");
		//}else
		//{
		//	sb.append("<a href=\"https://www.facebook.com/dialog/oauth?client_id=161596347286085&redirect_uri=http://"+FacebookAPI.domain+"/Login&scope=email,publish_stream\"><p id=\"fb-auth\" >Login to Facebook</p></a></div>");
		//}
		sb.append("<div id=\"social\"><a href=\"http://www.twitter.com/Hartcode\"><img src=\"/images/twitter-b.png\" alt=\"Follow Hartcode on Twitter\" width=\"61\" height=\"23\"/></a></div>");
		
		if (m_UseADS)
		{
		logger.debug("Start Ad Module");
		sb.append("<div id=\"adpanel\">"+ADs.getRandomAd120x240(ip)+"</div>");
		logger.debug("End Ad Module");
		}
		
		sb.append("</div>");
		sb.append("<div id=\"main\">");
		logger.debug("Start Main Page Module");
		sb.append(m_MainModule.GetMainModule());
		logger.debug("End Main Page Module");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div id=\"footer\">");
		sb.append("  <ul>");
		sb.append("<li id=\"address\">");
		sb.append("	<br />");
		sb.append("</li>");
		sb.append("<li  class=\"center\">");
		sb.append("&#169; 2012 HartCode<br/>Bitcoin Donations: 19q6NcQqgv2obmFj2iRiugjQT9dqyhBvcr<br/>All pictures, graphics, logos are copyrighted to their respective owners.");
		sb.append("</li>");
		sb.append("<li  class=\"right\">");
		sb.append("");
		sb.append("<br />");
		sb.append("</li>");
		sb.append("</ul>");
		sb.append("</div>");
		sb.append("</body>");
		sb.append("</html>");
		retval = sb.toString();
		logger.debug("End Main Page");
		return retval;
	}

	protected void SetTitle(String title)
	{
		m_Title = title;
		// HartCode - Money Drop
	}
	public String GetTitle()
	{
		return m_Title;
	}
	protected void SetNavID(String navid)
	{
		m_NavID = navid;
	}
	public String GetNavID()
	{
		return m_NavID;
	}
	protected void SetDescription(String description)
	{
		m_Description = description;
		// Catch the money, avoid the bombs.
	}
	public String GetDescription()
	{
		return m_Description;
	}
}
