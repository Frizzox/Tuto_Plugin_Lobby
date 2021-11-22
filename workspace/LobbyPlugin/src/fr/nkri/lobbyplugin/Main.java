package fr.nkri.lobbyplugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.nkri.lobbyplugin.listener.MenuTeleport;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		System.out.println("[Lobby Plugin]");
		
		new EventManager(this).registerEvents();
		getServer().getPluginManager().registerEvents(new MenuTeleport(this), this);
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}
	 
	
	/*
	 * Bungeecord
	 */
	public void sendToServer(Player p, String serv) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		
		try {
			out.writeUTF("Connect");
			out.writeUTF(serv);
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		Bukkit.getPlayer(p.getName()).sendPluginMessage(this, "BungeeCord", b.toByteArray());
	}
	
	

}
