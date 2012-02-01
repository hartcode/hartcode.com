package com.hartcode.news.poster.data;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.hartcode.data.mysql.JNDI_DAO;
import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;
import com.hartcode.news.NewsItem;

public class NewsPosterDAO extends JNDI_DAO {
	public NewsPosterDAO() throws NullArgumentException, InvalidPortException
	{
		super("jdbc/newsposter");
		//super("localhost","HartCodeDB","newspostman","h289GH@t");
	}

	public void Insert(NewsItem ni) throws SQLException, NullArgumentException 
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss" );
		String title = ni.getTitle();
		String text = ni.getText();
		String date =df.format(ni.getPostdate());
		String hash = ni.getHash();
		
		if (title.contains("'"))
		{
			title = title.replace("'", "''");
		}
		if (text.contains("'"))
		{
			text = text.replace("'", "''");
		}
		if (hash.contains("'"))
		{
			hash = hash.replace("'", "''");
		}
		String sql = "Insert into NewsItem (title,text,postdate,hash) values";
		sql += "('"+title+"','"+text+"','"+date+"','"+hash+"');";
		ExecuteSql(sql);
	}
}
