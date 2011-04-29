package servlets;

import modules.ZomboneModule;

/**
 * Servlet implementation class IndexPage
 */
public class ZombonePage extends MainServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ZombonePage() {
        super(new ZomboneModule(),"Zombone - HartCode Technology Solutions","A zombie stomping, gunshooting, whipping good time.","zombone");
    }


}
