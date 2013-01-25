package com.hartcode.modules;

import com.hartcode.dataObjects.RSSNews;

public class RSSModule extends IndexModule {

	
	public String GetMainModule() {
		RSSNews rnews = new RSSNews();
		return rnews.toString();
	}

}
