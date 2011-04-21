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
		sb.append("<meta name=\"google-site-verification\" content=\"zX9-oAux8713m5ccWxGN4s4_ziMp6LrYhn_FruDgUhM\" />");
		sb.append("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />");
		sb.append("<link rel=\"alternate\" type=\"application/rss+xml\" title=\"HartCode News\" href=\"http://feeds.feedburner.com/HartCodeNews\" />");
		sb.append("<script type=\"text/javascript\" src=\"analytics.js\"></script>");
		sb.append("<script type=\"text/javascript\" src=\"hartcode.1.0.js\"></script>");
		sb.append("<script type=\"text/javascript\" src=\"https://ssl.google-analytics.com/ga.js\"></script>");
		sb.append("</head>");
		sb.append("<body id=\"");
		sb.append(GetNavID());
		sb.append("\">");
		sb.append("<h1>HartCode</h1>");
		sb.append("<div id=\"sidebar\">");
		sb.append("<ul>");
		sb.append("<li><a id=\"homeli\" href=\"/\">Home</a></li>");
		sb.append("<li><a id=\"passli\" href=\"/PasswordGenerator\">Password Generator</a></li>");
		sb.append("<li><a id=\"moneyli\" href=\"/MoneyDrop\">Money Drop</a></li>");
		sb.append("<li><a id=\"zombli\" href=\"/Zombone\">Zombone</a></li>");
		sb.append("</ul>");
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
		sb.append("<div id=\"footer\"><ul class=\"right\"><li><a href=\"http://www.twitter.com/Hartcode\"><img src=\"http://twitter-badges.s3.amazonaws.com/t_logo-a.png\" alt=\"Follow Hartcode on Twitter\"/></a></li><li><a href=\"http://validator.w3.org/check?uri=referer\"><img src=\"images/valid-xhtml10-blue.png\" alt=\"Valid XHTML 1.0\" /></a></li><li><a href=\"http://jigsaw.w3.org/css-validator/check/referer\"><img src=\"images/vcss-blue.png\" alt=\"Valid CSS!\" /></a></li></ul><ul><li>&copy; 2011 HartCode</li><li><a href=\"mailto:alex@hartcode.com\">alex@hartcode.com</a></li></ul></div>");
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
