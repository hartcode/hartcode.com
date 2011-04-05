package modules;

import dataObjects.HTMLNews;


public class IndexModule implements IMainModule {

	public IndexModule()
	{
		
	}
	public String GetMainModule() {
		HTMLNews hnews = new HTMLNews();
		return hnews.toString();
	}

}
