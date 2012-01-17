package com.hartcode.PhotoADay;

import java.io.IOException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filename = null; 
		String name = null;
		String desc = null;
		if (args.length > 0)
		{
			filename = args[0];
			if (args.length > 1)
			{
				name = args[1];
				if (args.length > 2)
				{
					desc = args[2];
				}
			}
			
			try {
				PhotoObject ph = null;
				if (name == null && desc == null)
				{
					ph = new PhotoObject(filename);
				}else if (desc == null && name != null)
				{
					ph = new PhotoObject(filename,name);
				}else if (desc != null && name != null)
				{
					ph = new PhotoObject(filename,name,desc);
				}
				if (ph != null)
				{
					PhotoAdder.AddPhoto(ph);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Need filename argument");
		}
		
	}

}
