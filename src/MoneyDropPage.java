

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexPage
 */
public class MoneyDropPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MoneyDropPage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html");
		HTMLNews hnews = new HTMLNews();
		PrintWriter pw = response.getWriter();
		
		pw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		pw.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">");
		pw.write("<head>");
		pw.write("<title>HartCode - Money Drop</title>");
		pw.write("<meta name=\"description\" content=\"Catch the money, avoid the bombs.\"/>");
		pw.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
		pw.write("<meta name=\"google-site-verification\" content=\"zX9-oAux8713m5ccWxGN4s4_ziMp6LrYhn_FruDgUhM\" />");
		pw.write("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />");
		pw.write("<link rel=\"alternate\" type=\"application/rss+xml\" title=\"HartCode News\" href=\"http://feeds.feedburner.com/HartCodeNews\" />");
		pw.write("<script type=\"text/javascript\" src=\"analytics.js\"></script>");
		pw.write("<script type=\"text/javascript\" src=\"https://ssl.google-analytics.com/ga.js\"></script>");
		pw.write("</head>");
		pw.write("<body id=\"moneydrop\">");
		pw.write("<h1>HartCode</h1>");
		pw.write("<div id=\"sidebar\">");
		pw.write("<ul>");
		pw.write("<li><a id=\"homeli\" href=\"/\">Home</a></li>");
		pw.write("<li><a id=\"moneyli\" href=\"/MoneyDrop\">Money Drop</a></li>");
		pw.write("<li><a id=\"zombli\" href=\"/Zombone\">Zombone</a></li>");
		pw.write("</ul>");
		pw.write("</div>");
		pw.write("<div id=\"main\">");
		pw.write("<div id=\"adpanel\">");
		pw.write("<script type=\"text/javascript\"><!--\n");
		pw.write("google_ad_client = \"ca-pub-3996808295883844\";\n");
		pw.write("/* SidePanel */\n");
		pw.write("google_ad_slot = \"8720621925\";\n");
		pw.write("google_ad_width = 120;\n");
		pw.write("google_ad_height = 600;\n");
		pw.write("//-->\n");
		pw.write("</script>\n");
		pw.write("<script type=\"text/javascript\"\nsrc=\"http://pagead2.googlesyndication.com/pagead/show_ads.js\">\n");
		pw.write("</script>\n");
		pw.write("</div>");
		
		pw.write("<h2>Download</h2><p><a href=\"/downloads/MoneyDrop_winxp_1.0.zip\">MoneyDrop_winxp_1.0.zip</a></p>");
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
