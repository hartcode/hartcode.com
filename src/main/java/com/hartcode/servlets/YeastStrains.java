package com.hartcode.servlets;

import com.hartcode.modules.YeastStrainsListModule;




/**
 * Servlet implementation class PhotoVoteResults
 */
public class YeastStrains extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public YeastStrains() {
    			
    	super(new YeastStrainsListModule(),"yeast");
    }

}
