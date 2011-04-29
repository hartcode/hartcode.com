package modules;

import javax.servlet.http.HttpServletRequest;

import dataObjects.HTMLNews1;


public class IndexModule implements IMainModule {
	protected HttpServletRequest m_request;
	public IndexModule()
	{
		
	}
	public String GetMainModule() {
		StringBuilder sb = new StringBuilder();
		HTMLNews1 hnews = new HTMLNews1();
		sb.append(hnews.toString());
		sb.append("<div id=\"Other\">");
		sb.append("<h2>Services</h2>");
		sb.append("<ul>");
		sb.append("<li>");
		sb.append("<p>");
		sb.append("We are a family owned and operated firm is dedicated to helping you grow your business with the latest technology solutions.  We know technology so you don't have to.  We take care of the technology so you can take care of your customers.  We try to make technology easier to use and easier to live with.  We offer a variety of software solutions for your business.");
		sb.append("</p>");
		sb.append("</li>");
		sb.append("<li>");
		sb.append("<p>");
		sb.append("Website Design: A solid website is the first step in building an on-line presence for you business.  We will design a site that will meet your needs and exceed your expectations.  Each site we design is optimized for customer appeal and an optimal on-line experience.  We also offer mobile sites, which are optimized for mobile phones.");
		sb.append("</p>");
		sb.append("</li>");
		sb.append("<li>");
		sb.append("<p>");
		sb.append("Website administration:  Let us manage your website.  We will manager your website, the web hosting, your domain names and emails.  We will take care of backups, domain renewals, monitoring bandwith.  We treat every site as if it were our own.");
		sb.append("</p>");
		sb.append("</li>");
		sb.append("<li>");
		sb.append("<p>");
		sb.append("Search Engine Optimization:  Already have a site?  Let us optimize it.  What does that mean?  It means we will tweak your site so that it will load faster and will also make your site show up higher in search engines such as Google, Yahoo, or Bing.  Higher results get more traffic.  Poorly designed websites do not get good results in search engines and sales.  We will also rigorously test your site on a variety browsers and platforms ensuring that if your site works correctly with the latest software and hardware platforms.");  
		sb.append("</p>");
		sb.append("</li>");
		sb.append("<li>");
		sb.append("<p>");
		sb.append("Web Advertising:  We will create internet advertising campaigns that will drive business to your website and to your front door.  Our custom ads will make your business stand out on internet.");
		sb.append("</p>");
		sb.append("</li>");
		sb.append("<li>");
		sb.append("<p>");
		sb.append("Web Statistics:  We will generate reports of your website's vistors, traffic, and bandwidth.  Our reports will help you make the right decisions when it comes to your business.");
		sb.append("</p>");
		sb.append("</li>");
		sb.append("<li>");
		sb.append("<p>");
		sb.append("Give us a call or send us an email and we will setup a meeting and get your business on the path to joining the on-line community.");
		sb.append("</p>");
		sb.append("</li>");
		sb.append("</ul>");
		sb.append("</div>");
		return sb.toString();
	}
	public void SetRequest(HttpServletRequest request)
	{
		m_request = request;
		
	}

}
