package com.hartcode.servlets.news;

import com.hartcode.modules.NewsModule;
import com.hartcode.servlets.MainServlet;

/**
 * Servlet implementation class IndexPage
 */
public class NewsPage extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NewsPage() {
    	super(new NewsModule(),"news");
    }
}
