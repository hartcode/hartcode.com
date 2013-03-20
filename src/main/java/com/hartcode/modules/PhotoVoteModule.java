package com.hartcode.modules;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import net.adscaptcha.AdsCaptchaAPI;

public class PhotoVoteModule implements IMainModule {
	
	// TODO Auto-generated constructor stub
	HttpServletRequest m_request;
	Integer[] photoIDs = null;
	Integer[] candidateIDs = null;
	Integer userID = null;
	Double m_btcvalue = 0.0;
	String m_strbtcvalue = null;
	public PhotoVoteModule(Integer[] pids, Integer[] cids, Integer uid, Double btcvalue)
	{
		photoIDs = pids;
		candidateIDs = cids;
		userID = uid;
		m_btcvalue = btcvalue;
		DecimalFormat df = new DecimalFormat("#.##############");
		m_strbtcvalue = df.format(m_btcvalue * 1000000);
	}
		
	public String GetMainModule() {
		StringBuilder sb = new StringBuilder();
		Calendar mycal = Calendar.getInstance();
		final String captchaId  = "4726";
		final String publicKey  = "5f7e695a-fc65-4a6a-941a-1bd0a5d4f589";
		
		AdsCaptchaAPI adscaptcha = new AdsCaptchaAPI();
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
		sb.append("<div id=\"Choices\"><h2>Vote For Tomorrows Wallpaper</h2><p id=\"first\"> </p><h3>"+timeleft+"</h3><p>There are "+timeleft+"  At the end of the day the winning image will be the wallpaper image of the day. Stand up and let yourself be heard.");
		if (m_btcvalue != 0.0)
		{
			
			sb.append("  If you enter a valid Bitcoin address and correctly solve the captcha you will recieve: " + m_strbtcvalue + " \u00B5BTC.");
		}else
		{
			sb.append("  Sorry we have given out all of our Bitcoins for the day.  While we are beta testing, we are only giving out a limited number of BTC per day.  Please come back tomorrow.");
		}
		sb.append("</p>");
		sb.append("<form action=\"vote\" method=\"get\">");
		sb.append("<p class=\"submitout\"><div class=\"left\">"+ADs.getRandomAd250x250(ip)+"</div><div class=\"left\"><div class=\"btcaddress\"><p>Bitcoin Address: <input type=\"text\" name=\"btcadd\"></p></div></div>");
		sb.append("<div id=\"captcha\">");
		sb.append(adscaptcha.getCaptcha(captchaId, publicKey));
		sb.append("</div></p>");
		sb.append("<p class=\"newrow\"> </p>");
		sb.append("<div class=\"choiceleft\">"+ ADs.getRandomAd120x600(ip)+"</div>");
		sb.append("<div id='choice'><ul >");
		for (Integer i = 0; i < photoIDs.length;i++)
		{
			if (i == 2)
			{
				sb.append("</ul><ul class=\"newrow\">");
			}
			sb.append("<li><h3>Choice " +((Integer)(i+1)).toString() + "</h3><p ><img id='img" + photoIDs[i].toString() + "' src = 'photos/thumb/"+photoIDs[i].toString()+"/image.jpg' alt='Choice " +((Integer)(i+1)).toString() + "' width='240' height='200' /><br/><br/><input type=\"radio\" name=\"cid\" value=\""+candidateIDs[i].toString()+"\">Vote</p></li>");	
		}
		//<a href=\"vote?pid="+photoIDs[i].toString()+"&cid="+candidateIDs[i].toString()+"\" >
		sb.append("</ul></div>");
		sb.append("<div class=\"choiceleft\">"+ ADs.getRandomAd120x600(ip)+"</div>");
		sb.append("<p class=\"submitout\"><input class=\"submit\" type=\"submit\" value=\"Vote\"></p>");
		//sb.append("<input type=\"submit\" value=\"Vote\">");
		sb.append("</form>");
		sb.append("</div>");
		
		
		return sb.toString();
	}

	

public void SetRequest(HttpServletRequest request)
{
	m_request = request;
	
}

}
