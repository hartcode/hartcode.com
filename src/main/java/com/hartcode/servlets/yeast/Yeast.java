package com.hartcode.servlets.yeast;

import com.hartcode.modules.YeastCultureModule;
import com.hartcode.servlets.MainServlet;



/**
 * Servlet implementation class PhotoVoteResults
 */
public class Yeast extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Yeast() {
    			
    	super(new YeastCultureModule(),"yeast");
    }

}
