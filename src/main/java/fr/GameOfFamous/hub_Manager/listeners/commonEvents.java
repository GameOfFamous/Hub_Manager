package fr.GameOfFamous.hub_Manager.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class commonEvents implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrop(EntityDropItemEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e){e.setCancelled(true);}

    @EventHandler
    public void onHealthDrop(EntityDamageEvent e){e.setCancelled(true);}

    @EventHandler
    public void onFoodDrop(FoodLevelChangeEvent e){e.setCancelled(true);}

    @EventHandler
    public void onMove(InventoryMoveItemEvent e){
        e.setCancelled(true);
    }

}
