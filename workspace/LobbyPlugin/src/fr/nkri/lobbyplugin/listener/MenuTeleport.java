package fr.nkri.lobbyplugin.listener;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.nkri.lobbyplugin.Main;

public class MenuTeleport implements Listener {
	
	Main main;
	
	public MenuTeleport(Main main) {
		this.main = main;
	}
	
	public Location pvp = new Location(Bukkit.getWorld("pvp"), 0, 0, 0);
	
	private ItemStack getItem(String name, Material material, String[] lore) {
		ItemStack it = new ItemStack(material, 1);
		ItemMeta m = it.getItemMeta();
		m.setDisplayName(name);
		m.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
		m.addItemFlags(new ItemFlag[] {
				ItemFlag.HIDE_ENCHANTS
		});
		m.setLore(Arrays.asList(lore));
		it.setItemMeta(m);
		return it;
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR) {
			ItemStack itm = e.getItem();
			if(itm.getType() == Material.NETHER_STAR) {
				Inventory inv = Bukkit.createInventory(null, 27, "§cMenu de téléportation");
				
				inv.setItem(12, getItem("§cServeur PVP", Material.DIAMOND_SWORD, new String[] {"§cINFO:", "§4test"}));
				
				e.getPlayer().openInventory(inv);
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player p = (Player) e.getWhoClicked();
		ItemStack current = e.getCurrentItem();
		
		if(current == null) return;
		
		if(inv.getName().equalsIgnoreCase("§cMenu de téléportation")) {
			
			e.setCancelled(true);
			
			if(current.getType() == Material.DIAMOND_SWORD) {
				p.closeInventory();
				
				this.main.sendToServer(p, "pvp");
			}
		}
	}
	

}
















