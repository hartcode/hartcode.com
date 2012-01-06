package modules;

import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;


public class PhotoVoteResultsModule implements IMainModule {
	protected HttpServletRequest m_request;
	Integer m_MaxCnt = null;
	Integer[][] m_VoteResults = null;
	public PhotoVoteResultsModule(Integer[][] voteresults, Long maxcnt)
	{
		m_VoteResults = voteresults;
		m_MaxCnt = maxcnt.intValue();
	}
	
	public String GetMainModule() {
		StringBuilder sb = new StringBuilder();
		sb.append("<div id=\"Choices\"><h2>Vote Results For Tomorrows Wallpaper</h2><p id=\"first\"></p><ul>");
		for (int i = 0; i < m_VoteResults.length;i++)
		{
			double start = m_VoteResults[i][1];
			double end = m_MaxCnt;
			String percentval = getPercentValue(start/end); 
			sb.append("<li><h3>Choice " +((Integer)(i+1)).toString() + "</h3><p ><img id='" + m_VoteResults[i][0].toString() + "' src = '/photos/thumb/"+m_VoteResults[i][0].toString()+"/image.jpg' alt='"+m_VoteResults[i][0].toString()+"' width='240' height='200' /><br/><br/>"+percentval+"</p></li>");	
		}
		sb.append("</ul></div>");		
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
