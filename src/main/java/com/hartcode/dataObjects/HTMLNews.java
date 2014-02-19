package com.hartcode.dataObjects;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.hartcode.news.NewsItem;
import com.hartcode.news.reader.data.NewsReaderDAO;


public class HTMLNews {

	Integer m_max = 5;
	Date m_mostrecent;
	public HTMLNews()
	{
		
	}
	public HTMLNews(Integer max)
	{
		m_max = max;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<h2>News</h2><ul>");
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		NewsReaderDAO nrd = null;
		NewsItem[] nis = null;
		Calendar mycal = Calendar.getInstance();
		mycal.add(Calendar.YEAR, -25);
		Date mostrecent = mycal.getTime();
		try {
			nrd = new NewsReaderDAO();
			nis = nrd.Select();
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		if (nis != null)
		{
			;
			if (nis.length < m_max)
			{
				m_max = nis.length;
			}
			for(int i = 0; i < m_max; i++)
			{
				if (nis[i].getPostdate().after(mostrecent))
				{
					mostrecent = nis[i].getPostdate();
				}
				sb.append("<li><h3>");
				sb.append(nis[i].getTitle());
				sb.append("</h3><p>");
				sb.append(nis[i].getText());
				sb.append("</p><div>Posted: ");
				sb.append(df.format(nis[i].getPostdate()));
				sb.append("</div></li>");
			}
			m_mostrecent = mostrecent;
		}
		
		sb.append("</ul>");		
		return sb.toString();
	}
	
	public Date GetMostRecentDate()
	{
		return m_mostrecent;
	}
}
