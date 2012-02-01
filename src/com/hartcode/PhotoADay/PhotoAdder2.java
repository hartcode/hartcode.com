package com.hartcode.PhotoADay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;


import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;
import com.hartcode.library.random.Random;


public class PhotoAdder2 {
	static Logger logger = Logger.getLogger(PhotoAdder2.class);
	PhotoADayDAO mydao = null;
	public PhotoAdder2() throws NullArgumentException, FileNotFoundException, InvalidPortException, ParserConfigurationException, SAXException, IOException
	{
		logger.debug("Getting PhotoADayDAO() object.");
		mydao = new PhotoADayDAO();
		logger.debug("Finished getting PhotoADayDAO() object.");
	}
	
	public  void AddPhoto(PhotoObject photo) throws Exception
	{
	if (photo == null)
	{
		throw new NullArgumentException("photo");
	}
	Boolean doesHashExistInDB = false;
	Boolean doesNameExistInDB = false;
	try {
		doesHashExistInDB = CheckIfHashExists(photo.getHash());
		doesNameExistInDB = CheckIfNameExists(photo.getName());
	} catch (InvalidPortException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
		if (doesHashExistInDB || doesNameExistInDB)
		{
			throw new Exception("Photo Already Exists In Database");
		}
		ImageDimension size = photo.getDimensions();
		Integer PhotoID = InsertPhoto(photo.getName(),photo.getDescription());
		InsertPhotoFiles(PhotoID,photo.getFileName(),size.Height,size.Width,photo.getHash());
	
	}
	
	
	public  boolean CheckIfExists(String Sql) throws InvalidPortException, SQLException, NullArgumentException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		boolean retval = false;
		if (Sql == null)
		{
			throw new NullArgumentException("Sql");
		}
		Object[][] obj = mydao.Select(Sql);
		
		Long myint = (Long)(obj[0][0]);
		if ( myint > 0)
		{
			retval = true;
		} 
		return retval;
	}
	
