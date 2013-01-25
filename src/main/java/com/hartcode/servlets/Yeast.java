package com.hartcode.servlets;

import com.hartcode.modules.CultureModule;



/**
 * Servlet implementation class PhotoVoteResults
 */
public class Yeast extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Yeast() {
    			
    	super(new CultureModule(),"Yeast - HartCode Technology Solutions","","culture");
    }

}
