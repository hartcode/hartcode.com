package com.hartcode.servlets.wallpaper;

import com.hartcode.modules.WallpaperModule;
import com.hartcode.servlets.MainServlet;

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
