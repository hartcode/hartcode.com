package modules;

import com.hartcode.passgen.generators.*;

public class PassGenModule extends IndexModule {

	public String GetMainModule() {
		String generatedpass = "hartcode.com";
		String alphacheck = checkCheckbox(m_request.getParameter("Alpha"));
		String numericcheck = checkCheckbox(m_request.getParameter("Numeric"));
		String specialcheck = checkCheckbox(m_request.getParameter("Special"));
		String size = m_request.getParameter("size");
		String strErr = "";
		String lowcase = "";
		String upcase = "";
		String bothcase = "checked=\"checked\"";
		String alphaoptionshidden = "";
		CaseOption co = CaseOption.BothUpperAndLower;
		String caseop = m_request.getParameter("caseop");
		if (caseop != null)
		{
		if (caseop.equals("low"))
		{
			upcase = "";
			lowcase =  "checked=\"checked\"";
			bothcase = "";
			co = CaseOption.LowerCase;
		}else if (caseop.equals("high"))
		{
			upcase = "Checked=\"checked\"";
			lowcase = "";
			bothcase = "";
			co = CaseOption.UpperCase;
		}else if (caseop.equals("both"))
		{
			upcase = "";
			lowcase = "";
			bothcase = "checked=\"checked\"";
			co = CaseOption.BothUpperAndLower;
		}
		}
		
		int len = 8;
		try 
		{
			len = Integer.parseInt(size);
		}catch (NumberFormatException nfe)
		{
			len = 8;
		}
		if (m_request.getParameter("ran")== null)
		{
			alphacheck = "checked=\"checked\"";
			numericcheck = "checked=\"checked\"";
			specialcheck = "checked=\"checked\"";
			lowcase = "";
			upcase = "";
			bothcase = "checked=\"checked\"" ;
			co = CaseOption.BothUpperAndLower;
		}
		if (len < 4)
		{
			len = 4;
			strErr = "Error: Length cannot be less than 4.";
		}else if (len > 32)
			{
				len = 32;
				strErr = "Error: Length cannot be greater than 32.";
			}
		MixedWeightedGenerator mg = new MixedWeightedGenerator();
		if (checkCheckBool(specialcheck))
		{
			mg.AddGenerator(new SpecialGenerator(),10);
		}
		if (checkCheckBool(numericcheck))
		{
			mg.AddGenerator(new NumericGenerator(),30);
		}
		if (checkCheckBool(alphacheck))
		{
			mg.AddGenerator(new AlphaGenerator(co));
			alphaoptionshidden = "";
		}
		else 
		{
			alphaoptionshidden = "class=\"hidden\"";
		}
		try {
			generatedpass = mg.Generate(len);
		} catch (Exception e) {
			strErr = "Error: " + e.getMessage();
		}
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("<h2>Password Generator</h2>");
		sb.append("<p>Password: <input type=\"text\" name=\"pass\" value=\""+generatedpass+"\" readonly=\"readonly\" size=\"50\" /> &nbsp;&nbsp;&nbsp;&nbsp;"+strErr+"</p>");
		sb.append("<form action=\"/PasswordGenerator\" method=\"post\"><fieldset>");
		sb.append("<p><label for=\"size\" >Length (4-32): </label><input id=\"size\" type=\"text\" name=\"size\" value=\""+len+"\" size=\"3\" maxlength=\"3\" /></p>");
		sb.append("<div><input id=\"Alpha\" type=\"checkbox\" name=\"Alpha\" "+alphacheck+" onclick=\"toggle('alphaoptions','Alpha');\" /><label for=\"Alpha\"  onclick=\"toggle('alphaoptions','Alpha');\">Use Alpha</label></div>");
		sb.append("<div id=\"alphaoptions\" "+alphaoptionshidden+" >");
		sb.append("<div><input id=\"low\" type=\"radio\" name=\"caseop\" value=\"low\" "+lowcase+" /> <label for=\"low\" >Lower Case Only</label></div>");
		sb.append("<div><input id=\"high\" type=\"radio\" name=\"caseop\" value=\"high\" "+upcase+" /> <label for=\"high\" >Upper Case Only</label></div>");
		sb.append("<div><input id=\"both\" type=\"radio\" name=\"caseop\" value=\"both\" "+bothcase+" /> <label for=\"both\" >Both Upper and Lower Cases</label></div>");
		sb.append("</div>");
		sb.append("<div><input id=\"Numeric\" type=\"checkbox\" name=\"Numeric\" "+numericcheck+" /> <label for=\"Numeric\" >Use Numeric</label></div>");
		sb.append("<div><input id=\"Special\" type=\"checkbox\" name=\"Special\" "+specialcheck+" /> <label for=\"Special\" >Use Special Characters</label></div>");
		sb.append("<input type=\"submit\" value=\"Generate\" />");
		sb.append("<input type=\"text\" name=\"ran\" value=\"g\" class=\"hidden\" />");
		sb.append("</fieldset></form>"); 
		return sb.toString();
	}
	
	public String checkCheckbox(String value)
	{
		String retval = "";
		if (value == null)
		{
			retval = "";
		}else
		{
			retval = "checked=\"checked\"";
		}
		return retval;
	}
	public boolean checkCheckBool(String value)
	{
		boolean retval = false;
		if (value == "checked=\"checked\"")
		{
			retval = true;
		}
		return retval;
	}
	
}
