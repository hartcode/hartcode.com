package modules;

import dataObjects.RSSNews;

public class RSSModule extends IndexModule {

	
	public String GetMainModule() {
		RSSNews rnews = new RSSNews();
		return rnews.toString();
	}

}
