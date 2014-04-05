package com.hartcode.servlets.yeast;

import com.hartcode.modules.YeastCulturesListByStrainModule;
import com.hartcode.servlets.MainServlet;




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
