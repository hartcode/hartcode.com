package com.hartcode.modules;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import tk.nekotech.MinecraftPing;
import tk.nekotech.MinecraftPingReply;

import com.hartcode.dataObjects.HTMLNews;


public class MinecraftModule  implements IMainModule {
			protected HttpServletRequest m_request;
			public MinecraftModule()
			{
				
			}
			public String GetMainModule() {
				StringBuilder sb = new StringBuilder();
				sb.append("<h2>Minecraft</h2>");
				sb.append("<div id=\"minecraftdiv\">");
				sb.append("<p>Minecraft is a game about building with blocks by either placing them or destroying them. Watch out in Minecraft, evil creatures lurk in the darkness and the night, make sure to build a hideout before they get you.</p>");
				sb.append("<p>Minecraft is also fun to play with friends. You can team up to build anything you desire and let the imagination run wild, battle the things that go bump in the night. If you are brave enough, travel to The Nether, you will surely be surprised.</p>");
				sb.append("<p>Check it out at: <a href=\"http://www.minecraft.net\">www.minecraft.net</a></p>");
				sb.append("<h3>Our Server:</h3>");
				
				sb.append("<div id=\"serversout\"><div id=\"servers\"><div class=\"center\"><span class=\"bold\">MC.HARTCODE.COM</span><br />");
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
				if (Motd != null)
				{
					//sb.append("<span class=\"bold\">");
					sb.append(Motd);
					//sb.append("</span>");
					
				}
				sb.append("<br />");
				if (maxplayers == -1)
				{
					sb.append("<span class=\"Offline\">Offline</span>");
				}else
				{
					sb.append("<span class=\"Online\">Online</span>");
					sb.append("<br />");
					
					sb.append("<span class=\"bold\">Players:</span> " + onlineplayers.toString() + " / " + maxplayers.toString());
					sb.append("<br />");
					sb.append("<span class=\"bold\">Version:</span> " + Version);
					
				}
				sb.append("<br /><span class=\"bold\">Survival PVP</span>");
				
				
				sb.append("</div>");
				sb.append("<span class=\"bold\">Server Rules:</span>");
				sb.append("<ul>");
				sb.append("<li>No, You can't be OP! (I'm OP)</li>");
				sb.append("<li>No creative mode (All building shall be done the old fashioned way)</li>");
				sb.append("<li>No hacking (You will be global banned)</li>");
				sb.append("<li>Do not meddle in the affairs of OPs (For they aren't subtle, and quick to spawn Withers)</li>");
				sb.append("</ul>");
				sb.append("<span class=\"bold\">Chat Commands:</span>");
				sb.append("<ul>");
				sb.append("<li>/help: Views a list of available commands</li>");
				sb.append("<li>/home: Teleport to your home</li>");
				sb.append("<li>/sethome: Set your home to your current location</li>");
				sb.append("<li>/tpa: Ask a user for permission to teleport to their location</li>");
				sb.append("<li>/tpaccept: Grant a user permission to teleport to your location</li>");
				sb.append("<li>/tpdeny: Deny a user permission to teleport to your location</li>");
				sb.append("<li>/rules: View the server rules</li>");				
				sb.append("</ul>");
				sb.append("</div>");
				sb.append("</div>");
				sb.append("</div>");
				return sb.toString();
			}
			public void SetRequest(HttpServletRequest request)
			{
				m_request = request;
				
			}

			@Override
			public String GetTitle() {
				String retval = "Minecraft - HartCode";
				return retval;
			}
			@Override
			public String GetDescription() {
				String retval = "The official home of the HartCode minecraft server.";
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
