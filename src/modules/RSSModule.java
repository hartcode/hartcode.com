package modules;

import dataObjects.RSSNews;

public class RSSModule implements IMainModule {

	
	public String GetMainModule() {
		RSSNews rnews = new RSSNews();
		return rnews.toString();
	}

}
