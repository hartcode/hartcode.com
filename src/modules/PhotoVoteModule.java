package modules;

import javax.servlet.http.HttpServletRequest;

import dataObjects.HTMLNews;

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
		sb.append("<div id=\"Choices\"><h2>Vote For Tomorrows Wallpaper</h2><p id=\"first\"></p><ul >");
		for (Integer i = 0; i < photoIDs.length;i++)
		{
			if (i == 2)
			{
				sb.append("</ul><ul class=\"newrow\">");
			}
			sb.append("<li><h3>Choice " +((Integer)(i+1)).toString() + "</h3><p ><a  href='/Vote?cid="+candidateIDs[i].toString()+"'><img id='" + photoIDs[i].toString() + "' src = '/photos/thumb/"+photoIDs[i].toString()+"/image.jpg' alt='"+photoIDs[i].toString()+"' width='240' height='200' /><br/><br/>Vote Now</p></a></li>");	
		}
		sb.append("</ul></div>");
		

		
		return sb.toString();
	}

	

public void SetRequest(HttpServletRequest request)
{
	
	
}

}
