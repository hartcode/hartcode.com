package com.hartcode.modules;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;


public class PhotoVoteModule implements IMainModule {
	
	// TODO Auto-generated constructor stub
	HttpServletRequest m_request;
	Integer[] photoIDs = null;
	Integer[] candidateIDs = null;
	Integer userID = null;
	public PhotoVoteModule(Integer[] pids, Integer[] cids, Integer uid)
	{
		photoIDs = pids;
		candidateIDs = cids;
		userID = uid;
	}
		
	public String GetMainModule() {
		StringBuilder sb = new StringBuilder();
		Calendar mycal = Calendar.getInstance();
	
		String ip  = m_request.getHeader("X-FORWARDED-FOR");  
        if(ip == null)  
        {  
        	ip = m_request.getRemoteAddr();  
        }
		
		mycal.setTimeZone(TimeZone.getTimeZone("UTC"));
		int hourofday = mycal.get(Calendar.HOUR_OF_DAY);
		int minofhour = mycal.get(Calendar.MINUTE);
		int hoursleft = 23 - hourofday;
		int minsleft = 59 - minofhour;
		String hours = "hour";
		 if (hoursleft>1)
		 {
			 hours+="s";
		 }
		 String minutes = "minute";
		 if (minsleft>1 || minsleft == 0)
		 {
			 minutes+="s";
		 }
		 String timeleft = "";
		 if (hoursleft >0)
		 {
			 timeleft += hoursleft + " "+hours+" and ";
		 }
		 else 
		 {
			 //timeleft += "Hurry only ";
		 }
		 timeleft += minsleft + " " + minutes +" left to vote!";
		sb.append("<div id=\"Choices\"><h2>Vote For Tomorrows Wallpaper</h2><p id=\"first\"> </p><h3>"+timeleft+"</h3><p>There are "+timeleft+"  At the end of the day the winning image will be the wallpaper image of the day. Stand up and let yourself be heard.</p>");
		sb.append("<form action=\"/wallpaper/vote\" method=\"get\">");
		sb.append("<hr/><h3>Choose one of the following wallpaper candidates.</h3>");
		sb.append("<div class=\"choiceleft\">"+ ADs.getRandomAd120x600(ip)+"</div>");
		sb.append("<div id='choice'><ul >");
		for (Integer i = 0; i < photoIDs.length;i++)
		{
			if (i == 2)
			{
				sb.append("</ul><ul class=\"newrow\">");
			}
			sb.append("<li><h3>Choice " +((Integer)(i+1)).toString() + "</h3><p ><img id='img" + photoIDs[i].toString() + "' src = '/photos/thumb/"+photoIDs[i].toString()+"/image.jpg' alt='Choice " +((Integer)(i+1)).toString() + "' width='240' height='200' /><br/><br/><input type=\"radio\" name=\"cid\" value=\""+candidateIDs[i].toString()+"\"/>Vote</p></li>");	
		}
		sb.append("</ul></div>");
		sb.append("<div class=\"choiceleft\">"+ ADs.getRandomAd120x600(ip)+"</div>");
		sb.append("<hr style=\"clear:both;\"/><h3>Submit your vote</h3>");
		sb.append("<p class=\"submitout\"><input class=\"submit\" type=\"submit\" value=\"Vote\"/></p>");
		sb.append("</form>");
		sb.append("</div>");
		
		
		return sb.toString();
	}

	

public void SetRequest(HttpServletRequest request)
{
	m_request = request;
	
}

@Override
public String GetTitle() {
	String retval = "Vote For The Wallpaper Of The Day - HartCode";
	return retval;
}
@Override
public String GetDescription() {
	String retval = "Cast your vote for the wallpaper of the day.";
	return retval;
}

@Override
public Date GetLastModifiedDate() {
	Calendar mycal = Calendar.getInstance();
	mycal.setTimeZone(TimeZone.getTimeZone("UTC"));
	mycal.add(Calendar.SECOND, -1*mycal.get(Calendar.SECOND));
	mycal.add(Calendar.MINUTE, -1*mycal.get(Calendar.MINUTE));
	mycal.add(Calendar.HOUR, -1*mycal.get(Calendar.HOUR));
	return mycal.getTime();
}

}
