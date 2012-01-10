package modules;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import com.hartcode.PhotoADay.VoteDAO;


public class PhotoVoteResultsModule implements IMainModule {
	protected HttpServletRequest m_request;
	public PhotoVoteResultsModule()
	{
		
	}
	
	public String GetMainModule() {
		Calendar mycal = Calendar.getInstance();
		mycal.setTimeZone(TimeZone.getTimeZone("UTC"));
		mycal.add(Calendar.DATE, 1);
		Date thedate = mycal.getTime();
		
		StringBuilder sb = new StringBuilder();
		Long maxcnt = null;
		try {
			maxcnt = VoteDAO.GetVoteMaxResults(thedate);
		} catch (Exception e) {
		}
		Integer[][] voteResults = null;				
		try {
			voteResults = VoteDAO.GetVoteResults(thedate);
		} catch (Exception e) {
		}
		if (maxcnt != null && voteResults != null)
		{
		
		sb.append("<div id=\"Choices\"><h2>Vote Results For Tomorrows Wallpaper</h2><p id=\"first\"></p><ul>");
		for (int i = 0; i < voteResults.length;i++)
		{
			double start = voteResults[i][1];
			double end = maxcnt;
			String percentval = getPercentValue(start/end);
			if (i == 2)
			{
				sb.append("</ul><ul class=\"newrow\">");
			}
			sb.append("<li><h3>Choice " +((Integer)(i+1)).toString() + "</h3><p ><img id='" + voteResults[i][0].toString() + "' src = '/photos/thumb/"+voteResults[i][0].toString()+"/image.jpg' alt='"+voteResults[i][0].toString()+"' width='240' height='200' /><br/><br/>"+percentval+"</p></li>");	
		}
		sb.append("</ul></div>");
		}
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




}
