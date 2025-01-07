package fr.GameOfFamous.hub_Manager.listeners;

import fr.GameOfFamous.hellstylia_API.Manager.AccountManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class chatControl implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String message = e.getMessage();
        UUID uuid = p.getUniqueId();

        // Sécurité : Vérifie si le joueur a un grade défini
        if (AccountManager.getStaff(uuid) == null) {
            e.setFormat("§7[Joueur] " + p.getDisplayName() + " §8>> §f" + message);
            return;
        }

        // Récupération des informations du joueur
        String prefix = AccountManager.getStaff(uuid).getPrefix();
        String color = AccountManager.getStaff(uuid).getColor();
        String displayName = p.getDisplayName();

        // Formatage du message
        String messageFormat = String.format("%s%s%s §8>> §f%s", prefix, color, displayName, message);

        e.setFormat(messageFormat);
    }

}
