package com.hartcode.news.reader.data;
import com.hartcode.news.*;
import java.sql.SQLException;

import com.hartcode.data.mysql.DAO;
import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;


public class NewsReaderDAO extends JNDI_DAO {
	public NewsReaderDAO() throws NullArgumentException, InvalidPortException
	{
		//super("localhost","HartCodeDB","newsman","hwTg42#rk");
		super("jdbc/newsreader");
	}

	public NewsItem[] Select() throws SQLException
	{
		NewsItem[] retval = null;
		String sql = "Select title, text, postdate, hash from currentnews;";
		Object[][] obj = Select(sql);
		retval = new NewsItem[obj.length];
		for (int row = 0; row < obj.length; row++)
		{
			NewsItem ni = new NewsItem();
			
			ni.setTitle((String)obj[row][0]);
			ni.setText((String)obj[row][1]);
			ni.setPostdate((java.util.Date)obj[row][2]);
			ni.setHash((String)obj[row][3]);
			retval[row] = ni;
		}
		
		return retval;
	}
	
	
}
