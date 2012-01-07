package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pages.MainPage;

import com.hartcode.PhotoADay.VoteDAO;

import modules.PhotoVoteResultsModule;
import modules.WallpaperModule;

/**
 * Servlet implementation class PhotoVoteResults
 */
public class PhotoVoteResults extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PhotoVoteResults() {
    			
    	super(new PhotoVoteResultsModule(),"Vote - HartCode Technology Solutions","","vote");
    }

}
