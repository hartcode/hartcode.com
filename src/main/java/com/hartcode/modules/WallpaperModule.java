package com.hartcode.modules;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

public class WallpaperModule implements IMainModule {
	protected HttpServletRequest m_request;
	public WallpaperModule()
	{
		
	}
	public String GetMainModule() {
		StringBuilder sb = new StringBuilder();
		Calendar mycal = Calendar.getInstance();
		mycal.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date thedate = mycal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String strdate = sdf.format(thedate);
		sdf = new SimpleDateFormat("yyyyMMdd");
		String strdate2 = sdf.format(thedate);
		sdf = new SimpleDateFormat("yyyy/MM/dd");
		String strdate3 = sdf.format(thedate);
		
		
		sb.append("<div id=\"Other\"><h2>Wallpaper For "+strdate+"</h2><p id=\"first\"> </p><div id='wallpaperout'><div id='wallpaper'><img id='img"+strdate2+"' src='photos/"+strdate3+"/image.jpg' alt='"+strdate2+"' width='640' height='480' /></div></div></div>");
		return sb.toString();
	}
	public void SetRequest(HttpServletRequest request)
	{
		m_request = request;
		
	}

	@Override
	public String GetTitle() {
		String retval = "Wallpaper Of The Day - HartCode";
		return retval;
	}
	@Override
	public String GetDescription() {
		String retval = "The people have spoken. This is the wallpaper of the day.";
		return retval;
	}
	@Override
	public Date GetLastModifiedDate() {
		Calendar mycal = Calendar.getInstance();
		mycal.setTimeZone(TimeZone.getTimeZone("UTC"));
		mycal.add(Calendar.SECOND, -1*mycal.get(Calendar.SECOND));
		mycal.add(Calendar.MINUTE, -1*mycal.get(Calendar.MINUTE));
		mycal.add(Calendar.HOUR, -1*mycal.get(Calendar.HOUR));
		return mycal.getTime();
	}
}
