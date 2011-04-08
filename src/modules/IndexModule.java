package modules;

import javax.servlet.http.HttpServletRequest;

import dataObjects.HTMLNews;


public class IndexModule implements IMainModule {
	protected HttpServletRequest m_request;
	public IndexModule()
	{
		
	}
	public String GetMainModule() {
		HTMLNews hnews = new HTMLNews();
		return hnews.toString();
	}
	public void SetRequest(HttpServletRequest request)
	{
		m_request = request;
		
	}

}
