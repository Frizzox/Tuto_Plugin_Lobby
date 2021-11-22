package fr.nkri.lobbyplugin.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatConfig implements Listener {
	
	@EventHandler
	public void SpeakChat(PlayerChatEvent e) {
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			pls.sendMessage("§8[§7Joueur§8] §7" + e.getPlayer().getName() + "§7» §f" + e.getMessage().substring(1));
		}
	}

}