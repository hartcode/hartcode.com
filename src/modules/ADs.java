package modules;


import java.util.Vector;

import org.apache.log4j.Logger;

import com.hartcode.library.random.Random;

public class ADs {
	static Logger logger = Logger.getLogger(ADs.class);
	
	public static String getRandomAd()
	{
		logger.debug("Creating AD Vector");
		Vector<String> ads = new Vector<String>();
		ads.add("<iframe src=\"http://rcm.amazon.com/e/cm?t=harttechsol0b-20&o=1&p=10&l=bn1&mode=books&browse=5&fc1=000000&lt1=_blank&lc1=5F636E&bg1=FFFFFF&f=ifr\" marginwidth=\"0\" marginheight=\"0\" width=\"120\" height=\"450\" border=\"0\" frameborder=\"0\" style=\"border:none;\" scrolling=\"no\"></iframe>");
		ads.add("<iframe src=\"http://rcm.amazon.com/e/cm?t=harttechsol0b-20&o=1&p=29&l=ur1&category=endless&banner=0R1FFPJMQ9WGRHF5N8R2&m=endless&f=ifr\" width=\"120\" height=\"600\" scrolling=\"no\" border=\"0\" marginwidth=\"0\" style=\"border:none;\" frameborder=\"0\"></iframe>");
		ads.add("<iframe src=\"http://rcm.amazon.com/e/cm?t=harttechsol0b-20&o=1&p=11&l=ur1&category=endless&banner=1BVYQ4EERJR1M8FKFZR2&m=endless&f=ifr\" width=\"120\" height=\"600\" scrolling=\"no\" border=\"0\" marginwidth=\"0\" style=\"border:none;\" frameborder=\"0\"></iframe>");
		ads.add("<iframe src=\"http://rcm.amazon.com/e/cm?t=harttechsol0b-20&o=1&p=11&l=ur1&category=endless&banner=1GFYPZKFRCBMAEF7KV82&m=endless&f=ifr\" width=\"120\" height=\"600\" scrolling=\"no\" border=\"0\" marginwidth=\"0\" style=\"border:none;\" frameborder=\"0\"></iframe>");
		ads.add("<iframe src=\"http://rcm.amazon.com/e/cm?t=harttechsol0b-20&o=1&p=11&l=ez&f=ifr&f=ifr\" width=\"120\" height=\"600\" scrolling=\"no\" marginwidth=\"0\" marginheight=\"0\" border=\"0\" frameborder=\"0\" style=\"border:none;\"></iframe>");
		ads.add("<iframe src=\"http://rcm.amazon.com/e/cm?t=harttechsol0b-20&o=1&p=14&l=ur1&category=electronicsrot&f=ifr\" width=\"160\" height=\"600\" scrolling=\"no\" border=\"0\" marginwidth=\"0\" style=\"border:none;\" frameborder=\"0\"></iframe>");
		ads.add("<iframe src=\"http://rcm.amazon.com/e/cm?t=harttechsol0b-20&o=1&p=14&l=ur1&category=kindlerotating&f=ifr\" width=\"160\" height=\"600\" scrolling=\"no\" border=\"0\" marginwidth=\"0\" style=\"border:none;\" frameborder=\"0\"></iframe>");
		ads.add("<a target=\"_blank\" href=\"http://affiliate.godaddy.com/redirect/F2BD623D3C26F956B5CBF07FC92987A37FD288DBE90AF7F33377A2DE8F91D51D656F631C9962C4256FE6E0C3231084E4\"><img src=\"http://affiliate.godaddy.com/ads/F2BD623D3C26F956B5CBF07FC92987A37FD288DBE90AF7F33377A2DE8F91D51D656F631C9962C4256FE6E0C3231084E4\" border=\"0\" width=\"120\"  height=\"240\" alt=\"Hosting Your Business Can Count On - GoDaddy.com\"/></a>");
		ads.add("<a target=\"_blank\" href=\"http://affiliate.godaddy.com/redirect/C75FE5B3A8A8A539805E0026BB75F8AC71B3F5CE2057A638844300FBF03378D3C1C8A41C62617245B07442C506EA7586\"><img src=\"http://affiliate.godaddy.com/ads/C75FE5B3A8A8A539805E0026BB75F8AC71B3F5CE2057A638844300FBF03378D3C1C8A41C62617245B07442C506EA7586\" border=\"0\" width=\"120\"  height=\"240\" alt=\"Fast, Secure Hosting for open source apps - GoDaddy.com\"/></a>");
		ads.add("<a target=\"_blank\" href=\"http://affiliate.godaddy.com/redirect/26F04496FBE33781A2F6EACE9BAB7AD7CCDCFC67A25675D797DDB4269FE70B28CADCF3042B214CFB2B3DE3C0D487FA859C9AFCB2334E05B2BBEC6A55F5A74DEC\"><img src=\"http://affiliate.godaddy.com/ads/26F04496FBE33781A2F6EACE9BAB7AD7CCDCFC67A25675D797DDB4269FE70B28CADCF3042B214CFB2B3DE3C0D487FA859C9AFCB2334E05B2BBEC6A55F5A74DEC\" border=\"0\" width=\"120\"  height=\"240\" alt=\"SPECIAL Offer! Save 20% off all New Hosting Plans!\"/></a>");
		ads.add("<a target=\"_blank\" href=\"http://affiliate.godaddy.com/redirect/BFBDAE2B5143A86D6CD81C42A083E0E952EB12F7B9449E4786E6EC22FE6EFD4401DADFBDCEE8204F1C029D35F8920134279782CA5D0F17DE32AC876B83ED57B2\"><img src=\"http://affiliate.godaddy.com/ads/BFBDAE2B5143A86D6CD81C42A083E0E952EB12F7B9449E4786E6EC22FE6EFD4401DADFBDCEE8204F1C029D35F8920134279782CA5D0F17DE32AC876B83ED57B2\" border=\"0\" width=\"120\"  height=\"240\" alt=\"Online File Folder - just $1.99/mo for a year!\"/></a>");
		ads.add("<a target=\"_blank\" href=\"http://affiliate.godaddy.com/redirect/D6DC92E11DCB1FB52FB682F3C7DD122369759C80CCFFBEBF925E4E778C32ABBD4692FB7084832FA6E7AB670FC114485D5E676E421D94FD3ECAA05CAE1BEED973\"><img src=\"http://affiliate.godaddy.com/ads/D6DC92E11DCB1FB52FB682F3C7DD122369759C80CCFFBEBF925E4E778C32ABBD4692FB7084832FA6E7AB670FC114485D5E676E421D94FD3ECAA05CAE1BEED973\" border=\"0\" width=\"120\"  height=\"240\" alt=\"Selling Made Easy with Quick Shopping Cart from GoDaddy.com\"/></a>");
		Integer index = Random.getRandomInt(ads.size());
		logger.debug("Found AD: " +  ads.elementAt(index));
		return ads.elementAt(index);
	}

}
