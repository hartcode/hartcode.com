package modules;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.hartcode.PhotoADay.VoteDAO;
import com.hartcode.PhotoADay.VoteDAO2;
import com.hartcode.exceptions.InvalidPortException;
import com.hartcode.exceptions.NullArgumentException;


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
			sb.append("<li><h3>Choice " +((Integer)(i+1)).toString() + "</h3><p ><img id='" + voteResults[i][0].toString() + "' src = '/photos/thumb/"+voteResults[i][0].toString()+"/image.jpg' alt='Choice " +((Integer)(i+1)).toString() + "' width='240' height='200' /><br/><br/>"+percentval+"</p></li>");	
		}
		sb.append("</ul></div>");
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




}
