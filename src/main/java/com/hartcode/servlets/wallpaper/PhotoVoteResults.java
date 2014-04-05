package com.hartcode.servlets.wallpaper;

import com.hartcode.modules.PhotoVoteResultsModule;
import com.hartcode.servlets.MainServlet;


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
