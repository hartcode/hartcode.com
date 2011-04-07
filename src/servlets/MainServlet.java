package servlets;
import modules.IMainModule;
import pages.MainPage;

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
	
    public MainServlet(IMainModule mainmodule, String title, String desc, String navid) {
    	super();
    	m_MainModule = mainmodule;
    	m_Title = title;
    	m_Description = desc;
    	m_NavID = navid;
    }

    public String GetFileData()
    {
		MainPage mp = new MainPage(m_MainModule,m_Title,m_Description,m_NavID);
		return mp.toString();
    }

}