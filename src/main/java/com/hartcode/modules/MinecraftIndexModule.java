package com.hartcode.modules;

import java.io.IOException;

import tk.nekotech.MinecraftPing;
import tk.nekotech.MinecraftPingReply;

public class MinecraftIndexModule {

	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("<div id=\"minecraftindexdiv\"><h2>Minecraft Server</h2><ul><li><h3>MC.HARTCODE.COM</h3>");
		
		
		MinecraftPing mp = new MinecraftPing();
		String Motd = null;
		Integer onlineplayers = -1;
		Integer maxplayers = -1;
		String ProtocolVersion = null;
		String Version = null;
		try {
			MinecraftPingReply mpr = mp.getPing("mc.hartcode.com", 25565);
			if (mpr != null)
			{
				Motd = mpr.getMotd();
				ProtocolVersion = mpr.getProtocolVersion();
				Version = mpr.getVersion();
				onlineplayers = mpr.getOnlinePlayers();
				maxplayers = mpr.getMaxPlayers();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sb.append("<p>");
		if (maxplayers == -1)
		{
			sb.append("<span class=\"Offline\">Offline</span>");
		}else
		{
			sb.append("<span class=\"Online\">Online</span>");
		}
		
		if (Motd != null)
		{
			//sb.append("<span class=\"bold\">");
			sb.append(" - ");
			sb.append(Motd);
			//sb.append("<br />");
			//sb.append("</span>");
		}
		
		sb.append("</p></li></ul><p><a href=\"http://www.hartcode.com/minecraft\">More ...</a></p></div>");
		return sb.toString();
	}
}
