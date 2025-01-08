package fr.GameOfFamous.hub_Manager;

import fr.GameOfFamous.hellstylia_API.Hellstylia_API;
import fr.GameOfFamous.hub_Manager.Utils.Board;
import fr.GameOfFamous.hub_Manager.Utils.commands.CommandSpawn;
import fr.GameOfFamous.hub_Manager.listeners.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class Hub_Manager extends JavaPlugin {

    public static Hub_Manager INSTANCE;

    private Hellstylia_API apiPlugin;

    private BukkitTask task;

    @Override
    public void onEnable() {
        INSTANCE = this;

        Plugin api = getServer().getPluginManager().getPlugin("Hellstylia_API");

        if (api != null && api.isEnabled() && api instanceof Hellstylia_API) {
            this.apiPlugin = (Hellstylia_API) api;
            getLogger().info("Hellstylia_API détecté et initialisé !");
        } else {
            getLogger().severe("Hellstylia_API introuvable ou désactivé ! Assurez-vous qu'il est correctement installé.");
            getServer().getPluginManager().disablePlugin(this);
            return; // Arrête l'exécution de la méthode `onEnable`
        }

        // Enregistrement des canaux de messagerie
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        // Enregistrement des événements
        try {
            getServer().getPluginManager().registerEvents(new playerJoinEvent(), this);
            getServer().getPluginManager().registerEvents(new playerInteractEvent(), this);
            getServer().getPluginManager().registerEvents(new inventoryClickEvent(), this);
            getServer().getPluginManager().registerEvents(new commonEvents(), this);
            getServer().getPluginManager().registerEvents(new playerQuitEvent(), this);
            getServer().getPluginManager().registerEvents(new chatControl(), this);
            getServer().getPluginManager().registerEvents(new PlayerVisibilityToggle(), this);
            getLogger().info("Tous les événements ont été enregistrés avec succès !");
        } catch (Exception e) {
            getLogger().severe("Erreur lors de l'enregistrement des événements : " + e.getMessage());
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Enregistrement des commandes
        try {
            getCommand("spawn").setExecutor(new CommandSpawn());
            getLogger().info("Toutes les commandes ont été enregistrées avec succès !");
        } catch (Exception e) {
            getLogger().severe("Erreur lors de l'enregistrement des commandes : " + e.getMessage());
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Planification de la tâche périodique
        try {
            task = getServer().getScheduler().runTaskTimer(this, Board.getInstance(), 0, 1);
            getLogger().info("Tâche périodique initialisée avec succès !");
        } catch (Exception e) {
            getLogger().severe("Erreur lors de l'initialisation de la tâche périodique : " + e.getMessage());
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        // Annuler la tâche planifiée si elle existe
        if (task != null && !task.isCancelled()) {
            task.cancel();
            getLogger().info("Tâche périodique annulée avec succès.");
        }
    }
}
