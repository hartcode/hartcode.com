package servlets;


import modules.MoneyDropModule;

/**
 * Servlet implementation class IndexPage
 */
public class MoneyDropPage extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MoneyDropPage() {
        super(new MoneyDropModule(),"HartCode - Money Drop","Catch the money, avoid the bombs.","moneydrop");
    }

	}
