package com.hartcode.modules;

import javax.servlet.http.HttpServletRequest;

import com.hartcode.dataObjects.HTMLNews1;



public class IndexModule implements IMainModule {
	protected HttpServletRequest m_request;
	public IndexModule()
	{
		
	}
	public String GetMainModule() {
		StringBuilder sb = new StringBuilder();
		HTMLNews1 hnews = new HTMLNews1();
		sb.append("<div id=\"newsdiv\">");
		sb.append(hnews.toString());
		sb.append("</div>");
		sb.append("<div id=\"Other\"></div>");
			sb.append("</div>");
	
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

}
