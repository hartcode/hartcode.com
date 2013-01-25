package com.hartcode.PhotoADay;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VoteDAO {

	public static Integer GetUserID(String cookie) throws Exception
	{
		Integer retval = null;
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
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
	
	public static Integer NewUser(String ipv4, String cookie) throws Exception
	{
		Integer retval = null;
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
		
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
	
	public static Boolean hasUserVotedToday(Date today, Integer UserID) throws Exception
	{
		Boolean retval = false;
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
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
	
	public static Integer[] GetVoteOptions(Date thedate) throws Exception
	{
		Integer[] retval = null;
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
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
	public static Integer[] GetVoteCandidateIDOptions(Date thedate) throws Exception
	{
		Integer[] retval = null;
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
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

	public static Integer[] CreateVoteOptions(Date thedate) throws Exception
	{
		Integer[] retval = null;
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
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
	
	public static void Vote(Integer UserID, Integer CandidateID, Date VoteDate) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strdate = sdf.format(VoteDate);
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
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
	
	public static Long GetVoteMaxResults(Date thedate) throws Exception
	{
		Long retval = null;
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
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
	
	public static Integer[][] GetVoteResults(Date thedate) throws Exception
	{
		Integer[][] retval = null;
		PhotoADayDAO mydao = null;
		mydao = new PhotoADayDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(thedate);
		Object[][] obj = mydao.Select("Select PhotoID, cnt from vwVoteResults where ShowDate = '" + strdate + "';");
		if (obj == null || obj.length == 0)
		{ 
			throw new Exception("Couldn't get vote options for date: " + strdate);
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
