package com.hartcode.modules;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.hartcode.dataObjects.HTMLNews1;



public class IndexModule implements IMainModule {
	protected HttpServletRequest m_request;
	protected Date m_lastmodifieddate;
	public IndexModule()
	{
		
	}
	public String GetMainModule() {
		StringBuilder sb = new StringBuilder();
		HTMLNews1 hnews = new HTMLNews1();
		
		sb.append("<div id=\"newsdiv\">");
		sb.append(hnews.toString());
		sb.append("<p><a href=\"/news\">More ...</a></p>");
		sb.append("</div>");
		sb.append("<div id=\"Other\"></div>");
		m_lastmodifieddate = hnews.GetMostRecentDate();
		return sb.toString();
	}
	public void SetRequest(HttpServletRequest request)
	{
		m_request = request;
		
	}
	@Override
	public String GetTitle() {
		String retval = "HartCode";
		return retval;
	}
	@Override
	public String GetDescription() {
		String retval = "Random thoughts relating to Computer Science, Bitcoin, Minecraft, and Homebrewing.";
		return retval;
	}
	@Override
	public Date GetLastModifiedDate() {
		return m_lastmodifieddate;
	}

}
