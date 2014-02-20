package com.hartcode.pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

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
	
	public MainPage(IMainModule MainModule,  String navid,HttpServletRequest request)
	{
		m_MainModule = MainModule;
		SetTitle(m_MainModule.GetTitle());
		SetDescription(m_MainModule.GetDescription());
		SetNavID(navid);
		m_UseADS = true;
		m_request = request;
	}
	public MainPage(IMainModule MainModule,  String navid, Boolean useads,HttpServletRequest request)
	{
		m_MainModule = MainModule;
		SetTitle(m_MainModule.GetTitle());
		SetDescription(m_MainModule.GetDescription());
		SetNavID(navid);
		m_UseADS = useads;
		m_request = request;
	}
	
	public String toString()
	{
		String retval = "";
		StringBuilder sb = new StringBuilder();
		logger.debug("Start Main Page");
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
		}
		sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">");
		sb.append("<head>");
		sb.append("<title>");
		sb.append(GetTitle());
		sb.append("</title>");
		sb.append("<meta name=\"description\" content=\"");
		sb.append(GetDescription());
		sb.append("\"/>");
		sb.append("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"/favicon.ico\" />");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" />");
		sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		sb.append("<link href=\"/style.1.4.4.css\" rel=\"stylesheet\" type=\"text/css\" />");
		
		sb.append("<!--[if lte IE 7]><link href=\"/style_ie7.1.0.0.css\" rel=\"stylesheet\" type=\"text/css\" /><![endif]-->");
		sb.append("<link rel=\"alternate\" type=\"application/rss+xml\" title=\"HartCode News\" href=\"/rss.xml\" />");
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
		sb.append("<div id=\"social\">");
		sb.append("<a class=\"twitter-timeline\" data-dnt=\"true\" href=\"https://twitter.com/hartalex0\" data-widget-id=\"375935069124173824\">Tweets by @hartalex0</a><script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+\"://platform.twitter.com/widgets.js\";fjs.parentNode.insertBefore(js,fjs);}}(document,\"script\",\"twitter-wjs\");</script>");
		sb.append("</div>");
		
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
