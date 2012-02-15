package com.hartcode.Facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.hartcode.ParameterDecode;
import com.hartcode.Facebook.Objects.AccessTokenData;
import com.hartcode.Facebook.Objects.UserData;
import com.hartcode.exceptions.NullArgumentException;

public class FacebookAPI {

	//public static String domain = "tomcat.dev.home.hartcode.com";
	 public static String domain = "www.hartcode.com";
	static Logger logger = Logger.getLogger(FacebookAPI.class);

	public static void PostVote(AccessTokenData atd,String FBID, Integer PhotoID)
	{
		String input = "access_token="+atd.AccessToken+"&link=http://"+domain+"/Vote&picture=http://"+domain+"/photos/thumb/"+ PhotoID +"/image.jpg&message=I voted today."; 
		String content = MakeFaceBookCall("https://graph.facebook.com/"+FBID+"/feed", "POST", input);
		logger.debug(content);
	}
	
	public static String Logout(AccessTokenData atd, String redirect)
	{
		String retval = "/";
		if (atd == null)
		{
			throw new NullArgumentException();
		}
		
	    
	    retval = "https://www.facebook.com/logout.php?next=" + redirect + "&access_token=" + atd.AccessToken;
	    
		return retval;
		
	}

	public static UserData getUserData(AccessTokenData atd)
	{
		if (atd == null)
		{
			throw new NullArgumentException();
		}
		UserData retval = null;
	    String content= null;
	    
	       content = MakeFaceBookCall("https://graph.facebook.com/me?access_token=" + atd.AccessToken );
	       if (content != null)
	       {
	    	   Gson gson = new Gson();
	    	  retval = gson.fromJson(content, UserData.class);
	    	   
	    	   
	       }
		
		return retval;
	}
	public static AccessTokenData getAccessTokenDataFromCode(String code, String clientid, String redirecturl, String secret) 
	{
		AccessTokenData retval = null; 
	    String content= null;
	    String[][] params;
	       content = MakeFaceBookCall("https://graph.facebook.com/oauth/access_token?client_id="+clientid+"&redirect_uri="+redirecturl+"&client_secret="+secret+"&code=" + code);
	       if (content != null)
	       {
		    params = ParameterDecode.decodeParameters(content);
		    retval = new AccessTokenData();
		    for(int i = 0; i < params.length;i++)
		    {
		    	if (params[i][0].equals("access_token"))
		    	{
		    		retval.AccessToken = params[i][1];
		    	}
		    	if (params[i][0].equals("expires"))
		    	{
		    		Calendar mycal = Calendar.getInstance();
		    		mycal.add(Calendar.SECOND, Integer.parseInt(params[i][1]));
		    		retval.Expires = mycal.getTime();
		    	}
		    }
	       }
	       else 
	       {
	    	   logger.error("content is null");
	       }
		
		 return retval;
	}
	
	public static String MakeFaceBookCall(String url)
	{
		return MakeFaceBookCall(url,200);
	}
	public static String MakeFaceBookCall(String url,Integer expectedcode)
	{
		return MakeFaceBookCall(url,expectedcode,"GET", null);
	}
	public static String MakeFaceBookCall(String url, String method)
	{
		return MakeFaceBookCall(url,200,method,null);
	}
	public static String MakeFaceBookCall(String url, String method, String input)
	{
		return MakeFaceBookCall(url,200,method,input);
	}
	public static String MakeFaceBookCall(String url, Integer expectedcode, String method, String Input)
	{
		String retval = null;
		URL facebookurl = null;
		HttpURLConnection fbconn = null;
		Integer repcode = 0;
		String content = "";
		BufferedReader in;
		try {
			facebookurl = new URL(url);
		} catch (MalformedURLException e) {
			logger.error(e);
		}
		
		try {
			fbconn = (HttpURLConnection) facebookurl.openConnection();
		} catch (IOException e) {
			logger.error(e);
		}
		
		try {
			fbconn.setRequestMethod(method);
			if (Input != null)
			{
				logger.debug("Sending input: " + Input);
			fbconn.setDoOutput(true);
			OutputStreamWriter os = new OutputStreamWriter(fbconn.getOutputStream());
			os.write(Input);
			os.close();
			}
		} catch (ProtocolException e1) {
			logger.error(e1);
		} catch (IOException e) {
			logger.error(e);
		}
		
		try {
			repcode = fbconn.getResponseCode();
		} catch (IOException e) {
			logger.error(e);
		}
		if (!repcode.equals(expectedcode))
		{
			logger.error("Facebook call faild: Responsecode of: " + repcode + " not equal to " +expectedcode+ ". URL:" + url);
			
		}else
		{
			try {
				in = new BufferedReader(
				                        new InputStreamReader(
				                        fbconn.getInputStream()));
			
		    String inputLine;
		    	while ((inputLine = in.readLine()) != null) 
				{	content += inputLine;}
			
				in.close();
		    	if (content.length() > 0)
		    	{
		    		retval = content;
		    	}else
		    	{
		    		logger.warn(" no content returned");
		    	}
			} catch (IOException e) {
				logger.error(e);
			}

		}
		return retval;
	}

}
