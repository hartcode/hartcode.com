package com.hartcode.servlets.amazonfreeapp;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;
import com.hartcode.news.reader.data.APPDAO;
import com.hartcode.news.reader.data.App;
import com.hartcode.servlets.ServletPage;

public class AmazonFreeAppXml extends ServletPage {
	  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3223839588393304009L;

	public String GetFileData(HttpServletRequest request)
	{
		String retval = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
		try {
			APPDAO ad = new APPDAO();
			App myapp = ad.Select();
			retval += "<app><title>"+myapp.getTitle()+"</title><asin>"+myapp.getASIN()+"</asin><icon>"+myapp.getIconUrl()+"</icon><stars>"+myapp.getStarsOutOfFive()+"</stars></app>";
		
		} catch (NullArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retval;
	}
	    
}
