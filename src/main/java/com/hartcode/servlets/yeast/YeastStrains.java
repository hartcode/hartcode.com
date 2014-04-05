package com.hartcode.servlets.yeast;

import com.hartcode.modules.YeastStrainsListModule;
import com.hartcode.servlets.MainServlet;




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
