package fr.nkri.lobbyplugin.listener;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class ProtectLobby implements Listener {
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if(!e.getPlayer().hasPermission("op")) {
			e.getPlayer().sendMessage("�4Vous ne pouvez pas poser de blocks ici !");
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if(!e.getPlayer().hasPermission("op")) {
			e.getPlayer().sendMessage("�cVous ne pouvez pas drop d'item !");
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onInterract(PlayerInteractEvent e) {
		if(!e.getPlayer().hasPermission("op") && (
				e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK))
                e.setCancelled(true);
	}

	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if(!e.getPlayer().hasPermission("op")) {
			e.getPlayer().sendMessage("�cVous ne pouvez pas faire cela !");
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDammage(EntityDamageEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onSpawn(EntitySpawnEvent e) {
		e.setCancelled(true);
	}

//	@EventHandler
//	public void foodChangeEvent(FoodLevelChangeEvent e) {
//		if(e.getEntityType() == org.bukkit.entity.EntityType.PLAYER) {
//			Player p = (Player) e.getEntity();
//			e.setCancelled(true);
//			if(p.getFoodLevel() < 19.0D) {
//				p.setFoodLevel(20);
//			}
//		}
//	}
	
	
}



















