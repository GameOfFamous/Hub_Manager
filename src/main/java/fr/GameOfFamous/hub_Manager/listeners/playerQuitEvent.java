package fr.GameOfFamous.hub_Manager.listeners;

import fr.GameOfFamous.hellstylia_API.Manager.AccountManager;
import fr.GameOfFamous.hellstylia_API.Manager.FriendManager;
import fr.GameOfFamous.hellstylia_API.Utils.PermissionUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerQuitEvent implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        PermissionUtils.removePerm(p);
        FriendManager.sendFriends(p.getUniqueId());
        AccountManager.sendAccounts(p.getUniqueId());
        System.out.println("Account envoyer");

    }

}
