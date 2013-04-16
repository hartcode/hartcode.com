package com.hartcode.modules;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.hartcode.dataObjects.HTMLNews;


public class NewsModule  implements IMainModule {
			protected HttpServletRequest m_request;
			protected Date m_lastmodifieddate;
			public NewsModule()
			{
				
			}
			public String GetMainModule() {
				StringBuilder sb = new StringBuilder();
				HTMLNews hnews = new HTMLNews(5);
				sb.append("<div id=\"newsdiv\">");
				sb.append(hnews.toString());
				sb.append("</div>");
				m_lastmodifieddate = hnews.GetMostRecentDate();
				return sb.toString();
			}
			public void SetRequest(HttpServletRequest request)
			{
				m_request = request;
				
			}

			@Override
			public String GetTitle() {
				String retval = "News - HartCode";
				return retval;
			}
			@Override
			public String GetDescription() {
				String retval = "Read all about it!";
				return retval;
			}
			@Override
			public Date GetLastModifiedDate() {
				return m_lastmodifieddate;
			}			
}
