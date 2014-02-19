package com.hartcode.modules;


import java.util.Date;

import com.hartcode.dataObjects.RSSNews;

public class RSSModule extends IndexModule {

	protected Date m_lastmodifieddate;
	
	public String GetMainModule() {
		RSSNews rnews = new RSSNews();
		String retval = rnews.toString();
		m_lastmodifieddate = rnews.GetMostRecentDate();
		return retval;
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
	
	@Override
	public Date GetLastModifiedDate() {
		return m_lastmodifieddate;
	}
}
