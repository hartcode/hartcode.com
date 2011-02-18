

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexPage
 */
public class IndexPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IndexPage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "application/xhtml+xml");
		HTMLNews hnews = new HTMLNews();
		PrintWriter pw = response.getWriter();
		
		pw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		pw.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">");
		pw.write("<head>");
		pw.write("<title>HartCode - Home</title>");
		pw.write("<meta name=\"description\" content=\"A forum for me to share my thoughts, programs, code, drawings, and other random ideas with the on-line community\"/>");
		pw.write("<meta http-equiv=\"Content-Type\" content=\"application/xhtml+xml;charset=utf-8\" />");
		pw.write("<meta name=\"google-site-verification\" content=\"zX9-oAux8713m5ccWxGN4s4_ziMp6LrYhn_FruDgUhM\" />");
		pw.write("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />");
		pw.write("<link rel=\"alternate\" type=\"application/rss+xml\" title=\"HartCode News\" href=\"http://www.hartcode.com/rss.xml\" />");
		pw.write("<script type=\"text/javascript\" src=\"analytics.js\"></script>");
		pw.write("<script type=\"text/javascript\" src=\"https://ssl.google-analytics.com/ga.js\"></script>");
		pw.write("</head>");
		pw.write("<body id=\"home\">");
		pw.write("<h1>HartCode</h1>");
		pw.write("<div id=\"sidebar\">");
		pw.write("<ul>");
		pw.write("<li><a id=\"homeli\" href=\"/\">Home</a></li>");
		pw.write("</ul>");
		pw.write("</div>");
		pw.write("<div id=\"main\">");
		pw.write(hnews.toString());
		pw.write("</div>");
		pw.write("<div id=\"footer\">");
		pw.write("<div class=\"right\">");
		pw.write("<a href=\"http://validator.w3.org/check?uri=referer\"><img src=\"images/valid-xhtml10-blue.png\" alt=\"Valid XHTML 1.0\" /></a>");
		pw.write("<a href=\"http://jigsaw.w3.org/css-validator/check/referer\"><img src=\"images/vcss-blue.gif\" alt=\"Valid CSS!\" /></a>");
		pw.write("</div>");
		pw.write("<div>alex@hartcode.com</div>");
		pw.write("</div>");
		pw.write("</body>");
		pw.write("</html>");

		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
