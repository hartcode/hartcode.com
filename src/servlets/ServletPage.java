package servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", m_ContentType);
		PrintWriter pw = response.getWriter();
		pw.write(GetFileData(request));
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}


}
