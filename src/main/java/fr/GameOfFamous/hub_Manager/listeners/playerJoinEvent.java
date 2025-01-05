package fr.GameOfFamous.hub_Manager.listeners;

import fr.gameoffamous.hellstyliaAPI.Utils.CreateItem;
import fr.gameoffamous.hellstyliaAPI.playerUtils.AccountManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class playerJoinEvent implements Listener {

    Location spawn = new Location(Bukkit.getWorld("world"), 130.5, 88, 103.5);

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();
        UUID uuid = e.getPlayer().getUniqueId();

        AccountManager.loadAccounts(uuid, p);

        p.getInventory().clear();
        p.teleport(spawn);
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));

        p.getInventory().setItem(0, CreateItem.newItem(Material.COMPASS, 1, "§cNavigation", false, new String[]{}));
        p.getInventory().setItem(8, PlayerVisibilityToggle.createHidePlayersItem());
    }

}
