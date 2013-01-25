package com.hartcode.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

    }
       
    /**
     * @see ServletPage#ServletPage(String)
     */
    public channel(String contenttype) {
        super(contenttype);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar mycal = Calendar.getInstance();
		mycal.add(Calendar.YEAR, 1);
		Date d = mycal.getTime();
		String dGMT = null;
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		dGMT = sdf.format(d);
		
		response.addHeader("Expires",dGMT);
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
