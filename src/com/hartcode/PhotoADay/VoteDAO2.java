package com.hartcode.PhotoADay;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.hartcode.Facebook.Objects.UserData;
import com.hartcode.data.mysql.DAO;
import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;
import com.hartcode.servlets.Login;

public class VoteDAO2 {
	static Logger logger = Logger.getLogger(VoteDAO2.class);
	protected DAO mydao = null;
	protected Boolean isOKToClose = true;
	public VoteDAO2() throws NullArgumentException, FileNotFoundException, InvalidPortException, ParserConfigurationException, SAXException, IOException
	{
		mydao = new PhotoADayDAO();
	}
	public VoteDAO2(DAO dao)
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
	public UserData GetUserData(Integer id) throws Exception
	{
		UserData retval = null;
		Object[][] obj = mydao.Select("Select FirstName, LastName, FBID, Gender, Email,FBLastUpdate, Verified, TimeZone, Locale from FBuser where ID= " + id + ";");
		if (obj == null || obj.length == 0)
		{ 
			throw new Exception("Couldn't get FBUser Data for ID: " + id);
		}else
		{
			retval = new UserData();
			retval.First_Name = (String)(obj[0][0]);
			retval.Last_Name = (String)(obj[0][1]);
			retval.ID = ((Long)(obj[0][2])).toString();
			retval.Gender = (String)(obj[0][3]);
			retval.Email = (String)(obj[0][4]);
			//retval.Updatedtime = (String)(obj[0][5]);
			retval.Verified = (Boolean)(obj[0][6]);
			retval.timezone =(Integer)(obj[0][7]);
			retval.locale = (String)(obj[0][8]);
		} 
	
		return retval;
	}
	
	public  Integer GetFBUserID(String id) throws Exception
	{
		Integer retval = null;
		Object[][] obj = mydao.Select("Select ID from FBuser where FBID= " + id + ";");
		if (obj == null || obj.length == 0)
		{ 
			throw new Exception("Couldn't get FBUser ID for FBID: " + id);
		}else
		{
			retval = (Integer)(obj[0][0]);
		} 
		return retval;
	}
	public  Integer NewUpdateFBUser(UserData ud) throws Exception
	{
		Integer retval = null;
		try 
		{
			retval = GetFBUserID(ud.ID);
			
		}catch (Exception e)
		{
			logger.warn(e);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strdate = null;
		try {
		 strdate = sdf.format(ud.getUpdatedTime());
		}catch(Exception e)
		{
			logger.warn(e);
			
		}
		// Doesn't exist, we need to create a new user record
		String email;
		 String date;
		 String verified;
		 String timezone;
		 String locale;
		 if (ud.Email== null)
		 {
			 email = "NULL";
		 }else
		 {
			 email = "'" + ud.Email+"'";
		 }
		 if (strdate == null)
		 {
			 date = "NULL";
		 }else
		 {
			 date = "'" + strdate+"'";
		 }
		 if (ud.Verified == null)
		 {
			 verified = "NULL";
		 }else
		 {
			 verified =ud.Verified.toString();
		 }
		 if (ud.timezone == null)
		 {
			 timezone = "NULL";
		 }else
		 {
			 timezone =ud.timezone.toString();
		 }
		 if (ud.locale == null)
		 {
			 locale = "NULL";
		 }else
		 {
			 locale = "'" +ud.locale+"'";
		 }
		if (retval == null)
		{
			mydao.ExecuteSql("insert into FBuser (FBID,FirstName, LastName, Gender, Email,FBLastUpdate,Verified,TimeZone,Locale) values (" + ud.ID + ",'" + ud.First_Name + "','" + ud.Last_Name + "'," +
					"'" + ud.getGender() + "'," +
					 email + "," +
					date + "," +
					verified + "," +
					timezone + "," +
					locale + ");");
			retval = GetFBUserID(ud.ID);
		}else
		{
		 // Exists we should update it with new information.
			mydao.ExecuteSql("update FBuser set FirstName = '" + ud.First_Name + "', LastName='" + ud.Last_Name + "',Gender = '" + ud.getGender() + "'," +
					" Email = " + email + "," +
					" FBLastUpdate= " + date + "," +
					" Verified = " + verified + "," +
					" TimeZone = " + timezone + "," +
					" Locale = " + locale + " where FBID = " + ud.ID + " ;");
		}
		
		return retval;
	}
	
	public  Integer GetUserComputerID(String cookie) throws Exception
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
	
	public  Integer NewUserComputer(String ipv4, String cookie) throws Exception
	{
		Integer retval = null;
	
		mydao.ExecuteSql("insert into User (Cookie, ipv4) values ('" + cookie + "','" + ipv4 + "');");
		retval = GetUserComputerID(cookie); 
		return retval;
	}
	
	public  Boolean hasUserVotedToday(Date today, Integer FBUserID, Integer UserComputerID) throws Exception
	{
		Boolean retval = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(today);
		Object[][] obj = mydao.Select("Select count(*) from CandidateDay cd inner join Candidates c on cd.ID = c.CandidateDayID inner join Votes v on v.CandidateID = c.ID where v.FBUserID = "+ FBUserID.toString() +" and cd.ShowDate = '" + strdate + "';");
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
	public  Boolean hasUserVotedToday(Date today, Integer UserComputerID) throws Exception
	{
		Boolean retval = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = sdf.format(today);
		Object[][] obj = mydao.Select("Select count(*) from CandidateDay cd inner join Candidates c on cd.ID = c.CandidateDayID inner join Votes v on v.CandidateID = c.ID where v.UserID = "+UserComputerID.toString()+" and cd.ShowDate = '" + strdate + "';");
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

	public  void Vote(Integer FBUserID, Integer UserID, Integer CandidateID, Date VoteDate) throws Exception
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
		if (!hasUserVotedToday(VoteDate,FBUserID,UserID) && found)
		{
			mydao.ExecuteSql("insert into Votes (UserID,FBUserID, CandidateID, VoteDate) values ("+UserID+","+FBUserID+","+CandidateID+",'"+strdate+"');");
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
