package fr.GameOfFamous.hub_Manager.listeners;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import fr.GameOfFamous.hub_Manager.Hub_Manager;
import fr.GameOfFamous.hub_Manager.Utils.menus.*;
import fr.gameoffamous.hellstyliaAPI.playerUtils.AccountManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class inventoryClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ItemStack current = e.getCurrentItem();
        e.setCancelled(true);

        if (e.getView().getTitle().equalsIgnoreCase("§7Navigation")) {

            // Utilisation de ByteArrayDataOutput pour la communication BungeeCord
            final ByteArrayDataOutput out = ByteStreams.newDataOutput();

            switch (current.getType()) {
                case GRASS_BLOCK:
                    if (!p.hasPermission("server.*") && !p.hasPermission("server.build")) {
                        p.closeInventory();
                        p.sendMessage("§a[§2Hellstylia§a]§c Vous n'avez pas le grade pour rejoindre ce serveur.");
                        break;
                    }
                    connectToServer(p, "build", out);
                    break;

                case DIAMOND_HOE:
                    if(!p.hasPermission("server.*")){
                        connectToServer(p, "gta", out);
                    }
                    break;

                case REDSTONE_TORCH:
                    if (!p.hasPermission("server.*")) {
                        p.closeInventory();
                        p.sendMessage("§a[§2Hellstylia§a]§c Vous n'avez pas le grade pour rejoindre ce serveur.");
                        break;
                    }
                    connectToServer(p, "dev", out);
                    break;

                case RED_BED:
                    p.closeInventory();
                    BedwarsMenu.openBedwarsMenu(p);
                    break;

                case BARRIER:
                    p.closeInventory();
                    break;

                case PLAYER_HEAD:
                    String displayName = current.getItemMeta() != null ? current.getItemMeta().getDisplayName() : "";
                    if (displayName.equals("§cLangue")) {
                        p.closeInventory();
                        langueMenu.openLangueMenu(p);
                    } else if (displayName.equals(p.getDisplayName())) {
                        p.closeInventory();
                        playerMenu.openPlayerMenu(p);
                    }
                    break;

                default:
                    break;
            }
        }
        if (e.getView().getTitle().equalsIgnoreCase("§7Langue")) {
            e.setCancelled(true);

            if (current == null || current.getItemMeta() == null || current.getItemMeta().getDisplayName() == null) {
                return; // Sécurité : empêche les erreurs si l'item ou ses métadonnées sont null
            }

            String displayName = current.getItemMeta().getDisplayName();

            switch (current.getType()) {
                case PLAYER_HEAD:
                    switch (displayName) {
                        case "§7Back":
                            p.closeInventory();
                            navMenu.createNavMenu(p);
                            break;

                        case "§9Francais":
                            AccountManager.changeLangue(p.getUniqueId(), 0);
                            p.sendMessage("§a[§2Hellstylia§a]§7 Votre langue a été définie sur Français.");
                            p.closeInventory();
                            break;

                        case "§9English":
                            AccountManager.changeLangue(p.getUniqueId(), 1);
                            p.sendMessage("§a[§2Hellstylia§a]§7 Your language has been set to English.");
                            p.closeInventory();
                            break;

                        case "§9Deutsch":
                            AccountManager.changeLangue(p.getUniqueId(), 2);
                            p.sendMessage("§a[§2Hellstylia§a]§7 Ihre Sprache wurde auf Deutsch eingestellt.");
                            p.closeInventory();
                            break;

                        default:
                            // Option non reconnue (facultatif)
                            p.sendMessage("§cOption invalide.");
                            break;
                    }
                    break;

                default:
                    break;
            }
        }
        if (e.getView().getTitle().equalsIgnoreCase("§7Statistiques")) {
            e.setCancelled(true);

            if (current == null || current.getItemMeta() == null || current.getItemMeta().getDisplayName() == null) {
                return; // Sécurité : empêche les erreurs si l'item ou ses métadonnées sont null
            }

            String displayName = current.getItemMeta().getDisplayName();

            switch (current.getType()) {
                case PLAYER_HEAD:
                    if (displayName.equals("§7Back")) {
                        p.closeInventory();
                        navMenu.createNavMenu(p);
                    }
                    break;

                case DIAMOND_HOE:
                    p.closeInventory();
                    statistiqueGtaMenu.openGtaStatistiques(p);
                    break;

                default:
                    break;
            }
        }

        if (e.getView().getTitle().equalsIgnoreCase("§7GTA Statistiques")) {
            e.setCancelled(true);

            if (current == null || current.getItemMeta() == null || current.getItemMeta().getDisplayName() == null) {
                return; // Sécurité : empêche les erreurs si l'item ou ses métadonnées sont null
            }

            String displayName = current.getItemMeta().getDisplayName();

            switch (current.getType()) {
                case PLAYER_HEAD:
                    if (displayName.equals("§7Back")) {
                        p.closeInventory();
                        playerMenu.openPlayerMenu(p);
                    }
                    break;

                default:
                    break;
            }
        }

        if (e.getView().getTitle().equalsIgnoreCase("§aServeur Bedwars")) {
            // Utilisation de ByteArrayDataOutput pour la communication BungeeCord
            final ByteArrayDataOutput out = ByteStreams.newDataOutput();
            e.setCancelled(true);

            if (current == null || current.getItemMeta() == null || current.getItemMeta().getDisplayName() == null) {
                return; // Sécurité : empêche les erreurs si l'item ou ses métadonnées sont null
            }

            String displayName = current.getItemMeta().getDisplayName();

            switch (current.getType()) {
                case PLAYER_HEAD:
                    if (displayName.equals("§7Back")) {
                        p.closeInventory();
                        navMenu.createNavMenu(p);
                    }
                    break;

                case RED_BED:
                    connectToServer(p, "bedwarsSolo", out);
                    break;

                default:
                    break;
            }
        }
    }

    private void connectToServer(Player player, String serverName, ByteArrayDataOutput out) {
        out.writeUTF("Connect");
        out.writeUTF(serverName);
        player.sendPluginMessage(Hub_Manager.INSTANCE, "BungeeCord", out.toByteArray());
        player.closeInventory();
    }

}
