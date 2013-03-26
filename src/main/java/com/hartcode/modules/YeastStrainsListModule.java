package com.hartcode.modules;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.DefaultEditorKit.CutAction;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.hartcode.libyeast.Culture;
import com.hartcode.libyeast.CultureLocation;
import com.hartcode.libyeast.Strain;
import com.hartcode.libyeast.StrainType;
import com.hartcode.libyeast.hibernate.HibernateUtil;


public class YeastStrainsListModule implements IMainModule {
	static Logger logger = Logger.getLogger(YeastStrainsListModule.class);
	protected HttpServletRequest m_request;

	public YeastStrainsListModule() {

	}

	
	public String GetMainModule() 
	{
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		StringBuilder sb = new StringBuilder();
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<StrainType> cst = null; 
		List<Strain> cs = null;
		
		try 
		{
			Criteria crit = session.createCriteria(StrainType.class);
			cst = crit.addOrder(Order.asc("name")).list();
		
		} catch (Exception e) {
		
			logger.error("Exception: ", e);
			sb.append("<p>"+e.getMessage()+"</p>");
		}

		if (cst != null) 
		{
				sb.append("<div id=\"cultures\"><h2>Strains<h2>");
				
						
				sb.append("<iframe style=\"float:right;\" src=\"http://rcm.amazon.com/e/cm?t=harttechsol0b-20&o=1&p=14&l=st1&mode=industrial&search=Yeast+White+Labs&fc1=000000&lt1=_blank&lc1=3366FF&bg1=FFFFFF&f=ifr\" marginwidth=\"0\" marginheight=\"0\" width=\"160\" height=\"600\" border=\"0\" frameborder=\"0\" style=\"border:none;\" scrolling=\"no\"></iframe>");
				for (StrainType st : cst) 
				{
					try 
					{
						Criteria crit = session.createCriteria(Strain.class);
						cs = crit.add(Restrictions.eq("StrainType", st)).addOrder(Order.asc("name")).list();
					} catch (Exception e) {
					
						logger.error("Exception: ", e);
						sb.append("<p>"+e.getMessage()+"</p>");
					}
				
					if (cs != null)
					{
						sb.append("<h3>"+st.getName()+"</h3>");
						sb.append("<ul>");
						for (Strain s : cs) 
						{
							sb.append("<li><a href=\"/yeastculturesbystrain?ID="+s.getID()+"\">" + s.getName() + "</a></li>");
						}
						sb.append("</ul>");
					} else 
					{
						logger.info("Strains not found");
					}
				
				}
				sb.append("</div>");
		} else 
		{
			logger.info("StrainTypes not found");
		}
	

		return sb.toString();
	}

	public void SetRequest(HttpServletRequest request) {
		m_request = request;
	}

}
