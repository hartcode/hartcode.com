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
    	super(new IndexModule(),"HartCode - Home","A forum for me to share my thoughts, programs, code, drawings, and other random ideas with the on-line community.","home");
    }
}
