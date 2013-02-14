package com.hartcode.dataObjects;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.hartcode.news.NewsItem;
import com.hartcode.news.reader.data.NewsReaderDAO;


public class RSSNews {

	public RSSNews()
	{
	
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		NewsReaderDAO nrd = null;
		NewsItem[] nis = null;
		try {
			nrd = new NewsReaderDAO();
			nis = nrd.Select();
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		if (nis != null)
		{
			for(int i = 0; i < nis.length; i++)
			{
				sb.append("<item><title>");
				sb.append(nis[i].getTitle());
				sb.append("</title><description>");
				sb.append(nis[i].getText());
				sb.append("</description><link>http://www.hartcode.com/</link><guid>");
				sb.append(nis[i].getHash());;
				sb.append("</guid><pubDate>");
				sb.append(df.format(nis[i].getPostdate()));
				sb.append("</pubDate>");
				sb.append("</item>");
			}
		}
		return sb.toString();
	}
}