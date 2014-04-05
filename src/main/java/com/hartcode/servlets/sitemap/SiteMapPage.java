package com.hartcode.servlets.sitemap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hartcode.libyeast.Culture;
import com.hartcode.libyeast.Strain;
import com.hartcode.libyeast.hibernate.HibernateUtil;
import com.hartcode.servlets.ServletPage;


/**
 * Servlet implementation class NewsRSS
 */
public class SiteMapPage extends ServletPage {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SiteMapPage() {
		super("application/rss+xml");
	}

	@SuppressWarnings("unchecked")
	public String GetFileData(HttpServletRequest request) {
		StringBuilder retval = new StringBuilder();
		retval.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		retval.append("<urlset xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		retval.append(" xsi:schemaLocation=\"http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd\"");
		retval.append(" xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">");
		retval.append("<url>");
		retval.append("<loc>http://www.hartcode.com/</loc>");
		retval.append("<changefreq>daily</changefreq>");
		retval.append("<priority>1.0</priority>");
		retval.append("</url>");
		retval.append("<url>");
		retval.append("<loc>http://www.hartcode.com/news</loc>");
		retval.append("<changefreq>daily</changefreq>");
		retval.append("<priority>1.0</priority>");
		retval.append("</url>");
		retval.append("<url>");
		retval.append("<loc>http://www.hartcode.com/wallpaper/vote</loc>");
		retval.append("<changefreq>daily</changefreq>");
		retval.append("<priority>1.0</priority>");
		retval.append("</url>");
		retval.append("<url>");
		retval.append("<loc>http://www.hartcode.com/wallpaper</loc>");
		retval.append("<changefreq>daily</changefreq>");
		retval.append("<priority>1.0</priority>");
		retval.append("</url>");
		retval.append("<url>");
		retval.append("<loc>http://www.hartcode.com/yeaststrains</loc>");
		retval.append("<changefreq>weekly</changefreq>");
		retval.append("<priority>1.0</priority>");
		retval.append("</url>");
		Session session = null;
		Transaction trans = null;
		
		List<Strain> cs = null;
		List<Culture> cc =  null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			try {

				Criteria crit = session.createCriteria(Strain.class);
				cs = crit.list();
				Criteria crit2 = session.createCriteria(Culture.class);
				cc = crit2.list();

			} catch (Exception e) {
			}

			if (cc != null) {
				for (Culture c : cc) {
					retval.append("<url>");
					retval.append("<loc>http://www.hartcode.com/yeast/"
							+ c.getID().toString() + "</loc>");
					retval.append("<changefreq>weekly</changefreq>");
					retval.append("<priority>1.0</priority>");
					retval.append("</url>");
				}
			}

			if (cs != null) {
				for (Strain st : cs) {
					retval.append("<url>");
					retval.append("<loc>http://www.hartcode.com/yeastculturesbystrain/"
							+ st.getID().toString() + "</loc>");
					retval.append("<changefreq>weekly</changefreq>");
					retval.append("<priority>1.0</priority>");
					retval.append("</url>");

				}
			}
			trans.commit();
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		retval.append("</urlset>");
		return retval.toString();
	}
}
