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
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;


public class PhotoAdder {

	public static void AddPhoto(PhotoObject photo) throws Exception
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
	
	
	public static boolean CheckIfExists(String Sql) throws InvalidPortException, SQLException, NullArgumentException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		boolean retval = false;
		if (Sql == null)
		{
			throw new NullArgumentException("Sql");
		}
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
		Object[][] obj = mydao.Select(Sql);
		
		Long myint = (Long)(obj[0][0]);
		if ( myint > 0)
		{
			retval = true;
		} 
		return retval;
	}
	
	public static boolean CheckIfHashExists(String Hash) throws InvalidPortException, SQLException, NullArgumentException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		boolean retval = false;
		if (Hash == null)
		{
			throw new NullArgumentException("Hash");
		}
		retval = CheckIfExists("Select count(*) from vwPhotoFiles where Hash = '" + Hash + "';");
		return retval;
	}
	public static boolean CheckIfNameExists(String Name) throws InvalidPortException, SQLException, NullArgumentException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		boolean retval = false;
		if (Name == null)
		{
			throw new NullArgumentException("Name");
		}
		retval = CheckIfExists("Select count(*) from vwPhoto where Name = '" + Name + "';");
		return retval;
	}

	public static Integer InsertPhotoFiles(Integer PhotoID,String Filename, Integer Height, Integer Width, String Hash) throws NullArgumentException, InvalidPortException, SQLException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
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
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
		mydao.ExecuteSql("insert into PhotoFiles (PhotoID, FileName, Height, Width, Hash) values ("+PhotoID.toString()+",'"+Filename+"',"+Height.toString()+","+Width.toString()+",'"+Hash+"');");

		Object[][] obj = mydao.Select("Select ID from PhotoFiles where FileName = '" + Filename + "';");
		retval = (Integer)(obj[0][0]);
		
		return retval;
	}
	
	public static Integer InsertPhoto(String Name, String Description) throws NullArgumentException, InvalidPortException, SQLException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
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
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
		mydao.ExecuteSql("insert into vwPhoto (Name, Description) values ('"+Name+"','"+Description+"');");

		Object[][] obj = mydao.Select("Select ID from vwPhoto where Name = '" + Name + "';");
		retval = (Integer)(obj[0][0]);
		return retval;
	}
	public static Integer InsertPhoto(String Name) throws NullArgumentException, InvalidPortException, SQLException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
	{
		return InsertPhoto(Name, "");
	}
	public static Integer InsertPhotoDay(Date showDate, Integer PhotoID) throws NullArgumentException, InvalidPortException, SQLException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
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
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(showDate);

		mydao.ExecuteSql("insert into vwPhotoDay (ShowDate, PhotoID) values ('"+strdate+"',"+PhotoID.toString()+");");

		Object[][] obj = mydao.Select("Select ID from vwPhotoDay where ShowDate = '" + strdate + "';");
		retval = (Integer)(obj[0][0]);
		return retval;
	}

	public static Integer[] GetAvailablePhotos() throws NullArgumentException, InvalidPortException, SQLException, FileNotFoundException, ParserConfigurationException, SAXException, IOException
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

	public static Integer CreateRandomPhotoDay(Date thedate) throws Exception
	{
		Integer retval = null;
		Integer[][] voteResults = null;				
		Integer highestvote = -1;
		
		try {
			voteResults = VoteDAO.GetVoteResults(thedate);
		}catch(Exception e)
		{
			throw e;
		}
		if (voteResults != null)
		{
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
				java.security.SecureRandom randomizer = null;
				java.security.SecureRandom randomizer1 = null;
				try {
					randomizer = java.security.SecureRandom.getInstance("SHA1PRNG");
					byte seed[] = randomizer.generateSeed(20);
					randomizer1 = java.security.SecureRandom.getInstance("SHA1PRNG");
					randomizer1.setSeed(seed);
				} catch (NoSuchAlgorithmException e1) {
					randomizer1 = new java.security.SecureRandom();
				}
				index = randomizer1.nextInt(highestvotes.size());
			}
			retval = highestvotes.elementAt(index);
		}
		else
		{
			retval = getRandomPhotoID();
		}
		InsertPhotoDay(thedate, retval);
		return retval;
	}
	
	public static Integer getRandomPhotoID() throws Exception
	{
		Integer retval = null;
		Integer[] avails = GetAvailablePhotos();
		Integer availscount = avails.length;
		if (availscount > 0)
		{
			java.security.SecureRandom randomizer = null;
			java.security.SecureRandom randomizer1 = null;
			try {
				randomizer = java.security.SecureRandom.getInstance("SHA1PRNG");
				byte seed[] = randomizer.generateSeed(20);
				randomizer1 = java.security.SecureRandom.getInstance("SHA1PRNG");
				randomizer1.setSeed(seed);
			} catch (NoSuchAlgorithmException e1) {
				randomizer1 = new java.security.SecureRandom();
			}
			Integer randomindex = randomizer1.nextInt(availscount);
			retval = avails[randomindex];
		}else
		{
			throw new Exception("There are no available Photos");
		}
		return retval;
	}
	
	
	public static Integer GetPhotoDay(Date thedate) throws Exception
	{
		Integer retval = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(thedate);
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
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
	
	public static String GetPhotoFileName(Integer PhotoID) throws Exception
	{
		String retval = null;
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
		Object[][] obj = mydao.Select("Select vpf.FileName from vwPhotoFiles vpf inner join vwLargestPhotoFile vlpf on vpf.ID = vlpf.ID where vlpf.PhotoID = " + PhotoID.toString() + ";");
		if (obj == null || obj.length == 0)
		{ 
			throw new Exception("Couldn't Find FileName for the given PhotoID: " + PhotoID.toString());
		}else
		{
			retval = (String)(obj[0][0]);
		} 
		return retval;
	}
	
	public static String GetPhotoFileName(Integer PhotoID, Integer Height, Integer Width) throws Exception
	{
		String retval = null;
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
		Object[][] obj = mydao.Select("Select vpf.FileName from vwPhotoFiles vpf where vpf.PhotoID = " + PhotoID.toString() + " and vpf.Height = " + Height.toString()+  " and vpf.Width = " + Width.toString() + ";");
		if (obj == null || obj.length == 0)
		{ 
			// Need to create different sized file
			String filename = GetPhotoFileName(PhotoID);
			String outfilename = filename.replace(".jpg", "-" +Width.toString() + "x" + Height.toString() + ".jpg");
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
			PhotoObject pho = new PhotoObject(outfilename,outfilename.substring(0,25),outfilename);
			ImageDimension size = pho.getDimensions();
			InsertPhotoFiles(PhotoID,pho.getFileName(),size.Height,size.Width,pho.getHash());
			obj = mydao.Select("Select vpf.FileName from vwPhotoFiles vpf where vpf.PhotoID = " + PhotoID.toString() + " and vpf.Height = " + Height.toString()+  " and vpf.Width = " + Width.toString() + ";");
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
	
}
	

