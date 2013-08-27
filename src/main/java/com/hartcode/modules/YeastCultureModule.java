package com.hartcode.modules;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.hartcode.libyeast.hibernate.HibernateUtil;


public class YeastCultureModule implements IMainModule {
	static Logger logger = Logger.getLogger(YeastCultureModule.class);
	protected HttpServletRequest m_request;
	protected Date m_lastmoddate;
	public YeastCultureModule() {

	}

	
	public String GetMainModule() 
	{
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		StringBuilder sb = new StringBuilder();
		Integer CultureID = -1;
		String strCleanCultureID = null;
		String strCultureID = m_request.getParameter("ID");
		Calendar mycal = Calendar.getInstance();
		mycal.add(Calendar.YEAR, -25);
		Date lastmoddate = mycal.getTime();
		if (strCultureID != null) 
		{
			CultureID = Integer.valueOf(strCultureID);
			strCleanCultureID = CultureID.toString();
		} else {
			logger.warn("ID parameter was empty");
		}

		Session session = HibernateUtil.getSessionFactory().openSession();
		Culture c = null;
		Strain s = null;
		List<CultureLocation> cl = null;
		List<Culture> cc = null;
		try 
		{
			Criteria crit = session.createCriteria(Culture.class);
			c = (Culture)crit.add(Restrictions.eq("ID", CultureID)).uniqueResult();
		
		
			if (c != null) {
				if (c.getCreateDate().after(lastmoddate))
				{
					lastmoddate = c.getCreateDate();
				}
				Criteria crit2 = session.createCriteria(CultureLocation.class);
				cl =  crit2.add(Restrictions.eq("Culture", c)).addOrder(Order.desc("MoveDate")).list();
				
				Criteria crit3 = session.createCriteria(Culture.class);
				cc =  crit3.add(Restrictions.eq("Source", c)).addOrder(Order.asc("CreateDate")).list();
				
			}
		} catch (Exception e) {
		
			logger.error("Exception: ", e);
			sb.append("<p>"+e.getMessage()+"</p>");
		}

		if (c != null) 
		{
			if (c.getStrain() != null) 
			{
				s = c.getStrain();
				sb.append("<div id=\"cultures\"><h2>Culture "
						+ strCleanCultureID + " </h2>");
				
				sb.append("<h3>Culture</h3>");
				String strainsearch = s.getName().trim();
				strainsearch = strainsearch.replace('\\', ' ');
				strainsearch = strainsearch.replace('/', ' ');
				strainsearch = strainsearch.replace('+', ' ');
				strainsearch = strainsearch.replace('-', ' ');
				strainsearch = strainsearch.replace(' ', '+');
						
				sb.append("<iframe style=\"float:right;border:none;\" src=\"https://rcm-na.amazon-adsystem.com/e/cm?t=harttechsol0b-20&amp;o=1&amp;p=14&amp;l=st1&amp;mode=industrial&amp;search=Yeast+"+strainsearch+"&amp;fc1=000000&amp;lt1=_blank&amp;lc1=3366FF&amp;bg1=FFFFFF&amp;f=ifr&amp;internal=1\" marginwidth=\"0\" marginheight=\"0\" width=\"160\" height=\"600\" frameborder=\"0\" scrolling=\"no\"></iframe>");
				sb.append("<ul><li><span class=\"bold\">ID:</span> " + strCleanCultureID + "</li>");
				sb.append("<li><span class=\"bold\">Generation:</span> " + c.getGeneration() + "</li>");
				sb.append("<li><span class=\"bold\">Creation Date:</span> " + df.format(c.getCreateDate()) + "</li>");
				sb.append("<li><span class=\"bold\">Type:</span> " + c.getCultureType().getName() + "</li>");
				if (c.getSource() != null) 
				{
					sb.append("<li><span class=\"bold\">Parent:</span> <a href=\"/yeast/"
							+ c.getSource().getID() + "\">Culture "
							+ c.getSource().getID() + "</a></li>");
				}
				if (cc != null) 
				{
					sb.append("<li><span class=\"bold\">Children:</span> ");
					for (Culture myc : cc) 
					{
						
					sb.append("<a href=\"/yeast/"
							+ myc.getID() + "\">Culture "
							+myc.getID() + "</a> ");
					}
					sb.append("</li>");
				}
				sb.append("</ul>");
				sb.append("<h3>Strain</h3>");
				sb.append("<ul><li><span class=\"bold\">Name:</span> " + s.getName() + "</li>");
				sb.append("<li><span class=\"bold\">OrignID:</span> " + s.getOriginID() + "</li>");
				sb.append("<li><span class=\"bold\">Description:</span> " + s.getDescription() + "</li>");
				sb.append("<li><span class=\"bold\">Type:</span> " + s.getStrainType().getName() + "</li>");
				sb.append("<li><span class=\"bold\">Temperature:</span> " + s.getTempLow() + " - "
						+ s.getTempHigh() + "</li>");
				sb.append("<li><span class=\"bold\">Flocculation:</span> " + s.getFlocculation().getName()
						+ "</li>");
				sb.append("<li><span class=\"bold\">Attenuation:</span> " + s.getAttenuationLow() + " - "
						+ s.getAttenuationHigh() + "</li>");
				sb.append("<li><span class=\"bold\">Alcohol Tolerance:</span> " + s.getTolerance()
						+ "</li>");
				sb.append("</ul>");
				
								

				sb.append("<h3>Location</h3>");
				sb.append("<div id=\"location\"><ul>");
				if (cl != null) 
				{
					logger.info("cl is not null");
					for (CultureLocation mycl : cl) 
					{
						if (mycl.getMoveDate().after(lastmoddate))
						{
							lastmoddate = mycl.getMoveDate();
						}
						sb.append("<li><ul>");
						sb.append("<li>" +df.format(mycl.getMoveDate()) + "</li>");
						sb.append("<li>" + mycl.getLocation().getName()
								+ "</li>");
						if (mycl.getReason() != null)
						{
							sb.append("<li>" + mycl.getReason() + "</li>");
						}
						sb.append("</ul></li>");
					}
					
				}
				sb.append("</ul>");
				sb.append("</div>");
				
				sb.append("<h3>QR Code</h3>");
				sb.append("<img src=\"https://chart.googleapis.com/chart?cht=qr&amp;chs=50x50&amp;chl=http%3A%2F%2Fwww.hartcode.com%2Fyeast%2F"+strCleanCultureID+"\" alt=\"QR Code for "+strCleanCultureID+"\" title=\""+strCleanCultureID+"\"/>");
  			    sb.append("</div>");

			} else 
			{
				logger.info("strain not found");
			}

		} else 
		{
			logger.info("culture not found");
			sb.append("<div id=\"cultures\"><h2>Culture Not Found</h2></div>");
		}

		m_lastmoddate = lastmoddate;
		return sb.toString();
	}

	public void SetRequest(HttpServletRequest request) {
		m_request = request;
	}
	@Override
	public String GetTitle() {
		String strCleanCultureID = null;
		String strCultureID = m_request.getParameter("ID");
		if (strCultureID != null) 
		{
			Integer CultureID = Integer.valueOf(strCultureID);
			strCleanCultureID = CultureID.toString();
		} else {
			logger.warn("ID parameter was empty");
		}

		String retval = "Yeast Culture " +strCleanCultureID +" - HartCode";
		return retval;
	}
	@Override
	public String GetDescription() {
		String retval = "A culure of yeast in my library.";
		return retval;
	}


	@Override
	public Date GetLastModifiedDate() {
		
		return m_lastmoddate;
	}
}
