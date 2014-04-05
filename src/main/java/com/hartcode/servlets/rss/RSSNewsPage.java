package com.hartcode.servlets.rss;


import javax.servlet.http.HttpServletRequest;

import com.hartcode.modules.RSSModule;
import com.hartcode.pages.RSSPage;
import com.hartcode.servlets.ServletPage;



/**
 * Servlet implementation class NewsRSS
 */
public class RSSNewsPage extends ServletPage {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RSSNewsPage() {
        super("application/rss+xml");
    }
    
    public String GetFileData(HttpServletRequest request)
    {
    	RSSPage rp = new RSSPage(new RSSModule(),"HartCode Technology Solutions News","","http://www.hartcode.com/");
    	return rp.toString();
    }
}