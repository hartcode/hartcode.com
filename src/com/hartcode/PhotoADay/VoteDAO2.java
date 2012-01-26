package com.hartcode.PhotoADay;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;

public class VoteDAO2 {
	protected PhotoADayDAO mydao = null;
	protected Boolean isOKToClose = true;
	public VoteDAO2() throws NullArgumentException, FileNotFoundException, InvalidPortException, ParserConfigurationException, SAXException, IOException
	{
		mydao = new PhotoADayDAO();
	}
	public VoteDAO2(PhotoADayDAO dao)
	{
		mydao = dao;
		isOKToClose = false;
	}
	public void closeConnections()
	{
		/*try {
			if (isOKToClose)
			{
				mydao.closeConnection();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	public  Integer GetUserID(String cookie) throws Exception
	{
		Integer retval = null;
		Object[][] obj = mydao.Select("Select ID from User where Cookie = '" + cookie + "';");
		if (obj == null || obj.length == 0)
		{ 
			throw new Exception("Couldn't get User ID for cookie: " + cookie);
		}else
		{
			retval = (Integer)(obj[0][0]);
		} 
		return retval;
	}
	
	public  Integer NewUser(String ipv4, String cookie) throws Exception
	{
		Integer retval = null;
	
		mydao.ExecuteSql("insert into User (Cookie, ipv4) values ('" + cookie + "','" + ipv4 + "');");
		
		Object[][] obj = mydao.Select("Select ID from User where Cookie = '" + cookie + "';");
		if (obj == null || obj.length == 0)
		{ 
			throw new Exception("Couldn't get User ID for cookie: " + cookie);
		}else
		{
			retval = (Integer)(obj[0][0]);
		} 
		return retval;
	}
	
	public  Boolean hasUserVotedToday(Date today, Integer UserID) throws Exception
	{
		Boolean retval = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(today);
		Object[][] obj = mydao.Select("Select count(*) from CandidateDay cd inner join Candidates c on cd.ID = c.CandidateDayID inner join Votes v on v.CandidateID = c.ID where v.UserID = "+UserID.toString()+" and cd.ShowDate = '" + strdate + "';");
		if (obj == null || obj.length == 0)
		{ 
			retval = false;
		}else
		{
			Long value =(Long)(obj[0][0]);
			if (value > 0)
			{
				retval = true;
			}
		} 
		return retval;
	}
	
	public  Integer[] GetVoteOptions(Date thedate) throws Exception
	{
		Integer[] retval = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(thedate);
		Object[][] obj = mydao.Select("Select PhotoID from vwVoteOptions where ShowDate = '" + strdate + "';");
		if (obj == null || obj.length == 0)
		{ 
			throw new Exception("Couldn't get vote options for date: " + strdate);
		}else
		{
			int rowcount = obj.length;
			retval = new Integer[rowcount];
			for (int ri = 0; ri < rowcount; ri++)
			{
				retval[ri] = (Integer)obj[ri][0];
			}
		} 
		return retval;
	}
	public  Integer[] GetVoteCandidateIDOptions(Date thedate) throws Exception
	{
		Integer[] retval = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(thedate);
		Object[][] obj = mydao.Select("Select CandidateID from vwVoteOptions where ShowDate = '" + strdate + "';");
		if (obj == null || obj.length == 0)
		{ 
			throw new Exception("Couldn't get vote CandidateID options for date: " + strdate);
		}else
		{
			int rowcount = obj.length;
			retval = new Integer[rowcount];
			for (int ri = 0; ri < rowcount; ri++)
			{
				retval[ri] = (Integer)obj[ri][0];
			}
		} 
		return retval;
	}

	public  Integer[] CreateVoteOptions(Date thedate) throws Exception
	{
		Integer[] retval = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(thedate);
		Object[][] obj = mydao.Select("Select ID from CandidateDay where ShowDate = '" + strdate + "';");
		Integer CandidateDayID = null;
		if (obj == null || obj.length == 0)
		{ 
			mydao.ExecuteSql("insert into CandidateDay (ShowDate) values ('"+strdate+"');");
			obj = mydao.Select("Select ID from CandidateDay where ShowDate = '" + strdate + "';");
			if (obj == null || obj.length == 0)
			{ 
				throw new Exception("Couldn't get CandidateDayID for date: " + strdate);
			}else
			{
				CandidateDayID = (Integer)obj[0][0];
			}
		}else
		{
			CandidateDayID = (Integer)obj[0][0];
		}
		for (int i = 0; i < 4; i++)
		{
			Integer ad = PhotoAdder.getRandomPhotoID();
			mydao.ExecuteSql("insert into Candidates (CandidateDayID,PhotoID) values ("+CandidateDayID+","+ad+");");
		}
		obj = mydao.Select("Select PhotoID from vwVoteOptions where ShowDate = '" + strdate + "';");
		if (obj == null || obj.length == 0)
		{ 
			throw new Exception("Couldn't get vote options for date: " + strdate);
		}else
		{
			int rowcount = obj.length;
			retval = new Integer[rowcount];
			for (int ri = 0; ri < rowcount; ri++)
			{
				retval[ri] = (Integer)obj[ri][0];
			}
		}	
		
		
		return retval;
	}
	
	public  void Vote(Integer UserID, Integer CandidateID, Date VoteDate) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strdate = sdf.format(VoteDate);

		Integer[] candidates = null;
		try {
			candidates = GetVoteCandidateIDOptions(VoteDate);
		}catch(Exception e)
		{
			throw e;
		}
		Boolean found = false;
		if (candidates != null)
		{
			for(int i = 0; i<candidates.length;i++)
			{
				if (candidates[i].equals(CandidateID))
				{
					found = true;
				}
			}
			
		}
	
		if (!hasUserVotedToday(VoteDate,UserID) && found)
		{
			mydao.ExecuteSql("insert into Votes (UserID, CandidateID, VoteDate) values ("+UserID+","+CandidateID+",'"+strdate+"');");
		}
	
	}
	
	public  Long GetVoteMaxResults(Date thedate) throws Exception
	{
		Long retval = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(thedate);
		Object[][] obj = mydao.Select("Select maxcnt from vwVoteMaxResults where ShowDate = '" + strdate + "';");
		if (obj == null || obj.length == 0)
		{ 
			retval =(long)0;
		}else
		{
			retval = (Long)(obj[0][0]);
		} 
		return retval;
	}
	
	public  Integer[][] GetVoteResults(Date thedate) throws Exception
	{
		Integer[][] retval = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(thedate);
		Object[][] obj = mydao.Select("Select PhotoID, cnt from vwVoteResults where ShowDate = '" + strdate + "';");
		if (obj == null || obj.length == 0)
		{ 
			retval = null;
			//throw new Exception("Couldn't get vote options for date: " + strdate);
		}else
		{
			int rowcount = obj.length;
			retval = new Integer[rowcount][2];
			
			for (int ri = 0; ri < rowcount; ri++)
			{
				retval[ri][0] = (Integer)obj[ri][0];
				retval[ri][1] = ((Long)obj[ri][1]).intValue();
			}
		} 
		return retval;
	}
}
