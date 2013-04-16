package com.hartcode.modules;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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


public class YeastCulturesListByStrainModule implements IMainModule {
	static Logger logger = Logger.getLogger(YeastCulturesListByStrainModule.class);
	protected HttpServletRequest m_request;

	public YeastCulturesListByStrainModule() {

	}

	
	public String GetMainModule() 
	{
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		StringBuilder sb = new StringBuilder();
		Integer StrainID = -1;
		String strCleanStrainID = null;
		String strStrainID = m_request.getParameter("ID");
		if (strStrainID != null) 
		{
			StrainID = Integer.valueOf(strStrainID);
			strCleanStrainID = StrainID.toString();
		} else {
			logger.warn("ID parameter was empty");
		}
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Strain st = null;
		List<Culture> cl = null;
		
		try 
		{
			Criteria crit = session.createCriteria(Strain.class);
			st = (Strain)crit.add(Restrictions.eq("ID",StrainID)).uniqueResult();
			
		} catch (Exception e) {
		
			logger.error("Exception: ", e);
			sb.append("<p>"+e.getMessage()+"</p>");
		}
		if (st != null)
		{
			sb.append("<h2>" + st.getName()+"</h2>");
			String strainsearch = st.getName().trim();
			strainsearch = strainsearch.replace('\\', ' ');
			strainsearch = strainsearch.replace('/', ' ');
			strainsearch = strainsearch.replace('+', ' ');
			strainsearch = strainsearch.replace('-', ' ');
			strainsearch = strainsearch.replace(' ', '+');
					
			sb.append("<iframe style=\"float:right;border:none;\" src=\"http://rcm.amazon.com/e/cm?t=harttechsol0b-20&amp;o=1&amp;p=14&amp;l=st1&amp;mode=industrial&amp;search=Yeast+"+strainsearch+"&amp;fc1=000000&amp;lt1=_blank&amp;lc1=3366FF&amp;bg1=FFFFFF&amp;f=ifr\" marginwidth=\"0\" marginheight=\"0\" width=\"160\" height=\"600\"  frameborder=\"0\" scrolling=\"no\"></iframe>");
		
					try 
					{
						Criteria crit2 = session.createCriteria(Culture.class);
						cl = crit2.add(Restrictions.eq("Strain", st)).list();
					} catch (Exception e) {
					
						logger.error("Exception: ", e);
						sb.append("<p>"+e.getMessage()+"</p>");
					}
				
					if (cl != null)
					{
						sb.append("<ul>");
						for (Culture c : cl) 
						{
							sb.append("<li><a href=\"/yeast/"
							+ c.getID() + "\">Culture "
							+ c.getID() + "</a></li>");
						}
						sb.append("</ul>");	
					} else 
					{
						logger.info("Cultures not found");
					}
				
					
		}else
		{
			logger.warn("Strain was not found.");
		}
		
		

		return sb.toString();
	}

	public void SetRequest(HttpServletRequest request) {
		m_request = request;
	}
	@Override
	public String GetTitle() {
		String strCleanStrainID = null;
		String strStrainID = m_request.getParameter("ID");
		if (strStrainID != null) 
		{
			Integer StrainID = Integer.valueOf(strStrainID);
			strCleanStrainID = StrainID.toString();
		} else {
			logger.warn("ID parameter was empty");
		}
		String retval = "Yeast Strain " +strCleanStrainID + " - HartCode";
		return retval;
	}
	@Override
	public String GetDescription() {
		String retval = "The many yeast cultures in my library by strain.";
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
