package com.hartcode.servlets;

import com.hartcode.modules.WallpaperModule;

/**
 * Servlet implementation class Wallpaper
 */
public class Wallpaper extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Wallpaper() {
    	super(new WallpaperModule(),"wall");
    }

}
