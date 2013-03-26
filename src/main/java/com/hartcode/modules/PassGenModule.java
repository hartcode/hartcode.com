package com.hartcode.modules;


public class PassGenModule extends IndexModule {

	public String GetMainModule() {
		StringBuilder sb = new StringBuilder();
		sb.append("<h2>Password Generator</h2>");
		sb.append("<p>Password: <input id=\"pass\" type=\"text\" name=\"pass\" value=\"\" readonly=\"readonly\" size=\"50\" /></p>");
		sb.append("<form action=\"/PasswordGenerator\" method=\"GET\"><fieldset>");
		sb.append("<p><label for=\"size\" >Length (4-32): </label><input id=\"size\" type=\"text\" name=\"size\" value=\"8\" size=\"3\" maxlength=\"3\" /></p>");
		sb.append("<div><input id=\"Alpha\" type=\"checkbox\" name=\"Alpha\" checked=\"checked\" onclick=\"toggle('alphaoptions','Alpha');\" /><label for=\"Alpha\" onclick=\"toggle('alphaoptions','Alpha');\">Use Alpha</label></div>");
		sb.append("<div id=\"alphaoptions\" >");
		sb.append("<div><input id=\"low\" type=\"radio\" name=\"caseop\" value=\"low\"  /> <label for=\"low\" >Lower Case Only</label></div>");
		sb.append("<div><input id=\"high\" type=\"radio\" name=\"caseop\" value=\"high\"  /> <label for=\"high\" >Upper Case Only</label></div>");
		sb.append("<div><input id=\"both\" type=\"radio\" name=\"caseop\" value=\"both\" checked=\"checked\" /> <label for=\"both\" >Both Upper and Lower Cases</label></div>");
		sb.append("</div>");
		sb.append("<div><input id=\"Numeric\" type=\"checkbox\" name=\"Numeric\" checked=\"checked\"  /> <label for=\"Numeric\" >Use Numeric</label></div>");
		sb.append("<div><input id=\"Special\" type=\"checkbox\" name=\"Special\" checked=\"checked\"  /> <label for=\"Special\" >Use Special Characters</label></div>");
		sb.append("<button type=\"button\" onclick=\"generatePassword()\">Generate</button>");
		sb.append("</fieldset></form>"); 
		return sb.toString();
	}
	@Override
	public String GetTitle() {
		String retval = "Password Generator - HartCode";
		return retval;
	}
	@Override
	public String GetDescription() {
		String retval =  "A Simple Password Generator.";
		return retval;
	}	
	
}
