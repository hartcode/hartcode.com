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

}
