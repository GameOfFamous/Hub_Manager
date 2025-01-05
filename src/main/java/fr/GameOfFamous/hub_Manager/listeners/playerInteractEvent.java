package fr.GameOfFamous.hub_Manager.listeners;

import fr.GameOfFamous.hub_Manager.Utils.menus.navMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class playerInteractEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){

        Player p = e.getPlayer();
        Action action = e.getAction();
        ItemStack it = e.getItem();

        if(it == null) return;

        if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§cNavigation")){

            navMenu.createNavMenu(p);

        }

    }

}
