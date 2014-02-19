package com.hartcode.modules;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
				sb.append("<div id=\"cultures\"><h2>Strains</h2>");
				
						
				sb.append("<iframe style=\"float:right;border:none;\" src=\"https://rcm-na.amazon-adsystem.com/e/cm?t=harttechsol0b-20&amp;o=1&amp;p=14&amp;l=st1&amp;mode=industrial&amp;search=Yeast+White+Labs&amp;fc1=000000&amp;lt1=_blank&amp;lc1=3366FF&amp;bg1=FFFFFF&amp;f=ifr&amp;internal=1\" marginwidth=\"0\" marginheight=\"0\" width=\"160\" height=\"600\" frameborder=\"0\" scrolling=\"no\"></iframe>");
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
							sb.append("<li><a href=\"/yeastculturesbystrain/"+s.getID()+"\">" + s.getName() + "</a></li>");
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

	@Override
	public String GetTitle() {
		String retval = "Yeast Strains - HartCode";
		return retval;
	}
	@Override
	public String GetDescription() {
		String retval = "The many strains of yeast in my library.";
		return retval;
	}

	@Override
	public Date GetLastModifiedDate() {
		Calendar mycal = Calendar.getInstance();
		mycal.setTimeZone(TimeZone.getTimeZone("UTC"));
		mycal.add(Calendar.SECOND, -1*mycal.get(Calendar.SECOND));
		mycal.add(Calendar.MINUTE, -1*mycal.get(Calendar.MINUTE));
		mycal.add(Calendar.HOUR, -1*mycal.get(Calendar.HOUR));
		return mycal.getTime();
	}
}
