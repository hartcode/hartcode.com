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
        super(new MoneyDropModule(),"Money Drop - HartCode Technology Solutions","Catch the money, avoid the bombs. This game is crazy fun.","moneydrop");
    }

	}
