package com.hartcode.modules;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public interface IMainModule {

	public String GetMainModule();
	public void SetRequest(HttpServletRequest request);
	public String GetTitle();
	public String GetDescription();
	public Date GetLastModifiedDate();
}
