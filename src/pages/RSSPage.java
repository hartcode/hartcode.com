package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import modules.IMainModule;


public class RSSPage {
	protected IMainModule m_MainModule;
	protected String m_Title;
	protected String m_Link;
	protected String m_Description;
	public RSSPage(IMainModule MainModule, String title, String desc, String link)
	{
		m_MainModule = MainModule;
		m_Title = title;
		m_Description = desc;
		m_Link = link;
	}

	public String toString()
	{
		String retval = "";
		StringBuilder sb = new StringBuilder();
		DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
		Date d = new Date();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		sb.append("<rss version=\"2.0\">");
		sb.append("<channel>");
		sb.append("<title>");
		sb.append(m_Title);
		sb.append("</title>");
		sb.append("<description>");
		sb.append(m_Description);
		sb.append("</description>");
		sb.append("<link>");
		sb.append(m_Link);
		sb.append("</link>");
		sb.append("<lastBuildDate>");
		sb.append(df.format(d) + " 00:01:00 +0000 </lastBuildDate>");
		sb.append("<pubDate>"+df.format(d) + " 00:01:00 +0000 </pubDate>");
		sb.append(m_MainModule.GetMainModule());
		sb.append("</channel>");
		sb.append("</rss>");
		retval = sb.toString();
		return retval;
	}
}
