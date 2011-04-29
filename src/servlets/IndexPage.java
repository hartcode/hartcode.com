package servlets;

import modules.IndexModule;

/**
 * Servlet implementation class IndexPage
 */
public class IndexPage extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IndexPage() {
    	super(new IndexModule(),"Home - HartCode Technology Solutions","","home");
    }
}
