package com.hartcode.news;

import com.hartcode.exceptions.NullArgumentException;
import com.hartcode.news.poster.data.NewsPosterDAO;
import com.hartcode.news.reader.data.NewsReaderDAO;

public class ImageItem {
	private static final int MAX_ALT_TEXT_LENGTH = 50;
	private static final int MAX_LOCATION_LENGTH = 256;
	private static final String DEFAULT_ALT_TEXT = "";
	private static final String DEFAULT_LOCATION_TEXT = "";
	private static final int DEFAULT_ID = Integer.MIN_VALUE;
	private Integer m_ID = DEFAULT_ID;
	private String m_AltText = DEFAULT_ALT_TEXT;
	private String m_Location = DEFAULT_LOCATION_TEXT;
	private String TableName = "ImageItem";
	public ImageItem(Integer ID)
	{
		setID(ID);
		SQLGet();
	}
	public ImageItem(String altText, String location)
	{
		setAltText(altText);
		setLocation(location);
		SQLInsert();
	}
	
	private void setID(Integer iD) {
		m_ID = iD;
	}
	public Integer getID() {
		return m_ID;
	}
	private void setAltText(String altText) {
		if (altText == null)
		{
			throw new NullArgumentException("altText");
		}
		if (altText.length() > MAX_ALT_TEXT_LENGTH)
		{
			altText = altText.substring(0,MAX_ALT_TEXT_LENGTH);
		}
		m_AltText = altText;
	}
	public String getAltText() {
		String retval = null;
		if (m_AltText == null)
		{
			retval = DEFAULT_ALT_TEXT;
		}
		else
		{
			retval=m_AltText;
		}

		return retval;

	}
	private void setLocation(String location) {
		if (location == null)
		{
			throw new NullArgumentException("location");
		}
		if (location.length() > MAX_LOCATION_LENGTH)
		{
			location = location.substring(0,MAX_LOCATION_LENGTH);
		}
		m_Location = location;
	}
	public String getLocation() {
		String retval = null;
		if (m_Location == null)
		{
			retval = DEFAULT_LOCATION_TEXT;
		}
		else
		{
			retval=m_Location;
		}

		return retval;
	}
	
	private void SQLInsert()
	{
		if (m_ID == null)
		{
			String location = getLocation();
			String alttext = getAltText();
			

			if (alttext.contains("'"))
			{
				alttext = alttext.replace("'", "''");
			}
			if (location.contains("'"))
			{
				location = location.replace("'", "''");
			}	
			String sql = "Insert into "+TableName+" (alttext,location) values";
			sql += "('"+alttext+"','"+location+"');";
			try {
				NewsPosterDAO dao = new NewsPosterDAO();
				dao.ExecuteSql(sql);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			SQLGetID();
		}
	}
	private void SQLGet()
	{
		if (m_ID != null)
		{
			String sql = "Select alttext, location from "+TableName+" where ID = " + m_ID.toString();
			try {
			NewsReaderDAO dao = new NewsReaderDAO();
			Object[][] obj = dao.Select(sql);
				setAltText((String)obj[0][0]);
				setLocation((String)obj[0][1]);
			}catch(Exception e)
			{
				
			}
		}
	}
	private void SQLGetID()
	{
		if (m_ID == null)
		{
			String location = getLocation();
			String alttext = getAltText();
			if (alttext.contains("'"))
			{
				alttext = alttext.replace("'", "''");
			}
			if (location.contains("'"))
			{
				location = location.replace("'", "''");
			}	
			String sql = "Select ID from "+TableName+" where alttext = '" + alttext + "' and location = '" + location + "';";
			try {
			NewsReaderDAO dao = new NewsReaderDAO();
			Object[][] obj = dao.Select(sql);
				setID((Integer)obj[0][0]);
			}catch(Exception e)
			{
				
			}
		}
	}

	public String toString()
	{
		String retval = "<img src=\"" + getLocation() + "\" alt=\""+getAltText()+"\"/>";
		return retval;
	}
}
