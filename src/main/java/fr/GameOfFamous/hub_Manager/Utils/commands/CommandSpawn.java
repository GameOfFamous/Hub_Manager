package fr.GameOfFamous.hub_Manager.Utils.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {

    Location spawn = new Location(Bukkit.getWorld("world"), 130.5, 88, 103.5);


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        // Vérifie si la commande est bien "spawn"
        if (!label.equalsIgnoreCase("spawn")) {
            return false;
        }

        // Si aucun argument n'est fourni
        if (args.length != 0) {
            commandSender.sendMessage(ChatColor.RED + "Utilisation correcte : /spawn");
            return true;
        }

        // Si l'expéditeur est un joueur
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (spawn.getWorld() == null) {
                player.sendMessage(ChatColor.RED + "Le monde spécifié pour le spawn n'existe pas.");
                return true;
            }
            player.teleport(spawn);
            player.sendMessage(ChatColor.GREEN + "Vous avez été téléporté au spawn !");
        } else {
            commandSender.sendMessage(ChatColor.RED + "Seul un joueur peut utiliser cette commande.");
        }

        return true;
    }
}
