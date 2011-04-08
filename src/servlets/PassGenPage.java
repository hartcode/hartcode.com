package servlets;
import modules.PassGenModule;

/**
 * Servlet implementation class PassGenPage
 */
public class PassGenPage extends MainServlet  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see MainServlet#MainServlet()
     */
    public PassGenPage() {
        super(new PassGenModule(), "Hart Password Generator", "Password Generator", "passgen");
    }
    

}