	public  boolean CheckIfHashExists(String Hash) throws InvalidPortException, SQLException, NullArgumentException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		boolean retval = false;
		if (Hash == null)
		{
			throw new NullArgumentException("Hash");
		}
		retval = CheckIfExists("Select count(*) from vwPhotoFiles where Hash = '" + Hash + "';");
		return retval;
	}
	public  boolean CheckIfNameExists(String Name) throws InvalidPortException, SQLException, NullArgumentException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		boolean retval = false;
		if (Name == null)
		{
			throw new NullArgumentException("Name");
		}
		retval = CheckIfExists("Select count(*) from vwPhoto where Name = '" + Name + "';");
		return retval;
	}

	public  Integer InsertPhotoFiles(Integer PhotoID,String Filename, Integer Height, Integer Width, String Hash) throws NullArgumentException, InvalidPortException, SQLException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		Integer retval = null;
		if (PhotoID == null)
		{
			throw new NullArgumentException("PhotoID");
		}
		if (Filename == null)
		{
			throw new NullArgumentException("Filename");
		}
		if (Height == null)
		{
			throw new NullArgumentException("Height");
		}
		if (Width == null)
		{
			throw new NullArgumentException("Width");
		}
		if (Hash == null)
		{
			throw new NullArgumentException("Hash");
		}
		if (Hash.length() > 128)
		{
			Hash = Hash.substring(0,128);
		}
		
		mydao.ExecuteSql("insert into PhotoFiles (PhotoID, FileName, Height, Width, Hash) values ("+PhotoID.toString()+",'"+Filename+"',"+Height.toString()+","+Width.toString()+",'"+Hash+"');");

		Object[][] obj = mydao.Select("Select ID from PhotoFiles where FileName = '" + Filename + "';");
		retval = (Integer)(obj[0][0]);
		
		return retval;
	}
	
	public  Integer InsertPhoto(String Name, String Description) throws NullArgumentException, InvalidPortException, SQLException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		Integer retval = null;
		if (Name == null)
		{
			throw new NullArgumentException("Name");
		}
		if (Description == null)
		{
			throw new NullArgumentException("Description");
		}
		mydao.ExecuteSql("insert into vwPhoto (Name, Description) values ('"+Name+"','"+Description+"');");

		Object[][] obj = mydao.Select("Select ID from vwPhoto where Name = '" + Name + "';");
		retval = (Integer)(obj[0][0]);
		return retval;
	}
	public  Integer InsertPhoto(String Name) throws NullArgumentException, InvalidPortException, SQLException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		return InsertPhoto(Name, "");
	}
	public  Integer InsertPhotoDay(Date showDate, Integer PhotoID) throws NullArgumentException, InvalidPortException, SQLException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		Integer retval = null;
		if (showDate == null)
		{
			throw new NullArgumentException("showDate");
		}
		if (PhotoID == null)
		{
			throw new NullArgumentException("PhotoID");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(showDate);

		mydao.ExecuteSql("insert into vwPhotoDay (ShowDate, PhotoID) values ('"+strdate+"',"+PhotoID.toString()+");");

		Object[][] obj = mydao.Select("Select ID from vwPhotoDay where ShowDate = '" + strdate + "';");
		retval = (Integer)(obj[0][0]);
		return retval;
	}

	public  Integer[] GetAvailablePhotos() throws NullArgumentException, InvalidPortException, SQLException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		Integer[] retval = null;
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
		Object[][] obj = mydao.Select("Select * from vwAvailablePhotos;");
		
		int rowcount = obj.length;
		retval = new Integer[rowcount];
		for (int ri = 0; ri < rowcount; ri++)
		{
			retval[ri] = (Integer)obj[ri][0];
		}
		return retval;
	}

	public  Integer CreateRandomPhotoDay(Date thedate) throws Exception
	{
		logger.debug("Getting Random PhotoDay");
		Integer retval = null;
		Integer[][] voteResults = null;				
		Integer highestvote = -1;
		VoteDAO2 myvotedao = new VoteDAO2(mydao);
		try {
			voteResults = myvotedao.GetVoteResults(thedate);
		}catch(Exception e)
		{
			throw e;
		}
		if (voteResults != null)
		{
			logger.debug("We have Vote Results");
			Vector<Integer> highestvotes = new Vector<Integer>();
			for(int i= 0; i<voteResults.length;i++)
			{
				if (highestvote < voteResults[i][1])
				{
					highestvotes.clear();
					highestvote = voteResults[i][1];
					highestvotes.add(voteResults[i][0]);
					retval = voteResults[i][0];
				}else if (highestvote.equals(voteResults[i][1]))
				{
					highestvotes.add(voteResults[i][0]);
				}
				
			}
			Integer index;
			if (highestvotes.size() == 1)
			{
				index = 0;
			}else
			{
				
				index = Random.getRandomInt(highestvotes.size());
			}
			retval = highestvotes.elementAt(index);
		}
		else
		{
			logger.debug("We DON'T have Vote Results");
			retval = getRandomPhotoID();
		}
		InsertPhotoDay(thedate, retval);
		return retval;
	}
	
	public  Integer getRandomPhotoID() throws Exception
	{
		Integer retval = null;
		Integer[] avails = GetAvailablePhotos();
		Integer availscount = avails.length;
		if (availscount > 0)
		{
			Integer randomindex = Random.getRandomInt(availscount);
			retval = avails[randomindex];
		}else
		{
			throw new Exception("There are no available Photos");
		}
		return retval;
	}
	
	
	public  Integer GetPhotoDay(Date thedate) throws Exception
	{
		Integer retval = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(thedate);
		;
		Object[][] obj = mydao.Select("Select PhotoID from vwPhotoDay where ShowDate = '" + strdate + "';");
		if (obj == null || obj.length == 0)
		{ 
			
			retval = CreateRandomPhotoDay(thedate);
		}else
		{
			retval = (Integer)(obj[0][0]);
		}
		return retval;
	}
	
	public  String GetPhotoFileName(Integer PhotoID) throws Exception
	{
		String retval = null;
		logger.debug("Getting Photo File Name");
		logger.debug("PhotoID: " + PhotoID);
		
		logger.debug("Selecting");
		Object[][] obj = mydao.Select("Select vpf.FileName from vwPhotoFiles vpf inner join vwLargestPhotoFile vlpf on vpf.ID = vlpf.ID where vlpf.PhotoID = " + PhotoID.toString() + ";");
		logger.debug("Finished Selecting");
		if (obj == null || obj.length == 0)
		{ 
			throw new Exception("Couldn't Find FileName for the given PhotoID: " + PhotoID.toString());
		}else
		{
			retval = (String)(obj[0][0]);
		} 
		return retval;
	}
	
	public  String GetPhotoFileName(Integer PhotoID, Integer Height, Integer Width) throws Exception
	{
		String retval = null;
		logger.debug("Getting Photo File Name");
		logger.debug("PhotoID: " + PhotoID);
		logger.debug("Height: " + Height);
		logger.debug("Width: " + Width);
		
		logger.debug("Selecting");
		Object[][] obj = mydao.Select("Select vpf.FileName from vwPhotoFiles vpf where vpf.PhotoID = " + PhotoID.toString() + " and vpf.Height = " + Height.toString()+  " and vpf.Width = " + Width.toString() + ";");
		logger.debug("Finished Selecting");
		if (obj == null || obj.length == 0)
		{ 
			// Need to create different sized file
			logger.warn("Photo file not found in the proper size. Get the largest photo and create an image in the proper size.");
			String filename = GetPhotoFileName(PhotoID);
			logger.debug("Got Largest Photo");
			String outfilename = filename.replace(".jpg", "-" +Width.toString() + "x" + Height.toString() + ".jpg");
			logger.debug("Begin Resize");
			FileInputStream fis = new FileInputStream(filename);
			FileOutputStream fos = new FileOutputStream(outfilename);
			BufferedImage bi = ImageIO.read(fis);
			fis.close();
			 BufferedImage scaledBI = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
		        Graphics2D g = scaledBI.createGraphics();
		        g.setComposite(AlphaComposite.Src);
		        g.drawImage(bi, 0, 0, Width, Height, null);
		        g.dispose();
			ImageIO.write(scaledBI,"JPG",(OutputStream)fos);
			fos.close();
			logger.debug("End Resize");
			
			PhotoObject pho = new PhotoObject(outfilename,outfilename.substring(0,25),outfilename);
			ImageDimension size = pho.getDimensions();
			logger.debug("Add new photo size to database.");
			InsertPhotoFiles(PhotoID,pho.getFileName(),size.Height,size.Width,pho.getHash());
			logger.debug("Selecting");
			obj = mydao.Select("Select vpf.FileName from vwPhotoFiles vpf where vpf.PhotoID = " + PhotoID.toString() + " and vpf.Height = " + Height.toString()+  " and vpf.Width = " + Width.toString() + ";");
			logger.debug("Finished Selecting");
			if (obj == null || obj.length == 0)
			{
				throw new Exception("Couldn't Find FileName for the given PhotoID and size: " + PhotoID.toString());
			}else
			{
				retval = (String)(obj[0][0]);
			}
			
		}else
		{
			
			retval = (String)(obj[0][0]);
		} 
		return retval;
	}
	
	public void closeConnections()
	{
	/*	try {
			//mydao.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}
	

