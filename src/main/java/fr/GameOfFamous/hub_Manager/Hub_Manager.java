package fr.GameOfFamous.hub_Manager;

import fr.GameOfFamous.hellstylia_API.Hellstylia_API;
import fr.GameOfFamous.hub_Manager.Utils.Board;
import fr.GameOfFamous.hub_Manager.Utils.commands.CommandSpawn;
import fr.GameOfFamous.hub_Manager.listeners.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class Hub_Manager extends JavaPlugin {

    private Hellstylia_API apiPlugin;
    public static Hub_Manager INSTANCE;

    private BukkitTask task;

    @Override
    public void onEnable() {

        INSTANCE = this;

        Plugin api = getServer().getPluginManager().getPlugin("HellstyliaAPI");

        if (api instanceof Hellstylia_API) {
            this.apiPlugin = (Hellstylia_API) api;
            getLogger().info("HellstyliaAPI détecté et initialisé !");
        } else {
            getLogger().severe("HellstyliaAPI introuvable !");
            getServer().getPluginManager().disablePlugin(this);
        }

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        getServer().getPluginManager().registerEvents(new playerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new playerInteractEvent(),this);
        getServer().getPluginManager().registerEvents(new inventoryClickEvent(), this);
        getServer().getPluginManager().registerEvents(new commonEvents(), this);
        getServer().getPluginManager().registerEvents(new playerQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new chatControl(), this);
        getServer().getPluginManager().registerEvents(new PlayerVisibilityToggle(), this);

        getCommand("spawn").setExecutor(new CommandSpawn());

        task = getServer().getScheduler().runTaskTimer(this, Board.getInstance(), 0, 1);

    }

    @Override
    public void onDisable() {
        if(task != null && !task.isCancelled()){
            task.cancel();
        }
    }
}
