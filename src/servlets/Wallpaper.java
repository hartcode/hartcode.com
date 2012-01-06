package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modules.IndexModule;
import modules.WallpaperModule;

/**
 * Servlet implementation class Wallpaper
 */
public class Wallpaper extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Wallpaper() {
    	super(new WallpaperModule(),"Wallpaper - HartCode Technology Solutions","","wall");
    }

}
