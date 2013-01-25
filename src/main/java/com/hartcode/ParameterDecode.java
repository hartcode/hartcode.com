package com.hartcode;

public class ParameterDecode {
	public static String[][] decodeParameters(String str)
	{
		String[] params1 = str.split("&"); 
	    String[][] params = new String[params1.length][2];
	    for(int i = 0; i < params1.length;i++)
	    {
	    	String[] split = params1[i].split("=");
	    	params[i][0] = split[0];
	    	params[i][1] = split[1];
	    }
		return params;
	}

}
