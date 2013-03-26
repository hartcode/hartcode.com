package com.hartcode.modules;

import com.hartcode.dataObjects.RSSNews;

public class RSSModule extends IndexModule {

	
	public String GetMainModule() {
		RSSNews rnews = new RSSNews();
		return rnews.toString();
	}

	@Override
	public String GetTitle() {
		String retval = "";
		return retval;
	}
	@Override
	public String GetDescription() {
		String retval = "";
		return retval;
	}
}
