package com.hartcode.PhotoADay;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.imageio.ImageIO;

import com.hartcode.exceptions.NullArgumentException;

public class PhotoObject {
	
	String m_Filename = null;
	ImageDimension m_Dimensions = null;
	String m_Hash = null;
	String m_Name = null;
	String m_Description = null;
	public PhotoObject(String Filename) throws IOException
	{
		if (Filename == null)
		{
			throw new NullArgumentException("Filename");
		}
		m_Filename = Filename;
		try {
			m_Hash = CalculateHash(m_Filename, "SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			m_Hash = "NO HASH";
		}
		m_Dimensions = GetImageSize(m_Filename);
	}
	public PhotoObject(String Filename, String Name) throws IOException 
	{
		this(Filename);
		if (Name == null)
		{
			throw new NullArgumentException("Name");
		}
		m_Name = Name;
	}
	
	public PhotoObject(String Filename, String Name, String Description) throws IOException 
	{
		this(Filename, Name);
		if (Description == null)
		{
			throw new NullArgumentException("Description");
		}
		m_Description = Description;
	}
	
	
	public String getFileName()
	{
		String retval = m_Filename;
		if (retval == null)
		{
			retval = "";
		}
		return retval;
	}
	public String getName()
	{
		String retval = m_Name;
		if (retval == null)
		{
			retval = "";
		}
		return retval;
	}
	public String getDescription()
	{
		String retval = m_Filename;
		if (retval == null)
		{
			retval = "";
		}
		return retval;
	}
	public String getHash()
	{
		String retval = m_Hash;
		if (retval == null)
		{
			retval = "";
		}
		return retval;
	}
	
	public ImageDimension getDimensions()
	{
		ImageDimension retval = m_Dimensions;
		return retval;
	}
	
	protected String CalculateHash(String Filename, String Hashname) throws IOException, NoSuchAlgorithmException
	{
		String retval = null;
		if (Filename == null)
		{
			throw new NullArgumentException("Filename");
		}
		if (Hashname == null)
		{
			throw new NullArgumentException("Hashname");
		}
	
	MessageDigest md = null;
	InputStream is  = null;
	byte[] digest = null;
	try {
		md = MessageDigest.getInstance(Hashname);
		is = new FileInputStream(Filename);

		is = new DigestInputStream(is, md);
		while(is.read() != -1)
		{
		}
		digest = md.digest();
		}
		finally 
		{
	
			if (is != null)
			{
				is.close();
			}
	}
		
  	   StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<digest.length;i++) {
	    		String hex=Integer.toHexString(0xff & digest[i]);
	   	     	if(hex.length()==1) hexString.append('0');
	   	     	hexString.append(hex);
	    	}
	    retval = hexString.toString();
		return retval;
	}


	protected ImageDimension GetImageSize(String Filename) throws IOException
	{
		ImageDimension retval = new ImageDimension();
		if (Filename == null)
		{
			throw new NullArgumentException("Filename");
		}

		InputStream is  = null;
		BufferedImage bi = null;
		try {
			is = new FileInputStream(Filename);
			bi = ImageIO.read(is);
			retval.Height = bi.getHeight();
			retval.Width = bi.getWidth();
		}
		finally 
		{
			if (is != null)
			{
				is.close();
			}
		}
		return retval;
		
	}
	
}
