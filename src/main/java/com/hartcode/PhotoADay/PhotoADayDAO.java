package com.hartcode.PhotoADay;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.hartcode.data.mysql.JNDI_DAO;
import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;


public class PhotoADayDAO extends JNDI_DAO {

	
	public PhotoADayDAO()
			throws InvalidPortException, NullArgumentException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
			{
		//super("localhost",3306, "PhotoADay", "root","psw754It#");
		//super("184.168.92.162",3306, "PhotoADay", "root","psw754It#");
		super("jdbc/photoaday");
		//super(ConnectionDataFromXml.fromXMLInputStream(new FileInputStream("/var/connections/photoaday.xml"))[0]);
		
	}
	

}
