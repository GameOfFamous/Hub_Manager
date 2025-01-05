package fr.GameOfFamous.hub_Manager.listeners;

import fr.gameoffamous.hellstyliaAPI.playerUtils.AccountManager;
import fr.gameoffamous.hellstyliaAPI.playerUtils.FriendManager;
import fr.gameoffamous.hellstyliaAPI.playerUtils.PermissionUtils;
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
