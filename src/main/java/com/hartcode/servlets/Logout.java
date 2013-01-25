package com.hartcode.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hartcode.Facebook.FacebookAPI;
import com.hartcode.Facebook.Objects.AccessTokenData;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html");
		HttpSession session = request.getSession(false);
		if (session != null)
		{
			
		
		String accessToken = (String)session.getAttribute("accessToken");
		if (accessToken != null)
		{
			AccessTokenData atd = new AccessTokenData();
			atd.AccessToken = accessToken;
			session.invalidate();
			response.sendRedirect(FacebookAPI.Logout(atd,"http://"+FacebookAPI.domain+"/"));	
		}else
		{response.sendRedirect("http://"+FacebookAPI.domain+"/");}
		
		}else
		{response.sendRedirect("http://"+FacebookAPI.domain+"/");}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
