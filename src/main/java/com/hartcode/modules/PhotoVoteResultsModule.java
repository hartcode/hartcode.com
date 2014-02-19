package com.hartcode.modules;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


import com.hartcode.PhotoADay.VoteDAO2;
import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;


public class PhotoVoteResultsModule implements IMainModule {
	protected HttpServletRequest m_request;
	public PhotoVoteResultsModule()
	{
		
	}
	
	public String GetMainModule() {
		String ip  = m_request.getHeader("X-FORWARDED-FOR");  
        if(ip == null)  
        {  
        	ip = m_request.getRemoteAddr();  
        }
		Calendar mycal = Calendar.getInstance();
		mycal.setTimeZone(TimeZone.getTimeZone("UTC"));
		mycal.add(Calendar.DATE, 1);
		Date thedate = mycal.getTime();
		VoteDAO2 va2 = null;
		try {
			va2 = new VoteDAO2();
		} catch (NullArgumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InvalidPortException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ParserConfigurationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SAXException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		mycal = Calendar.getInstance();
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
		 timeleft += minsleft + " " + minutes +" of voting time left.";
		Long maxcnt = null;
		try {
			maxcnt = va2.GetVoteMaxResults(thedate);
		} catch (Exception e) {
		}
		Integer[][] voteResults = null;				
		try {
			voteResults = va2.GetVoteResults(thedate);
		} catch (Exception e) {
		}
		
		
		if (maxcnt != null && voteResults != null)
		{
		
		sb.append("<div id=\"ChoicesResults\"><h2>Vote Results</h2><p id=\"first\"> </p><h3>Thank you for voting.</h3><p>Here are the results so far, but there are still " + timeleft + "&nbsp;Stop by tomorrow and you can cast your vote on a new set of images.</p>");
		sb.append("<div class=\"choiceleft\">"+ADs.getRandomAd120x600(ip)+"</div>");
		sb.append("<div id='choice'>");
		sb.append("<ul>");
		for (int i = 0; i < voteResults.length;i++)
		{
			double start = voteResults[i][1];
			double end = maxcnt;
			String percentval = getPercentValue(start/end);
			if (i == 2)
			{
				sb.append("</ul><ul class=\"newrow\">");
			}
			sb.append("<li><h3>Choice " +((Integer)(i+1)).toString() + "</h3><p ><img id='img" + voteResults[i][0].toString() + "' src = '/photos/thumb/"+voteResults[i][0].toString()+"/image.jpg' alt='Choice " +((Integer)(i+1)).toString() + "' width='240' height='200' /><br/><br/>"+percentval+"</p></li>");
		}	
		sb.append("</ul>");
		sb.append("</div>");
		sb.append("<div class=\"choiceleft\">"+ADs.getRandomAd120x600(ip)+"</div>");
		
		sb.append("</div>");
		// coin url conversion tracking
		sb.append("<iframe style=\"display: none;\" src=\"https://coinurl.com/track.php?type=int&amp;id=3067\"></iframe>");
		sb.append("<iframe style=\"display: none;\" src=\"https://coinurl.com/track.php?type=banner&amp;id=588\"></iframe>");
		}
		va2.closeConnections();
		return sb.toString();
	}
	 public static String getPercentValue(double value)
	  {
	    //moved from HTMLReport.getPercentValue()
	      value = Math.floor(value * 100) / 100; //to represent 199 covered lines from 200 as 99% covered, not 100 %
	    return NumberFormat.getPercentInstance().format(value);
	  }

	public void SetRequest(HttpServletRequest request) {
		m_request = request;
	}


	@Override
	public String GetTitle() {
		String retval = "Voting Results For The Wallpaper Of The Day - HartCode";
		return retval;
	}
	@Override
	public String GetDescription() {
		String retval = "The ballots are in and here are the results.";
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
