package com.hartcode.news;

import com.hartcode.exceptions.NullArgumentException;
import com.hartcode.news.poster.data.NewsPosterDAO;
import com.hartcode.news.reader.data.NewsReaderDAO;

public class LinkItem {
	private static final int MAX_LOCATION_LENGTH = 256;
	private static final String DEFAULT_LOCATION_TEXT = "";
	private static final boolean DEFAULT_FOLLOW = false;
	private static final Integer DEFAULT_ID = Integer.MIN_VALUE;
	private Integer m_ID = DEFAULT_ID;
	private String m_Location = DEFAULT_LOCATION_TEXT;
	private boolean m_Follow = DEFAULT_FOLLOW;
	private String TableName = "LinkItem";
	public LinkItem(String Location, boolean follow)
	{
		setLocation(Location);
		setFollow(follow);
		SQLInsert();
	}
	public LinkItem(Integer ID)
	{
		setID(ID);
		SQLGet();
	}
	private void setID(Integer iD) {
		m_ID = iD;
	}
	public Integer getID() {
		return m_ID;
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
	private void setFollow(boolean follow) {
		m_Follow = follow;
	}
	public boolean getFollow() {
		return m_Follow;
	}

	private void SQLInsert()
	{
		if (m_ID == null)
		{
			String location = getLocation();
			Integer follow = 0;

			if (getFollow())
			{
				follow = 1;
			}
			if (location.contains("'"))
			{
				location = location.replace("'", "''");
			}	
			String sql = "Insert into "+TableName+" (location,follow) values";
			sql += "('"+location+"',"+follow.toString()+");";
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
			String sql = "Select follow, location from "+TableName+" where ID = " + m_ID.toString();
			try {
				NewsReaderDAO dao = new NewsReaderDAO();
				Object[][] obj = dao.Select(sql);

				Integer follow =(Integer)obj[0][0]; 
				boolean myfollow = false;
				if (follow == 1)
				{
					myfollow = true;
				}
				setFollow(myfollow);
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
			Integer follow = 0;

			if (getFollow())
			{
				follow = 1;
			}
			if (location.contains("'"))
			{
				location = location.replace("'", "''");
			}	
			String sql = "Select ID from "+TableName+" where location = '" + location + "' and follow = '" + follow + "';";
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
		String rel = "";
		if (getFollow() == false)
		{
			rel = "rel=\"nofollow\"";
		}
		String retval = "<a href=\"" + getLocation() + "\" "+rel+">";
		return retval;
	}
}

