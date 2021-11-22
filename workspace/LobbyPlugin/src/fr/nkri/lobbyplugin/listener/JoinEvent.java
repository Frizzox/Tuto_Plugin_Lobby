package fr.nkri.lobbyplugin.listener;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinEvent implements Listener {
	
	public Location lobby = new Location(Bukkit.getWorld("world"), -30, 3.0, -30);
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		setItemStack(p);
		setPlayer(p);
		setScoreboard(p);
		e.setJoinMessage(p.getName() + " �ba rejoind le lobby.");
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(p.getName() + " �ba quitter le lobby.");
	}
	
	public void setPlayer(Player p) {
		
		p.teleport(lobby);
		
		p.setGameMode(GameMode.ADVENTURE);
		p.setHealth(20);
		p.setWalkSpeed((float) 0.3);
		p.setFoodLevel(20);
		
		p.getInventory().setArmorContents(null);
		p.setExp(0F);
		p.setLevel(0);
	}
	
	public void setItemStack(Player p) {
		p.getInventory().clear();
		
		ItemStack itm = new ItemStack(Material.NETHER_STAR);
		ItemMeta itmM = itm.getItemMeta();
		itmM.setDisplayName("�cMenu de t�l�portation");
		ArrayList<String> lore = new ArrayList<>();
		lore.add("choisisez votre serveur");
		itmM.setLore(lore);
		itm.setItemMeta(itmM);
		p.getInventory().setItem(4, itm);
		
		p.updateInventory();
		
	}
	
	public void setScoreboard(Player p) {
		
		ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
		Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
		Objective obj = scoreboard.registerNewObjective("general", "dummy");
		
		obj.setDisplayName("�cMon Serveur");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.getScore("�6 " + p.getName()).setScore(11);
		obj.getScore(" ").setScore(10);
		obj.getScore("�cip: �4play.serveur.fr").setScore(9);
		
		p.setScoreboard(scoreboard);
		
	}
	
	
	
	
	
}














