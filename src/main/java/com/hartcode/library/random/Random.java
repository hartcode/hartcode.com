package com.hartcode.library.random;

import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class Random {
	static Logger logger = Logger.getLogger(Random.class);
	
	public static int getRandomInt(int max)
	{
		int retval = 0;
		logger.debug("Getting Random number from 0 to " + max);
		java.security.SecureRandom randomizer = null;
		try {
			logger.debug("Creating Randomizer");
			randomizer = java.security.SecureRandom.getInstance("SHA1PRNG");
			logger.debug("Finished Creating Randomizer Two");
			//randomizer1.setSeed(seed);
		} catch (NoSuchAlgorithmException e1) {
			logger.warn("Couldn't create randomizer. Creating default randomizer.",e1);
			randomizer = new java.security.SecureRandom();
		}
		retval = randomizer.nextInt(max);
		logger.debug("Random Number is " + retval);
		return retval;
	}
}
