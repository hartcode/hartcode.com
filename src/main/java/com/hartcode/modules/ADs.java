package com.hartcode.modules;


import java.util.Vector;

import org.apache.log4j.Logger;

import com.hartcode.library.random.Random;

public class ADs {
	static Logger logger = Logger.getLogger(ADs.class);
	
	public static String getRandomAd120x240(String ip)
	{
		String url = null;
		if (ip.startsWith("192.168.2."))
		{
			url = "https://www.hartcode.com/style.1.4.2.css";
			
		}
		else 
		{
			url = "https://coinurl.com/get.php?id=3666&SSL=1";
		}
		logger.debug("Creating AD Vector");
		Vector<String> ads = new Vector<String>();
		ads.add("<iframe scrolling=\"no\" style=\"border: 0; width: 120px; height: 240px;\" src=\""+url+"\"></iframe>");
		Integer index = Random.getRandomInt(ads.size());
		logger.debug("Found AD: " +  ads.elementAt(index));
		//return ads.elementAt(index);
		return "";
	}
	public static String getRandomAd120x600(String ip)
	{
		return "";
	}

	public static String getRandomAd250x250(String ip)
	{
		return "";
	}
}
