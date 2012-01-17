package servlets;

import modules.PhotoVoteResultsModule;


/**
 * Servlet implementation class PhotoVoteResults
 */
public class PhotoVoteResults extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PhotoVoteResults() {
    			
    	super(new PhotoVoteResultsModule(),"Vote - HartCode Technology Solutions","","vote");
    }

}
