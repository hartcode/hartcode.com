package com.hartcode.modules;

import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;


public class PhotoVoteModule implements IMainModule {

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
			 timeleft += "Hurry only ";
		 }
		 timeleft += minsleft + " " + minutes +" left to vote!";
		sb.append("<div id=\"Choices\"><h2>Vote For Tomorrows Wallpaper</h2><h3>"+timeleft+"</h3><p id=\"first\"></p><ul >");
		for (Integer i = 0; i < photoIDs.length;i++)
		{
			if (i == 2)
			{
				sb.append("</ul><ul class=\"newrow\">");
			}
			sb.append("<li><h3>Choice " +((Integer)(i+1)).toString() + "</h3><p ><a  href='Vote?cid="+candidateIDs[i].toString()+"'><img id='" + photoIDs[i].toString() + "' src = 'photos/thumb/"+photoIDs[i].toString()+"/image.jpg' alt='Choice " +((Integer)(i+1)).toString() + "' width='240' height='200' /><br/><br/>Vote Now</p></a></li>");	
		}
		sb.append("</ul></div>");
		

		
		return sb.toString();
	}

	

public void SetRequest(HttpServletRequest request)
{
	
	
}

}
