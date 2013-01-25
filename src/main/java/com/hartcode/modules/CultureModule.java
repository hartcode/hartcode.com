package com.hartcode.modules;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.xml.sax.SAXException;

import com.hartcode.PhotoADay.VoteDAO2;
import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;
import com.hartcode.libyeast.Culture;
import com.hartcode.libyeast.Strain;
import com.hartcode.libyeast.hibernate.HibernateUtil;
import com.hartcode.servlets.PhotoVote;


public class CultureModule implements IMainModule {
	static Logger logger = Logger.getLogger(CultureModule.class);
	protected HttpServletRequest m_request;
	public CultureModule()
	{
		
	}
	
	public String GetMainModule() {
		StringBuilder sb = new StringBuilder();
		Integer CultureID = -1;
		String strCleanCultureID = null;
		String strCultureID = m_request.getParameter("ID");
		if (strCultureID != null)
		{
			CultureID = Integer.valueOf(strCultureID);
			strCleanCultureID = CultureID.toString();
		}else
		{
			logger.warn("ID parameter was empty");
		}
		
		 Session session = HibernateUtil.getSessionFactory().openSession();
		  
	     session.beginTransaction();
	     try {
	    	 	Culture c = null;
	    	 	Strain s = null;
	    	 	Criteria crit = session.createCriteria(Culture.class);
	    	 	c  = (Culture)crit.add(Restrictions.eq("ID", 1)).uniqueResult(); 
				if (c != null)
				{
					if (c.getStrain()!= null)
					{
						s = c.getStrain();
						sb.append("<div id=\"ChoicesResults\"><h2>Culture " + strCleanCultureID + " </h2>");
						sb.append("<p id=\"first\"> </p><h3>Strain</h3>");
						sb.append("<p>"+s.getName()+"</p>");
					}else
					{
						logger.info("strain not found");
					}
					
				}else
				{
					logger.info("culture not found");
				}
	     }catch(Exception e)
	     {
	    	 logger.error("Exception: ",e);
	     }

		return sb.toString();
	}
	 
	public void SetRequest(HttpServletRequest request) {
		m_request = request;
	}




}
