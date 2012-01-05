package modules;

import javax.servlet.http.HttpServletRequest;

import dataObjects.HTMLNews;

public class PhotoVoteModule implements IMainModule {

	Integer[] myints = null;
	public PhotoVoteModule(Integer[] ints)
	{
		myints = ints;
	}
	
	public String GetMainModule() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < myints.length;i++)
		{
			sb.append("<img id='" + myints[i].toString() + "' src = '/photos/id/"+myints[i].toString()+"/' alt='"+myints[i].toString()+"' width='66' height='55' />");	
		}
		

		
		return sb.toString();
	}

	

public void SetRequest(HttpServletRequest request)
{
	
	
}

}
