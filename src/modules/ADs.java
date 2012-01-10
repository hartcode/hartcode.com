package modules;

import java.security.NoSuchAlgorithmException;
import java.util.Vector;

public class ADs {
	public static String getRandomAd()
	{
		Vector<String> ads = new Vector<String>();
		ads.add("<iframe src=\"http://rcm.amazon.com/e/cm?t=harttechsol0b-20&o=1&p=10&l=bn1&mode=books&browse=5&fc1=000000&lt1=_blank&lc1=5F636E&bg1=FFFFFF&f=ifr\" marginwidth=\"0\" marginheight=\"0\" width=\"120\" height=\"450\" border=\"0\" frameborder=\"0\" style=\"border:none;\" scrolling=\"no\"></iframe>");
		java.security.SecureRandom randomizer = null;
		java.security.SecureRandom randomizer1 = null;
		try {
			randomizer = java.security.SecureRandom.getInstance("SHA1PRNG");
			byte seed[] = randomizer.generateSeed(20);
			randomizer1 = java.security.SecureRandom.getInstance("SHA1PRNG");
			randomizer1.setSeed(seed);
		} catch (NoSuchAlgorithmException e1) {
			randomizer1 = new java.security.SecureRandom();
		}
		Integer index = randomizer1.nextInt(ads.size());
		return ads.elementAt(index);
	}

}
