package com.hartcode.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected String m_ContentType;
    /**
     * Default constructor. 
     */
	protected ServletPage(){
		SetContentType("text/html");
	}
	public ServletPage(String contenttype)
	{
		SetContentType(contenttype);
	}
	
    protected void SetContentType(String contenttype)
    {
    	m_ContentType = contenttype;
    }

    public String GetFileData(HttpServletRequest request)
    {
		return "";
    }
    public String PostFileData(HttpServletRequest request)
    {
    	return GetFileData(request);
    }
    
    public Date GetLastModifiedDate()
    {
    	Calendar mycal = Calendar.getInstance();
		mycal.setTimeZone(TimeZone.getTimeZone("UTC"));
		mycal.add(Calendar.SECOND, -1*mycal.get(Calendar.SECOND));
		mycal.add(Calendar.MINUTE, -1*mycal.get(Calendar.MINUTE));
		mycal.add(Calendar.HOUR, -1*mycal.get(Calendar.HOUR));
		return mycal.getTime();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPage(request,response,GetFileData(request));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPage(request,response,PostFileData(request));
	}

	protected void doPage(HttpServletRequest request, HttpServletResponse response, String data) throws ServletException, IOException {
		response.addHeader("Content-Type", m_ContentType);
		PrintWriter pw = response.getWriter();
		pw.write(data);
		
		Date lastmod = GetLastModifiedDate();
		
		if (lastmod != null)
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(
			        "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
			    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
			    
			response.addHeader("Last-Modified",dateFormat.format(lastmod));
		}
		
		pw.close();
	}

}
