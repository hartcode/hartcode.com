package dataObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.hartcode.news.NewsItem;
import com.hartcode.news.reader.data.NewsReaderDAO;

public class HTMLNews1 extends HTMLNews {

	public HTMLNews1() {
	super();
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<h2>News</h2><ul>");
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		NewsReaderDAO nrd = null;
		NewsItem[] nis = null;
		try {
			nrd = new NewsReaderDAO();
			nis = nrd.Select();
		}catch(Exception se)
		{
			se.printStackTrace();
		}
		if (nis != null && nis.length > 0)
		{
			int i = 0;
			
				sb.append("<li><h3>");
				sb.append(nis[i].getTitle());
				sb.append("</h3><p>");
				sb.append(nis[i].getText());
				sb.append("</p><div>Posted: ");
				sb.append(df.format(nis[i].getPostdate()));
				sb.append("</div></li>");
			
		}
		
		sb.append("</ul>");		
		return sb.toString();
	}
}
