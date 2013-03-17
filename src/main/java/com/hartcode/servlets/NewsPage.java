package com.hartcode.servlets;

import com.hartcode.modules.NewsModule;

/**
 * Servlet implementation class IndexPage
 */
public class NewsPage extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public NewsPage() {
    	super(new NewsModule(),"News - HartCode","","news");
    }
}
