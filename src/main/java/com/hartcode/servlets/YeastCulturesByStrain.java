package com.hartcode.servlets;

import com.hartcode.modules.YeastCulturesListByStrainModule;




/**
 * Servlet implementation class PhotoVoteResults
 */
public class YeastCulturesByStrain extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public YeastCulturesByStrain() {
    			
    	super(new YeastCulturesListByStrainModule(),"yeast");
    }

}
