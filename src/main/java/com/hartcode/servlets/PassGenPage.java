package com.hartcode.servlets;
import javax.servlet.http.HttpServletRequest;

import com.hartcode.modules.PassGenModule;
import com.hartcode.passgen.generators.AlphaGenerator;
import com.hartcode.passgen.generators.CaseOption;
import com.hartcode.passgen.generators.MixedWeightedGenerator;
import com.hartcode.passgen.generators.NumericGenerator;
import com.hartcode.passgen.generators.SpecialGenerator;


/**
 * Servlet implementation class PassGenPage
 */
public class PassGenPage extends MainServlet  {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see MainServlet#MainServlet()
     */
    public PassGenPage() {
        super(new PassGenModule(), "passgen");
    }
    
    public String PostFileData(HttpServletRequest request)
    {
    	String retval = "hartcode.com";
    	//String strErr = "";
    	String alphacheck = request.getParameter("Alpha");
		String numericcheck = request.getParameter("Numeric");
		String specialcheck = request.getParameter("Special");
		String size = request.getParameter("size");
		String caseop = request.getParameter("caseop");

		// check Alphacheck
		boolean usealpha = true;
		if (alphacheck == null || alphacheck.equals("false"))
		{
			usealpha = false;
		}
		// check Numericcheck
		boolean usenumeric = true;
		if (numericcheck == null || numericcheck.equals("false"))
		{
			usenumeric = false;
		}
		// check Specialcheck
		boolean usespecial = true;
		if (specialcheck == null || specialcheck.equals("false"))
		{
			usespecial = false;
		}
		
		// Check size
		int intsize = 8;
		try 
		{
			intsize = Integer.parseInt(size);
		}catch (NumberFormatException nfe)
		{
			intsize = 8;
		}
		if (intsize < 4)
		{
			intsize = 4;
			//strErr = "Error: Length cannot be less than 4.";
		}else if (intsize > 32)
		{
			intsize = 32;
			//strErr = "Error: Length cannot be greater than 32.";
		}
		// Check CaseOption
		CaseOption co = CaseOption.BothUpperAndLower;
		if (caseop != null && caseop != "")
		{
			if (caseop.equals("low"))
			{
				co = CaseOption.LowerCase;
			}else if (caseop.equals("high"))
			{
				co = CaseOption.UpperCase;
			}else if (caseop.equals("both"))
			{
				co = CaseOption.BothUpperAndLower;
			}
		}
		
		MixedWeightedGenerator mg = new MixedWeightedGenerator();
		if (usespecial)
		{
			mg.AddGenerator(new SpecialGenerator(),10);
		}
		if (usenumeric)
		{
			mg.AddGenerator(new NumericGenerator(),30);
		}
		if (usealpha)
		{
			mg.AddGenerator(new AlphaGenerator(co));
		}

		try {
			retval = mg.Generate(intsize);
		} catch (Exception e) {
			//strErr = "Error: " + e.getMessage();
		}
    	return retval;
    }
    
}
