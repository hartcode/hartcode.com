package com.hartcode;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewsRSS
 */
public class NewsRSS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsRSS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "application/rss+xml");
		DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
		Date d = new Date();
		
		RSSNews rnews = new RSSNews();
		PrintWriter pw = response.getWriter();
		pw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		pw.write("<rss version=\"2.0\">");
		pw.write("<channel>");
		pw.write("<title>HartCode News</title>");
		pw.write("<description>A forum for me to share my thoughts, programs, code, drawings, and other random ideas with the on-line community.</description>");
		pw.write("<link>http://www.hartcode.com/</link>");
		
		pw.write("<lastBuildDate>");
		pw.write(df.format(d) + " 00:01:00 +0000 </lastBuildDate>");
		pw.write("<pubDate>"+df.format(d) + " 00:01:00 +0000 </pubDate>");
		pw.write(rnews.toString());
		pw.write("</channel>");
		pw.write("</rss>");
		pw.close();
		 
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
