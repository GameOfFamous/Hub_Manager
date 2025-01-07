package fr.GameOfFamous.hub_Manager.listeners;

import fr.GameOfFamous.hellstylia_API.Manager.AccountManager;
import fr.GameOfFamous.hellstylia_API.Utils.CreateItem;
import fr.GameOfFamous.hellstylia_API.Utils.SendMessage;
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

        p.getInventory().setItem(4, CreateItem.getSkull("§cLangue",new String[]{"§2Francais : 100%", "§2English : 0%", "§2Deutsch : 0%"},"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGJhOGUwNTA4MTkyYTNlNTkyZTExZjY3NzAxMmZiMTg4OTVmNGZlNzQzZjg4MjdkOTJjNDMxMDJiODQ4YjBmZSJ9fX0="));
        p.getInventory().setItem(0, CreateItem.newItem(Material.COMPASS, 1, "§cNavigation", false, new String[]{}));
        p.getInventory().setItem(8, PlayerVisibilityToggle.createHidePlayersItem());

        SendMessage.sendTitle(p, "§cHellstylia", "§6Aucun serveur en ligne");
        SendMessage.sendClickableMessage(p, "§dVisitez nôtre discord pour plus d'informations ! Click ici !", "https://discord.gg/JU5QP2fCVG");
    }

}
