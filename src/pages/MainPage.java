package pages;

import modules.IMainModule;


public class MainPage {

	protected String m_Main;
	protected String m_Title;
	protected String m_NavID;
	protected String m_Description;
	protected IMainModule m_MainModule;
	public MainPage(IMainModule MainModule, String title, String desc, String navid)
	{
		m_MainModule = MainModule;
		SetTitle(title);
		SetDescription(desc);
		SetNavID(navid);
	}
	
	public String toString()
	{
		String retval = "";
		StringBuilder sb = new StringBuilder();
		
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
		sb.append("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />");
		sb.append("<link rel=\"alternate\" type=\"application/rss+xml\" title=\"HartCode News\" href=\"http://feeds.feedburner.com/HartCodeNews\" />");
		sb.append("<script type=\"text/javascript\" src=\"analytics.js\"></script>");
		sb.append("<script type=\"text/javascript\" src=\"hartcode.1.0.js\"></script>");
		sb.append("<script type=\"text/javascript\" src=\"https://ssl.google-analytics.com/ga.js\"></script>");
		sb.append("</head>");
		sb.append("<body id=\"");
		sb.append(GetNavID());
		sb.append("\">");
		sb.append("<h1>HartCode Technology Solutions</h1>");
		sb.append("<div id=\"sidebar\">");
		sb.append("<ul>");
		sb.append("<li><a id=\"homeli\" href=\"/\">Home</a></li>");
		sb.append("<li><a id=\"newsli\" href=\"/\">News</a></li>");
		sb.append("</ul>");
		sb.append("<div class=\"twitter\"><a href=\"http://www.twitter.com/Hartcode\">");
		sb.append("<img src=\"http://twitter-badges.s3.amazonaws.com/t_logo-a.png\"");
		sb.append("alt=\"Follow Hartcode on Twitter\" />");
		sb.append("</a></div>");
		sb.append("</div>");
		sb.append("<div id=\"main\">");
		sb.append("<div id=\"adpanel\">");
		sb.append("<script type=\"text/javascript\"><!--\n");
		sb.append("google_ad_client = \"ca-pub-3996808295883844\";\n");
		sb.append("/* SidePanel */\n");
		sb.append("google_ad_slot = \"8720621925\";\n");
		sb.append("google_ad_width = 120;\n");
		sb.append("google_ad_height = 600;\n");
		sb.append("//-->\n");
		sb.append("</script>\n");
		sb.append("<script type=\"text/javascript\"\nsrc=\"http://pagead2.googlesyndication.com/pagead/show_ads.js\">\n");
		sb.append("</script>\n");
		sb.append("</div>");
		sb.append(m_MainModule.GetMainModule());
		sb.append("</div>");
		sb.append("<div id=\"footer\">");
		sb.append("  <ul>");
		sb.append("<li id=\"address\">");
		sb.append("	764 E. Hillcrest Dr.<br />");
		sb.append("	Suite 101<br />");
		sb.append("	Verona WI, 53593<br />");
		sb.append("</li>");
		sb.append("<li  class=\"center\">");
		sb.append("&#169; 2011 HartCode");
		sb.append("</li>");
		sb.append("<li  class=\"right\">");
		sb.append("<a href=\"mailto:alex@hartcode.com\">alex@hartcode.com</a><br />");
		sb.append("608-658-0359<br />");
		sb.append("</li>");
		sb.append("</ul>");
		sb.append("</div>");
		sb.append("</body>");
		sb.append("</html>");
		retval = sb.toString();
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
