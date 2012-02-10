package com.hartcode.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.URIParameter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.hartcode.ParameterDecode;
import com.hartcode.Facebook.FacebookAPI;
import com.hartcode.Facebook.Objects.AccessTokenData;
import com.hartcode.Facebook.Objects.UserData;
import com.hartcode.PhotoADay.VoteDAO2;
import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;
import com.sun.jndi.toolkit.url.UrlUtil;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(Login.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html");
		VoteDAO2 va2 = null;
		try {
			logger.debug("Creating VoteDAO2 object.");
			va2 = new VoteDAO2();
			logger.debug("Finished Creating VoteDAO2 object.");
		} catch (NullArgumentException e2) {
			// TODO Auto-generated catch block
			logger.error(e2);
		} catch (InvalidPortException e2) {
			// TODO Auto-generated catch block
			logger.error(e2);
		} catch (ParserConfigurationException e2) {
			// TODO Auto-generated catch block
			logger.error(e2);
		} catch (SAXException e2) {
			// TODO Auto-generated catch block
			logger.error(e2);
		}
		
		
		String facebookauthcode = request.getParameter("code");
		if (facebookauthcode != null)
		{
			String facebookclientid = "161596347286085";
			String redirecturl = "http://www.hartcode.com/Login";
			String facebooksecret = "34d423706e24428280d3a4c721771ffc";
			AccessTokenData atd = FacebookAPI.getAccessTokenDataFromCode(facebookauthcode, facebookclientid, redirecturl, facebooksecret);
			UserData ud = FacebookAPI.getUserData(atd);
			try {
				Integer myuserid = va2.NewUpdateFBUser(ud);
				HttpSession session = request.getSession(true);
				session.setAttribute("fbid", ud.ID);
				session.setAttribute("myuserid", myuserid );
				session.setAttribute("accessToken",atd.AccessToken);
				logger.debug("lastaccess: " + session.getLastAccessedTime());
				logger.debug("creationtime: " + session.getCreationTime());
				logger.debug("fbid: " + session.getAttribute("fbid"));
			}catch (Exception e)
			{
			logger.error(e);
			}
		
			va2.closeConnections();
			RequestDispatcher rd = request.getRequestDispatcher("/");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request,response);
	}

}
