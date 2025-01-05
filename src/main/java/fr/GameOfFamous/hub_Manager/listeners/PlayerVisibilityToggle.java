package fr.GameOfFamous.hub_Manager.listeners;

import fr.GameOfFamous.hub_Manager.Hub_Manager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerVisibilityToggle implements Listener {

    // Liste des joueurs qui ont caché les autres joueurs
    private static final Set<Player> hiddenPlayers = new HashSet<>();

    /**
     * Création de l'item pour cacher les joueurs
     */
    public static ItemStack createHidePlayersItem() {
        ItemStack item = new ItemStack(Material.GREEN_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Cacher les joueurs");
        meta.setLore(List.of(ChatColor.GRAY + "Cliquez pour cacher les joueurs."));
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Création de l'item pour afficher les joueurs
     */
    public static ItemStack createShowPlayersItem() {
        ItemStack item = new ItemStack(Material.GRAY_DYE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Afficher les joueurs");
        meta.setLore(List.of(ChatColor.GRAY + "Cliquez pour afficher les joueurs."));
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Gestion du clic pour basculer entre cacher/afficher les joueurs
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item == null || !item.hasItemMeta() || item.getItemMeta().getDisplayName() == null) return;

        String itemName = item.getItemMeta().getDisplayName();

        if (itemName.equals(ChatColor.RED + "Cacher les joueurs")) {
            // Cacher les joueurs
            for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
                player.hidePlayer(otherPlayer);
            }
            if(hiddenPlayers.contains(player)) return;
            hiddenPlayers.add(player);

            new BukkitRunnable(){

                @Override
                public void run() {
                    // Changer l'item pour "Afficher les joueurs"
                    player.getInventory().setItem(8, createShowPlayersItem());
                    player.sendMessage(ChatColor.YELLOW + "Vous avez caché tous les joueurs !");
                    cancel();
                }
            }.runTaskLater(Hub_Manager.INSTANCE, 10L);
        } else if (itemName.equals(ChatColor.GREEN + "Afficher les joueurs")) {
            // Afficher les joueurs
            for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
                player.showPlayer(otherPlayer);
            }
            if(!hiddenPlayers.contains(player)) return;
            hiddenPlayers.remove(player);

            new BukkitRunnable(){

                @Override
                public void run() {
                    // Changer l'item pour "Cacher les joueurs"
                    player.getInventory().setItem(8, createHidePlayersItem());
                    player.sendMessage(ChatColor.YELLOW + "Vous voyez à nouveau tous les joueurs !");
                    cancel();
                }
            }.runTaskLater(Hub_Manager.INSTANCE, 10L);
        }
    }

}
