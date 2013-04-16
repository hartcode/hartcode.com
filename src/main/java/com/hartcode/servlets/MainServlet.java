package com.hartcode.servlets;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.hartcode.modules.IMainModule;
import com.hartcode.pages.MainPage;


public class MainServlet extends ServletPage {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	protected IMainModule m_MainModule;
	protected String m_Title;
	protected String m_Description;
	protected String m_NavID;
	
	protected MainServlet(){
		super();
	}
	
    public MainServlet(IMainModule mainmodule, String navid) {
    	super();
    	m_MainModule = mainmodule;
    	m_NavID = navid;
    }

    public String GetFileData(HttpServletRequest request)
    {
    	m_MainModule.SetRequest(request);
    	MainPage mp = new MainPage(m_MainModule,m_NavID,request);
		return mp.toString();
    }
    public String PostFileData(HttpServletRequest request)
    {
    	return GetFileData(request);
    }
    
    @Override
    public Date GetLastModifiedDate()
    {
    	return m_MainModule.GetLastModifiedDate();
    }

}