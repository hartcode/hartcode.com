package com.hartcode.servlets;

import com.hartcode.modules.PhotoVoteResultsModule;


/**
 * Servlet implementation class PhotoVoteResults
 */
public class PhotoVoteResults extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PhotoVoteResults() {
    			
    	super(new PhotoVoteResultsModule(),"vote");
    }

}
