package com.hartcode.modules;

import javax.servlet.http.HttpServletRequest;

import com.hartcode.dataObjects.HTMLNews1;



public class IndexModule implements IMainModule {
	protected HttpServletRequest m_request;
	public IndexModule()
	{
		
	}
	public String GetMainModule() {
		StringBuilder sb = new StringBuilder();
		HTMLNews1 hnews = new HTMLNews1();
		sb.append("<div id=\"newsdiv\">");
		sb.append(hnews.toString());
		sb.append("</div>");
		sb.append("<div id=\"Other\"><h2>About Us</h2><p id=\"first\">We are a family owned and operated firm dedicated to helping you grow your business with the latest technology solutions. We know technology so you don't have to. We take care of the technology so you can take care of your customers. We try to make technology easier to use and easier to live with. We offer a variety of software solutions for your business.</p>");
			sb.append("<div id=\"Services\">");
			sb.append("<div><h3>Website Design</h3><p>A solid website is the first step in building an on-line presence for you business. We will design a site that will meet your needs and exceed your expectations. Each site we design is optimized for customer appeal and an optimal on-line experience. We also offer mobile sites, which are optimized for mobile phones.</p></div>");
			sb.append("<div><h3>Website Administration</h3><p>Let us manage your website. We will manager your website, the web hosting, your domain names and emails. We will take care of backups, domain renewals, monitoring bandwith. We treat every site as if it were our own.</p></div>");
			sb.append("<div><h3>Search Engine Optimization</h3><p>Already have a site? Let us optimize it. What does that mean? It means we will tweak your site so that it will load faster and will also make your site show up higher in search engines such as Google, Yahoo, or Bing. Higher results get more traffic. Poorly designed websites do not get good results in search engines and sales.</p></div>");
			sb.append("</div>");
			sb.append("<div id=\"Services1\">");
			sb.append("<div><h3>Web Advertising</h3><p> We will create internet advertising campaigns that will drive business to your website and to your front door. Our custom ads will make your business stand out on internet.</p></div>");
			sb.append("<div><h3>Web Statistics</h3><p> We will generate reports of your website's vistors, traffic, and bandwidth. Our reports will help you make the right decisions when it comes to your business.</p></div>");
			sb.append("<div class=\"whitebackground\"></div>");
			sb.append("</div>");
			sb.append("</div>");
	
		return sb.toString();
	}
	public void SetRequest(HttpServletRequest request)
	{
		m_request = request;
		
	}

}
