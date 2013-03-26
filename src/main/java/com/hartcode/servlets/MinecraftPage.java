package com.hartcode.servlets;

import com.hartcode.modules.MinecraftModule;

/**
 * Servlet implementation class IndexPage
 */
public class MinecraftPage extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MinecraftPage() {
    	super(new MinecraftModule(),"minecraft");
    }
}
