package com.hartcode.news.reader.data;
import java.sql.SQLException;

import com.hartcode.data.mysql.JNDI_DAO;
import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;


public class APPDAO extends JNDI_DAO {
	public APPDAO() throws NullArgumentException, InvalidPortException
	{
		//super("localhost","HartCodeDB","newsman","hwTg42#rk");
		super("jdbc/AmazonAppFree");
	}

	public App Select() throws SQLException
	{
		App retval = null;
		String sql = "SELECT ASIN, Title, IconURL,StarsReview FROM AmazonFreeApp.App order by EffectiveDate desc Limit 1";
		Object[][] obj = Select(sql);
		retval = new App();
		for (int row = 0; row < obj.length; row++)
		{
			retval.setASIN((String)obj[row][0]);
			retval.setTitle((String)obj[row][1]);
			retval.setIconUrl((String)obj[row][2]);
			retval.setStarsOutOfFive((Double)obj[row][3]);
		}
		
		return retval;
	}
	
	
}
