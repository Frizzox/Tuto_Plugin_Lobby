package fr.nkri.lobbyplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.nkri.lobbyplugin.listener.ChatConfig;
import fr.nkri.lobbyplugin.listener.JoinEvent;
import fr.nkri.lobbyplugin.listener.MenuTeleport;
import fr.nkri.lobbyplugin.listener.ProtectLobby;

public class EventManager {
	
	public Plugin plugin;
	public PluginManager pm;
	
	public EventManager(Plugin plugin) {
		this.plugin = plugin;
		pm = Bukkit.getPluginManager();
	}
	
	public void registerEvents() {
		pm.registerEvents(new ProtectLobby(), plugin);
		pm.registerEvents(new JoinEvent(), plugin);
		pm.registerEvents(new ChatConfig(), plugin);
	}

}
