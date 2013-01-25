package com.hartcode.modules;

import javax.servlet.http.HttpServletRequest;

import com.hartcode.dataObjects.HTMLNews;


public class NewsModule  implements IMainModule {
			protected HttpServletRequest m_request;
			public NewsModule()
			{
				
			}
			public String GetMainModule() {
				StringBuilder sb = new StringBuilder();
				HTMLNews hnews = new HTMLNews();
				sb.append("<div id=\"newsdiv\">");
				sb.append(hnews.toString());
				sb.append("</div>");
				return sb.toString();
			}
			public void SetRequest(HttpServletRequest request)
			{
				m_request = request;
				
			}

}
