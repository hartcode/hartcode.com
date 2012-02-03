package com.hartcode.pages;

import org.apache.log4j.Logger;

import com.hartcode.modules.*;


public class VotePage {
	static Logger logger = Logger.getLogger(VotePage.class);
	
	protected String m_Main;
	protected String m_Title;
	protected String m_NavID;
	protected String m_Description;
	protected IMainModule m_MainModule;
	protected Boolean m_UseADS = false;
	
	public VotePage(IMainModule MainModule, String title, String desc, String navid)
	{
		m_MainModule = MainModule;
		SetTitle(title);
		SetDescription(desc);
		SetNavID(navid);
		m_UseADS = false;
	}
	public VotePage(IMainModule MainModule, String title, String desc, String navid, Boolean useads)
	{
		m_MainModule = MainModule;
		SetTitle(title);
		SetDescription(desc);
		SetNavID(navid);
		m_UseADS = useads;
	}
	
	public String toString()
	{
		String retval = "";
		StringBuilder sb = new StringBuilder();
		logger.debug("Start Main Page");
		sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\" xmlns:fb=\"https://www.facebook.com/2008/fbml\">");
		sb.append("		 <head prefix=\"og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# hartcode: http://ogp.me/ns/fb/hartcode#\">");
			sb.append("<meta property=\"fb:app_id\"      content=\"161596347286085\" /> ");
		sb.append("<meta property=\"og:type\"        content=\"hartcode:wallpaper\" /> ");
		sb.append("<meta property=\"og:url\"         content=\"http://www.hartcode.com:13133/Vote\" />"); 
		sb.append("<meta property=\"og:title\"       content=\"Tomorrow&#039;s Wallpaper\" />"); 
		sb.append("<meta property=\"og:description\" content=\"\" /> ");
		//sb.append("<meta property=\"og:image\"       content=\"http://www.hartcode.com/photos/thumb/1057/image.jpg\" /> ");
		sb.append("<title>");
		sb.append(GetTitle());
		sb.append("</title>");
		sb.append("<meta name=\"description\" content=\"");
		sb.append(GetDescription());
		sb.append("\"/>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" />");
		sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
		sb.append("<link href=\"style.1.4.1.css\" rel=\"stylesheet\" type=\"text/css\" />");
		
		sb.append("<!--[if lte IE 7]><link href=\"style_ie7.1.0.0.css\" rel=\"stylesheet\" type=\"text/css\" /><![endif]-->");
		sb.append("<link rel=\"alternate\" type=\"application/rss+xml\" title=\"HartCode News\" href=\"http://www.hartcode.com/rss.xml\" />");
		sb.append("<script type=\"text/javascript\" src=\"hartcode.1.0.js\"></script>");
		sb.append("<script type=\"text/javascript\" src=\"ga.1.0.0.js\"></script>");
		sb.append("</head>");
		sb.append("<body id=\"");
		sb.append(GetNavID());
		sb.append("\">");
		sb.append("<div id=\"HeadOuter\">");
		sb.append("<div id=\"HeadInner2\"></div>");
		sb.append("<div id=\"HeadInner\"></div>");
		sb.append("<h1>HartCode Technology Solutions</h1>");
		sb.append("</div>");
		sb.append("<div id=\"total\">");
		sb.append("<div id=\"sidebar\">");
		sb.append("<ul>");
		sb.append("<li><a id=\"homeli\" href=\"/\">Home</a></li>");
		sb.append("<li><a id=\"newsli\" href=\"News\">News</a></li>");
		sb.append("<li><a id=\"wallli\" href=\"Wallpaper\">Wallpaper</a></li>");
		sb.append("<li><a id=\"voteli\" href=\"Vote\">Vote</a></li>");
		sb.append("</ul>");
		if (m_UseADS)
		{
		logger.debug("Start Ad Module");
		sb.append("<div id=\"adpanel\">"+ADs.getRandomAd()+"</div>");
		logger.debug("End Ad Module");
		}
		sb.append("<div id=\"social\"><a href=\"http://www.twitter.com/Hartcode\"><img src=\"/images/twitter-b.png\" alt=\"Follow Hartcode on Twitter\" width=\"61\" height=\"23\"/></a>");
		sb.append("<div id=\"user-info\"></div>");
		sb.append("<p><button id=\"fb-auth\">Login</button></p></div>");
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
		sb.append("	764 E. Hillcrest Dr.<br />");
		sb.append("	Suite 101<br />");
		sb.append("	Verona WI, 53593<br />");
		sb.append("</li>");
		sb.append("<li  class=\"center\">");
		sb.append("&#169; 2012 HartCode<br/>All pictures, graphics, logos are copyrighted to their respective owners.");
		sb.append("</li>");
		sb.append("<li  class=\"right\">");
		sb.append("<a href=\"mailto:alex@hartcode.com\">alex@hartcode.com</a><br />");
		sb.append("608-658-0359<br />");
		sb.append("</li>");
		sb.append("</ul>");
		sb.append("</div>");
		sb.append("<div id=\"fb-root\"></div>");
		sb.append("<script type=\"text/javascript\" src=\"facebook.js\"></script>");
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
