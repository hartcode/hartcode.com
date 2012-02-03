package com.hartcode.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Calendar;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class channel
 */
public class channel extends ServletPage implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see ServletPage#ServletPage()
     */
    public channel() {
        super();
        // TODO Auto-generated constructor stub
    }
       
    /**
     * @see ServletPage#ServletPage(String)
     */
    public channel(String contenttype) {
        super(contenttype);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long expire = 60*60*24*365;
		Calendar mycal = Calendar.getInstance();
		mycal.add(Calendar.YEAR, 1);
		Date d = mycal.getTime();
		
		response.addHeader("Expires",d.toGMTString());
		PrintWriter pw = response.getWriter();
		pw.write("<script src=\"//connect.facebook.net/en_US/all.js\"></script>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
