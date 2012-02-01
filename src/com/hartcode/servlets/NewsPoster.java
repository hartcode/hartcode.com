package com.hartcode.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hartcode.date.DateParser;
import com.hartcode.news.NewsItem;
import com.hartcode.news.poster.data.NewsPosterDAO;

/**
 * Servlet implementation class NewsPoster
 */
public class NewsPoster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsPoster() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		String isOK = "N";
		String enc = "UTF-8";
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String date = request.getParameter("date");
		NewsPosterDAO npd = null;
		NewsItem ni = null;
		Date postdate = null;
		if (title != null && text != null)
		{
			title = java.net.URLDecoder.decode(title,enc);
			text = java.net.URLDecoder.decode(text,enc);
			
		try {
			
			npd = new NewsPosterDAO();
			ni = new NewsItem();
			ni.setTitle(title);
			ni.setText(text);
			if (date != null && date != "")
			{
				date = java.net.URLDecoder.decode(date,enc);
				postdate = 	DateParser.ParseDate(date);
			}
			if (postdate != null)
			{
				ni.setPostdate(postdate);
			}
			npd.Insert(ni);
			isOK = "Y";
		}catch (Exception e)
		{
		}
		}
		pw.write(isOK);
		pw.close();
	}
}
